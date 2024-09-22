//package com.ruoyi.coin.service.impl;
//
//import com.google.protobuf.ByteString;
//import com.google.protobuf.Message;
//import com.google.protobuf.Type;
//import com.ruoyi.common.constant.Constants;
//import com.ruoyi.common.json.JSONObject;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.client.utils.HttpClientUtils;
//import org.bouncycastle.jcajce.provider.digest.Keccak;
//import org.bouncycastle.util.encoders.Hex;
//import org.tron.trident.abi.FunctionEncoder;
//import org.tron.trident.abi.TypeDecoder;
//import org.tron.trident.abi.TypeReference;
//import org.tron.trident.abi.datatypes.Address;
//import org.tron.trident.abi.datatypes.Bool;
//import org.tron.trident.abi.datatypes.Function;
//import org.tron.trident.abi.datatypes.NumericType;
//import org.tron.trident.abi.datatypes.generated.Uint256;
//import org.tron.trident.core.ApiWrapper;
//import org.tron.trident.core.contract.Trc20Contract;
//import org.tron.trident.core.key.KeyPair;
//import org.tron.trident.core.utils.ByteArray;
//import org.tron.trident.crypto.Hash;
//import org.tron.trident.proto.Chain;
//import org.tron.trident.proto.Contract;
//import org.tron.trident.proto.Response;
//import org.tron.trident.utils.Base58Check;
//import org.tron.trident.utils.Convert;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.math.RoundingMode;
//import java.util.*;
//
//import static com.ruoyi.common.config.datasource.DynamicDataSourceContextHolder.log;
//
//public class TronUtils {
//
//    /**
//     * 创建地址(离线)
//     */
//    public static Map<String, String> createAddress(String privateKey, int num) {
//        KeyPair keyPair = new KeyPair(changePrivateKey(privateKey, num));
//        String base58CheckAddress = keyPair.toBase58CheckAddress();
//        String publicKey = keyPair.toPublicKey();
//        Map<String, String> stringMap = new HashMap<>();
//        stringMap.put("address", base58CheckAddress);
//        stringMap.put("publicKey", publicKey);
//        return stringMap;
//    }
//
//    private static String changePrivateKey(String privateKey, int i) {
//        return privateKey.substring(0, 10) + StringUtils.leftPad(i + "", 6, "f") + privateKey.substring(16);
//    }
//
//    /**
//     * 转换成T开头的地址
//     *
//     * @param hexAddress
//     * @return
//     */
//    public static String toViewAddress(String hexAddress) {
//        return Base58Check.bytesToBase58(ByteArray.fromHexString(hexAddress));
//    }
//
//    /**
//     * 检索块信息，获取交易信息
//     *
//     * @param blockExtention
//     * @throws Throwable
//     */
//    public static Map switchDataTransaction(Response.BlockExtention blockExtention, Map map) throws Throwable {
//        Map retMap = new HashMap();
//        List<Response.TransactionExtention> transactionsList = blockExtention.getTransactionsList();
//        for (Response.TransactionExtention transactionExtention : transactionsList) {
//            List<Chain.Transaction.Contract> contractList = transactionExtention.getTransaction().getRawData().getContractList();
//            for (Chain.Transaction.Contract contract : contractList) {
//                Class a = Class.forName("org.tron.trident.proto.Contract$" + contract.getType());
//                Message unpack = contract.getParameter().unpack(a);
//                // TriggerSmartContract是合约， 按照不同的交易类型检索
//                if (unpack instanceof Contract.TriggerSmartContract) {
//                    // 合约地址
//                    Contract.TriggerSmartContract contractStr = (Contract.TriggerSmartContract) unpack;
//                    ByteString contractAddress = contractStr.getContractAddress();
//                    String hex = ApiWrapper.toHex(contractAddress);
//                    String contractAddressStr = TronUtils.toViewAddress(hex);
//                    // 判断是否是自己需要监控的合约地址
////                    if (tronServiceConfig.getTrc20Address().equalsIgnoreCase(contractAddressStr)) {
////                    if ("TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t".equalsIgnoreCase(contractAddressStr)) {//生产USDT合约地址
//                    if ("TE1eqN2bWELUAqxeWiMV2yxaXi5tHjfpbD".equalsIgnoreCase(contractAddressStr)) {//测试合约地址
//                        ByteString ownerAddress = contractStr.getOwnerAddress();
//                        String hex2 = ApiWrapper.toHex(ownerAddress);
//                        String fromAddress = TronUtils.toViewAddress(hex2);
//                        ByteString data = contractStr.getData();
//                        String hex1 = ApiWrapper.toHex(data);
//                        // 交易类型是转账
//                        String transferFunction = Hex.toHexString(new Keccak.Digest256().digest("transfer(address,uint256)".getBytes())).substring(0, 8);
//                        String funcId = hex1.substring(0, 8);
//                        if (!transferFunction.equals(funcId)) {
//                            continue;
//                        }
//                        String toAddress = hex1.substring(32, 72);
//                        String amount = hex1.substring(72, 136);
//                        try {
//                            Address address = (Address) TypeDecoder.instantiateType("address", toAddress);
//                            // 地址
//                            NumericType amountType = (NumericType) TypeDecoder.instantiateType("uint256", amount);
//                            // 金额
////                            BigDecimal trc20Decimals = new BigDecimal(tronServiceConfig.getTrc20Decimals());
//                            BigDecimal trc20Decimals = new BigDecimal(1000000);
//                            BigDecimal amountee = new BigDecimal(amountType.getValue()).divide(trc20Decimals, 6, RoundingMode.FLOOR);
//
//                            byte[] byteArray = transactionExtention.getTransaction().getRawData().toByteArray();
//                            byte[] bytes = Hash.sha256(byteArray);
//                            String txId = Hex.toHexString(bytes);
//                            // 后续处理
////                             trc20.exchangeService.triggerSmartContract(address.getValue(), amountee, txId);
//                            if (map.get(address.getValue()) != null) {
////                            if (map.get(fromAddress) != null) {//测试验证只要是往里转就ok
//                                Map tronMap = new HashMap();
//                                tronMap.put(Constants.COIN_MAP_KEY.FROM_ADDR, fromAddress);
//                                tronMap.put(Constants.COIN_MAP_KEY.TARGET_ADDR, address.getValue());
//                                tronMap.put(Constants.COIN_MAP_KEY.CHARGE_AMOUNT, amountee+"");
//                                tronMap.put(Constants.COIN_MAP_KEY.TRX_ID, txId);
//                                retMap.put(address.getValue(), tronMap);
//                            }
//                            log.info(String.format("address:%s, amountee:%s, txId:%s,fromAddress：%s", address.getValue(), amountee, txId, fromAddress));
//                        } catch (Exception e) {
//                            log.error("TRON监控报错", e);
//                            continue;
//                        }
//                    }
//                }
//            }
//        }
//        return retMap;
//    }
//
//    public static void main(String[] args) {
//        createAddress("8cb69c7911eee21569534f18c5f3e8cc5700ec1b0198143880f18f9277000002", 77);
//        System.out.println(changePrivateKey("8cb69c7911eee21569534f18c5f3e8cc5700ec1b0198143880f18f9277000002", 66666));
//    }
//
//}
//
//
