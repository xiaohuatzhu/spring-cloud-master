package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient         // 启用服务器的配置中心
@EnableHystrixDashboard         //启动断路器监控, 访问 http://localhost:5001/hystrix
public class HystrixDashboardApplication {
    // 监控台地址 : http://localhost:5001/hystrix
    // 查看什么样的数据(我们要监控哪个断路器服务器), 写上具体的地址 : http://localhost:6001/hystrix.stream
    // 不能观察集群的信息, 需要引用turbine进行汇总数据
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
