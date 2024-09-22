package com.ruoyi.framework.config;

import com.safeheron.client.config.SafeheronConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SafeHeronConfigLocal {

    @Value("${safeheron.config.baseUrl}")
    private String baseUrl;

    @Value("${safeheron.config.apiKey}")
    private String apiKey;

    @Value("${safeheron.config.safeheronPublicKey}")
    private String safeheronPublicKey;

    @Value("${safeheron.config.privateKey}")
    private String privateKey;

    @Value("${safeheron.config.timeout}")
    private Long timeout;

    @Bean(name = "safeheronConfig")
    public SafeheronConfig safeheronConfig() {
        return SafeheronConfig.builder().baseUrl(baseUrl).apiKey(apiKey).rsaPrivateKey(privateKey)
                .safeheronRsaPublicKey(safeheronPublicKey).requestTimeout(timeout).build();
    }

}
