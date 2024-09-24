package com.ruoyi.web.controller.custom;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.constant.RedisKeys;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.model.ExchangeBody;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SendGroupMsgTg;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.trans.domain.TblBalanceTrans;
import com.ruoyi.trans.service.ITblBalanceTransService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.ruoyi.common.utils.SecurityUtils.getUserId;

@Slf4j
@RequestMapping("/exchange")
@RestController
public class ExchangeController {

    private static String EXCHANGE_OTHER_FEE = "buss_exchange_other_fee";

    @Autowired
    private RedisCache redisCache;


    @Autowired
    private ITblBalanceTransService tblBalanceTransService;

    @Autowired
    private ITblUserInfoService tblUserInfoService;

    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;


    @PostMapping("/getTargetAmount")
    public AjaxResult getTargetAmount(@RequestBody ExchangeBody exchangeBody) {
        return AjaxResult.success(this.getCurr(exchangeBody.getSourceCurr(), exchangeBody.getTargetCurr(), exchangeBody.getSourceAmount()));
    }

    @PostMapping("/change")
    public AjaxResult change(@RequestBody ExchangeBody exchangeBody) {
        double targetChangeAmount = this.getCurr(exchangeBody.getSourceCurr(), exchangeBody.getTargetCurr(), exchangeBody.getSourceAmount())  ;

        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            TblBalanceTrans sourceTblBalanceTrans = new TblBalanceTrans();
            sourceTblBalanceTrans.setUiId(userInfo.getUiId());
            sourceTblBalanceTrans.setTransAmt(new BigDecimal(exchangeBody.getSourceAmount()));
            sourceTblBalanceTrans.setTransCurr(exchangeBody.getSourceCurr());
            sourceTblBalanceTrans.setUbType("D");
            sourceTblBalanceTrans.setTransTime(new Date());
            sourceTblBalanceTrans.setTransId(0L);
            sourceTblBalanceTrans.setRemark("Exchange sub amount");
            tblBalanceTransService.insertTblBalanceTransByUserBalance(sourceTblBalanceTrans);

            TblBalanceTrans targetBalTrans = new TblBalanceTrans();
            targetBalTrans.setUiId(userInfo.getUiId());
            targetBalTrans.setTransAmt(new BigDecimal(-targetChangeAmount));
            targetBalTrans.setTransCurr(exchangeBody.getTargetCurr());
            targetBalTrans.setUbType("A");
            targetBalTrans.setTransTime(new Date());
            targetBalTrans.setTransId(0L);
            targetBalTrans.setRemark("Exchange Add amount");
            tblBalanceTransService.insertTblBalanceTransByUserBalance(targetBalTrans);

            int i = tblUserInfoService.updateTblUserInfoBalanceExchange(userInfo.getUiId(), exchangeBody.getSourceCurr(), exchangeBody.getTargetCurr(), exchangeBody.getSourceAmount()+"", targetChangeAmount + "");
            dataSourceTransactionManager.commit(transactionStatus); // 手动提交

            if (i > 0) {
                return AjaxResult.success();
            }
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            log.error("兑换金额",e);
            throw new ServiceException("手续费扣除异常，请检查");
        }

