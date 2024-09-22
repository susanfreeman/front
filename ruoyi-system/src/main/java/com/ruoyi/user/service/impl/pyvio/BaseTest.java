package com.ruoyi.user.service.impl.pyvio;

import com.pyvio.openapi.sdk.client.ClientConfig;
import com.pyvio.openapi.sdk.client.Constants;
import com.pyvio.openapi.sdk.client.Endpoint;
import com.pyvio.openapi.sdk.client.PyvioClient;
import com.pyvio.openapi.sdk.entity.authentication.AccessTokenGetRequest;
import com.pyvio.openapi.sdk.entity.authentication.AccessTokenGetResponse;
import com.pyvio.openapi.sdk.enums.AuthorizationEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseTest {

    public static PyvioClient getClient(Endpoint endpoint){
        ClientConfig clientConfig = new ClientConfig();

        //sandbox
        clientConfig.setAppId("1816368926312438838");
        clientConfig.setAppSecret("dba1a9cab56b42fda3a2de72e4056e0d");
        clientConfig.setDomainUrl("https://www.orbiterwallet.com/pyvioreq/");
        clientConfig.setPrivateKey("MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC3MFFN6fA9DfY5SreaVNoCj0qcpUTlr6XhBBS293O+8tESUephqREONx92NgSwcpzwU1SBBdSiG01y4CIq7UoxgBPRXx8WV3EdbYZPRi1TlRkdHHMTf3oKMebDbVpqr25wUK8u3VcmxXoEiqkeJZcbhmBDlJ2t0vHLCxdRMc/WQLB2tI0QMyyv6U1/rc0B73hiwYeI3Bx2ekwnvWbCFaIMft1gtZbRkjlyhZ1GC/elN5dlUYsCyL0/YG59v/uztKza3fi7eUIwbe6X2Srox79rycqMmlJz0+/1s0gQY6851MT3I8hZVnh8YVeyA6z5uB4axeFOaCRjjmdDOLR25qibAgMBAAECggEAdPzBX42fo44QCaSCvmej1nCmCIWvCzPyLlJJ3FMJMw+knxt7ICU1RCvFxttWgUyglwXQeJk9oszm2A71Iw7pC9WsUlB57O2oyk9Qr720YqVcJXAuuWv2hx45LeLfFDS2xblxNu+ZoaQJeW8H872z05ssTNxTGlgVnEKYAH1cKomOqMqf/VfV4tMKLJ9IvV+aYhslKrVMpYNjorYM/VCzRF2hMcYB+qmFbmZRkruGMinMMGIC6zbCJ/buMZrEluIZRkQkOmEJU3GzQD4dQthfcJlxYKxOUzDFs55p6n8V0u2I8pZiqSu4CdNzhgWyAFByyuM1EvzUWUPnMAar5RHTiQKBgQDf2BfkwBYcGKJgLHNQsdWi4SRiX6AHu21HHX/3z8hE6Y7h0HbN9RKx/dagbQIi+k0/jmBQjcXI6oZANY2AO2Pt868O3jGmKAFspUmoEVWqbgTTX5l1iqUXZ1YWy4fc/oZXaB86ttKcDLEiLo2565Ogphb0JWvYq70VPN8ZeRyY/QKBgQDRgR2g2D8mxzBvp5Fud4bXGsJbb1pjBM4fDbESBrpC0n+AD04bu05hnNKP8Mt79CZpnQ2aBBzJ826R1VIZGq11+/ow7jV/+qFy9LlBDqtApu6dKZq9Sne4ZgSW7Z3v6Nh80BWqhsYVsN1DGhA/cJsGHjM2GyTm8hoFJSXwSJEndwKBgQDa75zPHCGD8YQ/1LolHwr5eIQBw83eQi+r8uqLEyuqW1Zo/2B0KVPTy5b06inA1Fhh5XvGziO5U8ljW/2+glhHEKUUQbcF8PMTtMbKH8pOG7WUmFicYrL+pQ/K099bA4eaTjjdUJvGDZPi/u2X/xYxdsHUohVNowwZjaQYYiDacQKBgQC5iqjrvzhGppgN+pCBDdhcfrVsdvTMxv+pXt3YAh9JeNU0W9moE716E4IjunTsBTFTzaSzJzs725ysCQmZdBf1asCMPxsgiZ4cigHbTRt7uZuPkr4ZMG9Q3wDnje+W/ldkSoE1sgCSSz3Z5KZJGPgidfKS031eD0HeFqU/5XSwRwKBgQDALcCoJREbowPNG1NaT3KndxhvtFMFUekyZ+nE4heL8JtmO4CKQjXlq6sWPI8eqiAO/V0C0RBaH3fUQK2SUP/OAW4GpZYhJJ3SYG/0VtkkLbXpRv8qxp8Wkm5CAT3pHVFVr6Rf6oUXlkBUvOFrN05Sak72qnPyjuhgBrfqGEUFaw==");

//        clientConfig.setAppId("1569641270953589505");
//        clientConfig.setAppSecret("bc2ead7739f447c49032b4aef7818c47");
//        clientConfig.setDomainUrl(Constants.Url.PRODUCTION_API);
//        clientConfig.setPrivateKey("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALxGyg3/boLT2I8dQnC3Njc2XIDJgZM/G4wqsDDUVoy/PQ2THA39sKHiLsTg71zVbQZ4+UYWm1aTlms7KuBuOmvmdIzKuI04NbSuDeAbAtnraizhELSOpVQFNom2tIGHw4/46VuF3bE0rgFjKGqrRI9xOVEcDGZlP4h9JatQEgytAgMBAAECgYADZ1dX9Awy+A+NlAFm4BQrcXFy1xt7GIGUHaSUCe3N7sxY45uB+F+vyVh6aJm74QlCaJvmQv62Lg5t1HOQ2pcHD6/r7G0lykjYJ3JEAmF3KKm/FgPqX9MGqZCBNHp3oQaHMf8WwRfjxr/EBT1QfdItCGjiENJ4bjSJo9qzEPtjSQJBAMx/r6clsTUdpeskw60UMJG17Af5Fc/SNCsq8hdmCqva0QtT1l/vprmwEH1hKXlA9au9cIESp0ceABH86jE9Vu8CQQDrsTt/S6iiWAiJKA8eYWSEcPyQXoB+tveg4ZoKUwG+fT5t9tXOuPZGmC7CWsAATfO88/ySGqNyIlFgSDvTM3YjAkB+c9JdLCyI6L1pSwGIq/xgjbrXL0oyiQvjSZoLp/ifTh6Hv57HEfzpw5pevU8VAHspaGoCFlPD4SQv+1GhgwmXAkAd6grBJ1sp7751mg4BLx9Q5/5GXJg2fQaE9t1UPiDUipTn5BJTAIrRfvNAW8BOyZYL/3OpH5RrIgvuCnz9W2S9AkB19MQtKSc3Ba36Jo3C0kvTdeSDBR4o+ah+bzhwg/Hj8EKYp4IoyW8mx32WXtSLGp8OjupPlZ65PUkzy838Eo8v");

        clientConfig.setDebug(true);

        PyvioClient pyvioClient = new PyvioClient(clientConfig);
        if(endpoint.isAuthorization()){
            AccessTokenGetRequest tokenRequest = new AccessTokenGetRequest();
            tokenRequest.setApp_id(clientConfig.getAppId());
            tokenRequest.setApp_secret(clientConfig.getAppSecret());
            tokenRequest.setGrant_type(AuthorizationEnum.GrantType.ClientCredentials.getCode());
            AccessTokenGetResponse tokenResponse = pyvioClient.execute(tokenRequest);
            if(!tokenResponse.isSuccess()){
                throw new RuntimeException("Get Access Token Error");
            }
            clientConfig.setAccessToken(tokenResponse.getAccess_token());
        }
        return pyvioClient;
    }

}
