package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient         // 启用服务器的配置中心
@EnableTurbine       // 启用turbine
public class HystrixTurbineApplication {
    // 要监控的turbine地址(监控hystrix-request服务): http://localhost:3000/turbine.stream
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
