package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer         // 启用服务器的配置中心
public class SleuthEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthEurekaApplication.class, args);
    }

}