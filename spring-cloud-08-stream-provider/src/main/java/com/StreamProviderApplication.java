package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * StreamHelloApplication
 *
 * @author zhuxiaohua
 * @date 2018年04月12日 09:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class, args);
    }
}
