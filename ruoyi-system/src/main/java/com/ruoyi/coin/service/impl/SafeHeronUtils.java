package com.ruoyi.coin.service.impl;

import com.safeheron.client.api.AccountApiService;
import com.safeheron.client.config.SafeheronConfig;
import com.safeheron.client.request.CreateAccountRequest;
import com.safeheron.client.request.ListAccountCoinRequest;
import com.safeheron.client.response.AccountCoinResponse;
import com.safeheron.client.response.CreateAccountResponse;
import com.safeheron.client.utils.ServiceCreator;
import com.safeheron.client.utils.ServiceExecutor;

import java.util.List;

public class SafeHeronUtils {


    public static AccountApiService initConfig(SafeheronConfig config) {
        return ServiceCreator.create(AccountApiService.class, config);
    }


    /**
     * description: 创建指定Coin <br>
     * version: 1.0 <br>
     * date: 2024/8/18 22:51 <br>
     *
     * @return com.safeheron.client.response.CreateAccountResponse
     * @Param: config
     * @Param: accountName
     * @Param: isDeposit
     * @Param: CoinList
     */
    public static CreateAccountResponse createAccountAndAddCoin(SafeheronConfig config, String accountName, boolean isDeposit, List<String> CoinList) {
        AccountApiService accountApiService = initConfig(config);
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountName(accountName);
        createAccountRequest.setHiddenOnUI(false);
        if (isDeposit) {
            createAccountRequest.setAccountTag("DEPOSIT");
        }
        createAccountRequest.setCoinKeyList(CoinList);
        CreateAccountResponse createAccountResponse = ServiceExecutor.execute(accountApiService.createAccount(createAccountRequest));
        return createAccountResponse;
    }

    /**
     * description: 根据accountKey查询当前用户币种地址和余额 <br>
     * version: 1.0 <br>
     * date: 2024/8/18 22:50 <br>
     *
     * @return java.util.List<com.safeheron.client.response.AccountCoinResponse>
     * @Param: config
     * @Param: accountKey
     */
    public static List<AccountCoinResponse> listAccountCoin(SafeheronConfig config, String accountKey) {
        AccountApiService accountApiService = initConfig(config);
        ListAccountCoinRequest listAccountCoinRequest = new ListAccountCoinRequest();
        listAccountCoinRequest.setAccountKey(accountKey);
        List<AccountCoinResponse> accountCoinResponseList = ServiceExecutor.execute(accountApiService.listAccountCoin(listAccountCoinRequest));
        return accountCoinResponseList;
    }
}
