package com.ruoyi;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpRequest;
import global.kun.shade.com.google.common.collect.Maps;

import java.security.PrivateKey;
import java.security.Signature;
import java.util.Map;

public class IntegrationTest {
    private static final String PRI_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCLhtOYsfN1TdRtB8y7WRGWmAHGHg+ANP+9V6Us7GPK9ohun6lXcknoTJXZ/jktj1czr6Xmm5+NroM2+W9ADToojWlzauV9FcwQAkX3xIz4N7QiTrzYxpKNMZ19hugKUok9GJ0bPlBhRA1R6yUQqtUALf57/egO5NpnVD277/4Q0oS3bmjYW59/GxSHPD4K2SCbpxHokzXfvBt0rnYoyBB+U49atm/qIe3f+/tsryFxZPjhuFrZgCpo8shI8D5ibeQW4+dSuZ9SFIZMRHztvqqW1M4c7cLW+Wb2NN+tNzQ71+LbZnZWDhWJERx2aoIs0t9ggxJ115xT1RuBtnIZ6/yvAgMBAAECggEAHCfcAT8/utc2272sMc46f2IzUXB1flCzntjV6yfUx3tScshjWtMkWO1DfBcSIMCBP1vdpZiX7PZfYjOZoJpKty46LmFO6BwC7uQWjHYsYFaVUisDbtc7caSmfFNB9ftL2HlkEsBTZh1edr5131Qp4Xxmk0zcjEzgSeO1BXzbjzcufNankhyc6ajgm9PuU1YVYdQ493CNr8JerEUmoNyG4i5unGrv5znhSm7yOkhq7RSa/1KNE0r9UXONdPb/gwThhqXVOwTUJr1ZfnACHcfUZS/MQwxNaE0DzXKcE3qpmrvCRrSbUO74cg5HRWiuU0hH8uSIw9lCECHe6UNYr5mVqQKBgQDlXyRnyH3HrLFOgYV1LcmD6K9Glmz3aVcw5zotBkwZX8QEIghcSHctKiBtMjTo2W7Il9O8fjMxfUux6HYj9z9PfZ3atN0aWc4Knl134aD/IrAVKESdr4zwFIiYlo7ZtS/RSnprS4BahNlGVNpE/IpkZ2C1+ywfjOz+h4IpmguH8wKBgQCbuYSXOI1Q+U5WzRVhc6cWl/PtPct5q5s0fCb5hJpwSEAMKcOnYeiH/MwnXALXN4Nv6tuIRePomAMr+DW5XGedpc9pL57c+fMgTDdDpyFJQP9ugrZ+KpwF8TV40M1h6a5q6QnkQhWIqu2nLSjMgrbLAxz8jnPbNq1JG/8+yIADVQKBgQC3ZbBlLyCq9AC9JcDA5cBXsUfcJ9CurlKh7nBMqdlU/IZtS4zlxKdNvH468Ubu21PCHeuVrk5ehrFsadN0hG/hri32PmD/fcjKIr/XZ9fjyCeEczMR5djJ6ZEieFd16XJ3ZJanjbHuLoTPwG7ZdBdvmlzwhQlNnM+t4EmJ2/rWUwKBgQCJOMMD1kuArQ9BIdrTUuxL1n6V8bwZbQSJDVXyzcyhYKk/jpXgK0CShEsJ6+R87Wge+N+Wh6+7SCiTWFdPDYQowPGyCMp+gqqhLUgNj3qfaG0tXnWdW8K84b5yxdwViauufce/ohQDqEte40ZuYEjfP9ENJCIna1jrcYZMNrXHOQKBgQDZBoo/bU7NK0Y+lq6rpNLC1Ayla1BmuyykGM6DqVmKBbOIG9kzcnwxH4cnZauzPS3gVc0OF1+SMu3l+rof5m42xJWTq3kMQvmzNuHoNlm/fR7lp4X/9vKu/7k43xgY5sPgQs2gr/usW1jAKhTB79eZKeLWjs0rdNaX/2e/sLnFIw==";

    public static void main(String[] args) throws Exception {
        Map<String, String> headers = Maps.newHashMap();
        headers.put("x-merchant-id", "application/json");
        headers.put("x-req-id", IdUtil.getSnowflakeNextIdStr());
        headers.put("x-api-name", "newCard");//接口名称

//        toSign = sha256Hex(body) + header("x-req-id") + header("x-merchant-id") + header("x- api-name")
        String toSign = SecureUtil.sha256("123") + headers.get("x-req-id") + headers.get("x-merchant-id") + headers.get("x-api-name");
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA512withRSA, PRI_KEY, null);
        headers.put("x-sign", Base64.encode( sign.sign(toSign)));
//        用标准的SHA512withRSA签名算法对toSign字符串进行签名， 将签名结果放到x-sign的http请求头里

//        HttpRequest.post("").addHeaders(headers).body().execute().body();
    }
}
