package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * RabbitmqClientApplication
 *
 * @author zhuxiaohua
 * @date 2018年04月04日 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RabbitmqClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqClientApplication.class, args);
    }
}
