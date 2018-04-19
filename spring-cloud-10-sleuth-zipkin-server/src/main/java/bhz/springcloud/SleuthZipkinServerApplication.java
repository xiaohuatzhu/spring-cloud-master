package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer         // localhost:9411 访问页面
@EnableZipkinStreamServer       //使用Stream方式启动ZipkinServer
public class SleuthZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinServerApplication.class, args);
    }

    //在测试的过程中我们会发现，有时候，程序刚刚启动后，刷新几次，并不能看到任何数据，原因就是我们的spring-cloud-sleuth收集信息是有一定的比率的，
    // 默认的采样率是0.1，配置此值的方式在配置文件中增加 spring.sleuth.sampler.percentage 参数配置（如果不配置默认0.1），
    // 如果我们调大此值为1，可以看到信息收集就更及时。但是当这样调整后，我们会发现我们的rest接口调用速度比0.1的情况下慢了很多，
    // 即时在0.1的采样率下，我们多次刷新consumer的接口，会发现对同一个请求两次耗时信息相差非常大，
    // 如果取消spring-cloud-sleuth后我们再测试，会发现并没有这种情况，可以看到这种方式追踪服务调用链路会给我们业务程序性能带来一定的影响。
    //
    //其实，我们仔细想想也可以总结出这种方式的几种缺陷
    //缺陷1：zipkin客户端向zipkin-server程序发送数据使用的是http的方式通信，每次发送的时候涉及到连接和发送过程。
    //缺陷2：当我们的zipkin-server程序关闭或者重启过程中，因为客户端收集信息的发送采用http的方式会被丢失。
    //
    //针对以上两个明显的缺陷，改进的办法是
    //1、通信采用socket或者其他效率更高的通信方式。
    //2、客户端数据的发送尽量减少业务线程的时间消耗，采用异步等方式发送收集信息。
    //3、客户端与zipkin-server之间增加缓存类的中间件，例如redis、MQ等，在zipkin-server程序挂掉或重启过程中，客户端依旧可以正常的发送自己收集的信息。
    //
    //相信采用以上三种方式会很大的提高我们的效率和可靠性。
    // 其实spring-cloud以及为我们提供采用MQ或redis等其他的采用socket方式通信，利用消息中间件或数据库缓存的实现方式。
    // spring-cloud-sleuth-zipkin-stream
    //
    //作者：shunyang
    //链接：https://www.jianshu.com/p/50d4673d04b2


}