package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * BusClientApplication
 *
 * @author zhuxiaohua
 * @date 2018年04月12日 09:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusClientApplication.class, args);
    }
}
