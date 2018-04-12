package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * BusConfigApplication
 *
 * @author zhuxiaohua
 * @date 2018年04月12日 09:42
 */
@EnableConfigServer             //开启springcloud config 配置中心
@SpringBootApplication
@EnableDiscoveryClient         // 启用服务器的配置中心
public class BusConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusConfigApplication.class, args);
    }
}