        return AjaxResult.error("余额不足，请先充值");
    }

    public double getCurr(String source, String target, double amount) {
        if ("USDT".equals(source)) {
            source = "USD";
        }
        if ("USDT".equals(target)) {
            target = "USD";
        }

        BigDecimal rate = redisCache.getCacheObject(String.format("%s_%s_%s", RedisKeys.REDIS_CHANNEL_NAME.CURR_RATE, source, target));

        if (rate == null || rate.doubleValue() == 0) {
            try {
                String s = HttpUtil.get("https://open.er-api.com/v6/latest/" + source);
//        String s = "{\"result\":\"success\",\"provider\":\"https://www.exchangerate-api.com\",\"documentation\":\"https://www.exchangerate-api.com/docs/free\",\"terms_of_use\":\"https://www.exchangerate-api.com/terms\",\"time_last_update_unix\":1724630551,\"time_last_update_utc\":\"Mon, 26 Aug 2024 00:02:31 +0000\",\"time_next_update_unix\":1724718061,\"time_next_update_utc\":\"Tue, 27 Aug 2024 00:21:01 +0000\",\"time_eol_unix\":0,\"base_code\":\"GBP\",\"rates\":{\"GBP\":1,\"AED\":4.844538,\"AFN\":93.43969,\"ALL\":118.398341,\"AMD\":511.810151,\"ANG\":2.361259,\"AOA\":1205.816653,\"ARS\":1250.767964,\"AUD\":1.946745,\"AWG\":2.361259,\"AZN\":2.244724,\"BAM\":2.307353,\"BBD\":2.638278,\"BDT\":157.709049,\"BGN\":2.307365,\"BHD\":0.495996,\"BIF\":3834.142857,\"BMD\":1.319139,\"BND\":1.718898,\"BOB\":9.112059,\"BRL\":7.306543,\"BSD\":1.319139,\"BTN\":110.171033,\"BWP\":17.652158,\"BYN\":4.27448,\"BZD\":2.638278,\"CAD\":1.784283,\"CDF\":3727.638889,\"CHF\":1.119333,\"CLP\":1204.448848,\"CNY\":9.394769,\"COP\":5312.224619,\"CRC\":689.393166,\"CUP\":31.659334,\"CVE\":130.083046,\"CZK\":29.570881,\"DJF\":234.438691,\"DKK\":8.802772,\"DOP\":78.670735,\"DZD\":176.829048,\"EGP\":64.302591,\"ERN\":19.787084,\"ETB\":145.879713,\"EUR\":1.179735,\"FJD\":2.908433,\"FKP\":1,\"FOK\":8.802573,\"GEL\":3.552827,\"GGP\":1,\"GHS\":20.652431,\"GIP\":1,\"GMD\":92.484256,\"GNF\":11472.184989,\"GTQ\":10.193503,\"GYD\":276.500687,\"HKD\":10.279514,\"HNL\":32.661462,\"HRK\":8.888684,\"HTG\":174.203808,\"HUF\":464.325751,\"IDR\":20451.323198,\"ILS\":4.873015,\"IMP\":1,\"INR\":110.171791,\"IQD\":1727.832618,\"IRR\":56901.885605,\"ISK\":179.89919,\"JEP\":1,\"JMD\":206.363938,\"JOD\":0.93527,\"JPY\":190.254684,\"KES\":169.680946,\"KGS\":112.636673,\"KHR\":5367.8,\"KID\":1.946744,\"KMF\":580.38964,\"KRW\":1751.483662,\"KWD\":0.401707,\"KYD\":1.099282,\"KZT\":638.001572,\"LAK\":28911.174436,\"LBP\":118062.934708,\"LKR\":395.161042,\"LRD\":257.038083,\"LSL\":23.444726,\"LYD\":6.289703,\"MAD\":12.714395,\"MDL\":22.887765,\"MGA\":6005.054665,\"MKD\":72.575,\"MMK\":3628.122632,\"MNT\":4484.002546,\"MOP\":10.587826,\"MRU\":52.536213,\"MUR\":60.643207,\"MVR\":20.313776,\"MWK\":2288.821642,\"MXN\":25.419545,\"MYR\":5.7692,\"MZN\":84.018012,\"NAD\":23.444726,\"NGN\":2089.326457,\"NIO\":48.642263,\"NOK\":13.83474,\"NPR\":176.273652,\"NZD\":2.122939,\"OMR\":0.507205,\"PAB\":1.319139,\"PEN\":4.930534,\"PGK\":5.123844,\"PHP\":74.470843,\"PKR\":367.90753,\"PLN\":5.039787,\"PYG\":10010.527893,\"QAR\":4.801666,\"RON\":5.873254,\"RSD\":138.151186,\"RUB\":120.719533,\"RWF\":1766.652385,\"SAR\":4.946771,\"SBD\":11.156755,\"SCR\":18.851318,\"SDG\":590.300587,\"SEK\":13.470114,\"SGD\":1.7189,\"SHP\":1,\"SLE\":29.568395,\"SLL\":29569.68159,\"SOS\":755.318949,\"SRD\":38.528567,\"SSP\":4021.070105,\"STN\":28.903411,\"SYP\":17292.374945,\"SZL\":23.444726,\"THB\":44.839462,\"TJS\":13.907927,\"TMT\":4.611534,\"TND\":3.99618,\"TOP\":3.064067,\"TRY\":44.884985,\"TTD\":8.953023,\"TVD\":1.946744,\"TWD\":41.961719,\"TZS\":3581.406735,\"UAH\":54.130285,\"UGX\":4892.422315,\"USD\":1.319147,\"UYU\":53.156952,\"UZS\":16709.028551,\"VES\":48.265982,\"VND\":32981.433384,\"VUV\":155.514511,\"WST\":3.562248,\"XAF\":773.852853,\"XCD\":3.561675,\"XDR\":0.975114,\"XOF\":773.852853,\"XPF\":140.779668,\"YER\":329.582594,\"ZAR\":23.444766,\"ZMW\":34.589317,\"ZWL\":18.1114}}";
                log.info(String.format("SOURCE_CURR: %s ;TARGET_CURR: %s ;JSON: %s", source, target, s));
                Object parse = JSON.parseObject(s, Map.class);
                rate = new BigDecimal(((Map) ((Map) parse).get("rates")).get(target) + "");
            } catch (Exception e) {
                SendGroupMsgTg.sendGroupMsgTgTech(String.format("汇率数据获取有误！：https://open.er-api.com/v6/latest/%s",source));
                log.info("获取费率有误", e);
                return 0d;
            }
            redisCache.setCacheObject(String.format("%s_%s_%s", RedisKeys.REDIS_CHANNEL_NAME.CURR_RATE, source, target), rate, 600, TimeUnit.SECONDS);
        }

        SysDictData dictData = dictDataService.selectDicValue(EXCHANGE_OTHER_FEE, String.format("%s_%s", source.toLowerCase(), "fee"));
        double other_fee = 0.99d;
        if (dictData != null && StringUtils.isNotBlank(dictData.getDictValue())) {
            try {
                other_fee = new Double(dictData.getDictValue());
            } catch (Exception e) {
                SendGroupMsgTg.sendGroupMsgTg(String.format("系统字典表中滑点费用配置有误:%s",EXCHANGE_OTHER_FEE));
                log.info("滑点费用配置有误", e);
            }
        }

        return Math.floor(amount * rate.doubleValue() * 100) / 100 * other_fee;
    }

}
