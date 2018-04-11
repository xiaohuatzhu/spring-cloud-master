package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy             //启用网管路由
//@SpringBootApplication
//@EnableDiscoveryClient         // 启用服务器的配置中心
@SpringCloudApplication         // 包含 @SpringBootApplication, @EnableCircuitBreaker, @EnableDiscoveryClient
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

}