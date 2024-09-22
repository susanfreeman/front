//package com.ruoyi;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.alibaba.fastjson.JSON;
//import com.google.gson.JsonObject;
//import com.ruoyi.coin.service.impl.TronUtils;
//import com.ruoyi.common.utils.StringUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.tron.trident.core.ApiWrapper;
//import org.tron.trident.core.contract.Contract;
//import org.tron.trident.core.contract.Trc20Contract;
//import org.tron.trident.core.key.KeyPair;
//import org.tron.trident.proto.Response;
//import org.tron.trident.utils.Convert;
//
//import static com.ruoyi.common.config.datasource.DynamicDataSourceContextHolder.log;
//
///**
// * project RuoYi
// * packageName com.ruoyi
// *
// * @version JDK 8
// * @className Test
// * @date 2024/7/25
// **/
//public class Test {
//
//    public static String privateKey = "8cb69c7911eee21569534f18c5f3e8cc5700ec1b0198143880f18f9277000002";
//    public static String apiKey = "apiKey";//波场申请
//
//    public static void main(String[] args) throws Throwable {
//        String random = RandomStringUtils.random(4, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray());
//        int length = (new Long(333) + "").length();
//        System.out.println(StringUtils.leftPad(new Long(333)+"", 5, random.substring(length-1)));
//
////提交测试
////        System.out.println(JSON.toJSONString(createAddress()));
////
//////        //生成密钥对
//////        KeyPair keyPair = new KeyPair(privateKey);
//////        //地址转换TSY1nu3WrVhgdaLzvWUSMEP2BBLT8h2K9m
//////        System.out.println(keyPair.toHexAddress());
////////        ApiWrapper wrapper = ApiWrapper.ofMainnet(privateKey, apiKey);
////        ApiWrapper wrapper = ApiWrapper.ofNile(privateKey);
//////        //账号查询
////        Response.Account account = wrapper.getAccount("TC9EMvr31ifnSvvSh7uGycmi9GX5fWr2bz");
////        //查询余额
////        System.out.println(account.getBalance());
////        System.out.println(account.getCreateTime());
////
////
////        Long number = wrapper.getNowBlock().getBlockHeader().getRawData().getNumber();
////        System.out.println(number);
//////        Response.BlockListExtention blockByLimitNext = wrapper.getBlockByLimitNext(number - 10, number);
//////        // 区间块列表
//////        List<Response.BlockExtention> blockList = blockByLimitNext.getBlockList();
//////        for (Response.BlockExtention blockExtention : blockList) {
//////            Long trc20_target_block_number = blockExtention.getBlockHeader().getRawData().getNumber();
//////            System.out.println(" 扫描高度:" + trc20_target_block_number);
////////            RedissonUtils.setBucket("EXCHANGE_LISTENER:TRC20", DateUtil.formatDateTime(new Date()) + " 区块高度:" + current_sync_block_number + " 扫描高度:" + trc20_target_block_number);
//////            // 处理块信息
//////            TronUtils.switchDataTransaction(blockExtention);
//////        }
////
////        System.out.println(wrapper.getAccount("TUX2fMUf8PZvSeqBDR3bViwHEjiYRuhcH1"));
////
//////        Response.TransactionInfo transactionInfoById = wrapper.getTransactionInfoById("9dd16b52499571c75259654ed898180e4630e4fd0b13ebddb2063c975834e9ec");
//////        System.out.println(transactionInfoById.getResult());
//////        System.out.println(transactionInfoById.getResultValue());
//////        System.out.println(JSON.toJSONString(transactionInfoById));
//
////        transTrc20("TC9EMvr31ifnSvvSh7uGycmi9GX5fWr2bz", "TPFUi1TmYG8roJed8D443WHeRLpz46zFkN", "999999");
//    }
//
//
////    private ApiWrapper getApiWrapper(String hexPrivateKey) {
////        //配置是否是测试链还是正式链
////        if (tronServiceConfig.getTronDomainOnline()) {
////            // 正式环境需要到Tron申请一个apiKey进行使用
////            // APIKEY获取往后会讲如何获取
////            return ApiWrapper.ofMainnet(hexPrivateKey, tronServiceConfig.getApiKey());
////        } else {
////            // 测试环境不需要apikey
////            return new ApiWrapper("grpc.nile.trongrid.io:50051", "grpc.nile.trongrid.io:50061", hexPrivateKey);
////        }
////    }
////
////
////    /**
////     * TRC20余额
////     * @param address 我的钱包地址
////     * @return 余额
////     */
////    public BigDecimal getTrc20Balance(String address) {
////        ApiWrapper client = getApiWrapper(tronServiceConfig.getHexPrivateKey());
////        // Trc20合约地址
////        Contract contract = client.getContract(tronServiceConfig.getTrc20Address());
////        Trc20Contract token = new Trc20Contract(contract, address, client);
////        BigInteger balanceOf = token.balanceOf(address);
////        BigDecimal divisor = new BigDecimal(tronServiceConfig.getTrc20Decimals());
////        BigDecimal divide = new BigDecimal(balanceOf).divide(divisor, 4, RoundingMode.HALF_UP);
////        client.close();
////        return divide;
////    }
//
////    /**
////     * TRx余额
////     * @param address
////     * @return
////     */
////    @Override
////    public BigDecimal getTRxBalance(String address) {
////        ApiWrapper wrapper = getApiWrapper(tronServiceConfig.getHexPrivateKey());
////        Long balance = wrapper.getAccountBalance(address);
////        BigDecimal divisor = new BigDecimal(tronServiceConfig.getTrc20Decimals());
////        BigDecimal divide = new BigDecimal(balance).divide(divisor, 4, RoundingMode.HALF_UP);
////        wrapper.close();
////        return divide;
////    }
//
//    /**
//     * TRC20 转账
//     * @param fromAddress
//     * @param toAddress
//     * @param amount
//     * @return
//     */
//    public static String transTrc20(String fromAddress, String toAddress, String amount) {
//        try {
//            KeyPair keyPair = new KeyPair(privateKey);
////        ApiWrapper wrapper = ApiWrapper.ofMainnet(keyPair.toPrivateKey());
//            ApiWrapper client = ApiWrapper.ofNile(keyPair.toPrivateKey());
//
////            ApiWrapper client = getApiWrapper(tronServiceConfig.getHexPrivateKey());
//            // 获取合约地址信息
//            org.tron.trident.core.contract.Contract contract = client.getContract("TE1eqN2bWELUAqxeWiMV2yxaXi5tHjfpbD");
//            Trc20Contract token = new Trc20Contract(contract, fromAddress, client);
//            String transfer;
//            // 获取转账账户的TRX余额
//            BigInteger trc20Value = token.balanceOf(fromAddress);
//            // 获取想要转账的数额
//            BigInteger sunAmountValue = Convert.toSun(amount, Convert.Unit.TRX).toBigInteger();
//            // 进行比较
//            if (trc20Value.compareTo(sunAmountValue) >= 0) {
//                log.info("开始转账.........");
//                // 设置最大矿工费用
//                long feeLimit = Convert.toSun("100", Convert.Unit.TRX).longValue();
//                //转账
//                transfer = token.transfer(toAddress, sunAmountValue.longValue(), 0, "转账", feeLimit);
//            } else {
//                return "error_error";
//            }
//            log.info("交易ID:{}", transfer);
//            client.close();
//            return transfer;
//        } catch (Exception ex) {
//            log.info("{}",ex);
//            String message = ex.getMessage();
//            return "error_" + message;
//        }
//    }
//
//
////    /**
////     * TRX转账
////     * @param fromAddress 输入地址
////     * @param toAddress 转账地址
////     * @param amount 金额
////     * @return
////     */
////    @Override
////    public String transferTRX(String fromAddress, String toAddress, int amount) {
////        ApiWrapper wrapper = getApiWrapper(tronServiceConfig.getHexPrivateKey());
////        try {
////            BigDecimal divisor = new BigDecimal(tronServiceConfig.getTrc20Decimals());
////            Long rechangeAmount = new BigDecimal(String.valueOf(amount)).multiply(divisor).longValue();
////            // 创建交易
////            Response.TransactionExtention transaction = wrapper.transfer(fromAddress, toAddress, rechangeAmount);
////            log.info("transaction:{}", transaction);
////            log.info("transaction.Txid:{}", transaction.getTxid());
////            // 签名交易
////            Chain.Transaction signTransaction = wrapper.signTransaction(transaction);
////            log.info("signTransaction:{}", signTransaction);
////            // 计算交易所需要的宽带
////            long byteSize = wrapper.estimateBandwidth(signTransaction);
////            log.info("byteSize:{}", byteSize);
////            // 广播交易
////            String hashTx = wrapper.broadcastTransaction(signTransaction);
////            log.info("hashTRX:{}", hashTx);
////            return hashTx;
////        } catch (Exception e) {
////            log.error("TransactionService#transfer error: {}", e.getMessage());
////        }
////        wrapper.close();
////        return null;
////    }
//
//    /**
//     * 创建地址(离线)
//     */
//    public static Map<String, String> createAddress() {
//        KeyPair keyPair = new KeyPair(privateKey);
//        String privateKey = keyPair.toPrivateKey();
//        String base58CheckAddress = keyPair.toBase58CheckAddress();
//        String publicKey = keyPair.toPublicKey();
//        Map<String, String> stringMap = new HashMap<>();
//        stringMap.put("address", base58CheckAddress);
//        stringMap.put("privateKey", privateKey);
//        stringMap.put("publicKey", publicKey);
//        return stringMap;
//    }
//}
