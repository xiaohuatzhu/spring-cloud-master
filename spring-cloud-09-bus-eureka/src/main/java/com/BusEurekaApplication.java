package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * BusEurekaApplication
 *
 * @author zhuxiaohua
 * @date 2018年04月12日 09:47
 */
@SpringBootApplication
@EnableEurekaServer         // 启用服务器的配置中心
public class BusEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusEurekaApplication.class, args);
    }
}