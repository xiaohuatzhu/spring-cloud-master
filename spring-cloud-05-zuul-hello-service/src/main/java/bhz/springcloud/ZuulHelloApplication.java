package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient         // 启用服务器的配置中心
public class ZuulHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulHelloApplication.class, args);
    }

}