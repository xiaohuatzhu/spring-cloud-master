package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * RabbitmqProviderApplication
 *
 * @author zhuxiaohua
 * @date 2018年04月04日 14:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RabbitmqProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProviderApplication.class, args);
    }
}
