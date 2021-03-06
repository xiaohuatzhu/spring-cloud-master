package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer         // 启用服务器的配置中心
public class RabbitmqEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqEurekaApplication.class, args);
    }

}