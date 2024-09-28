package com.ruoyi.web.controller.custom;

import com.ruoyi.coin.service.impl.SafeHeronUtils;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TblCardBinInfo;
import com.ruoyi.system.service.ITblCardBinInfoService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import com.safeheron.client.config.SafeheronConfig;
import com.safeheron.client.response.AccountCoinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ruoyi.common.core.domain.AjaxResult.error;
import static com.ruoyi.common.core.domain.AjaxResult.success;
import static com.ruoyi.common.utils.SecurityUtils.getUserId;

@RestController
public class NomalController {


    @Autowired
    ITblUserInfoService tblUserInfoService;

    @Resource(name = "safeheronConfig")
    private SafeheronConfig safeheronConfig;

    @Value("${support.coinList}")
    private List<String> coinList;

    @Autowired
    ITblCardBinInfoService cardBinInfoService;



    @RequestMapping("/getBalance")
    public AjaxResult getBalance()
    {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        if (null != userInfo) {
            Map dataMap = new HashMap<>();
            dataMap.put("balanceUsd", userInfo.getBalance());
            dataMap.put("balanceEur", userInfo.getBalanceEur());
            dataMap.put("balanceGbp", userInfo.getBalanceGbp());
            dataMap.put("balanceUsdt", userInfo.getBalanceUsdt());
            dataMap.put("kycFlag", userInfo.getKycFlag());
            return success(dataMap);
        }
        return error();
    }

    @GetMapping("/getRechargeList")
    public AjaxResult getRechargeList()
    {
        return success(coinList);
    }

    @GetMapping("/getRechargeAddr")
    public AjaxResult getRechargeAddr()
    {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        if (null != userInfo) {
            List<AccountCoinResponse> accountCoinResponseList = SafeHeronUtils.listAccountCoin(safeheronConfig, userInfo.getTronAddr());
            Map map = new HashMap();
            accountCoinResponseList.forEach(acctCoin ->{
                map.put(acctCoin.getCoinKey(), acctCoin.getAddressList().get(0).getAddress());
            });
            return success(map);
        }
        return error();
    }

    @GetMapping("/getCardBin")
    public AjaxResult getCardBin()
    {
        TblCardBinInfo cardBinInfo = new TblCardBinInfo();
        cardBinInfo.setIsEnable(UserConstants.YES);
        List<TblCardBinInfo> tblCardBinInfos = cardBinInfoService.selectTblCardBinInfoList(cardBinInfo);
        if (null != tblCardBinInfos) {
            return success(tblCardBinInfos);
        }
        return error();
    }

    @GetMapping("/getCardBinByCbid/{cbId}")
    public AjaxResult getCardBinByCbid(@PathVariable Long cbId)
    {
        TblCardBinInfo tblCardBinInfo = cardBinInfoService.selectTblCardBinInfoByCbId(cbId);
        if (null != tblCardBinInfo) {
            return success(tblCardBinInfo);
        }
        return error();
    }

    /**
     * KYC
     */
    @Log(title = "Kyc", businessType = BusinessType.UPDATE)
    @PostMapping("/kyc")
    public AjaxResult kyc(@RequestBody TblUserInfo tblUserInfo) {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        tblUserInfo.setUiId(userInfo.getUiId());
        tblUserInfo.setKycFlag("P");
        tblUserInfoService.updateTblUserInfo(tblUserInfo);
        return success();
    }

}
