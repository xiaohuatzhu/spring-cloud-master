package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope   //动态刷新远程config的值, 配置springcloud bus后 ,更改后访问 POST localhost:4000/bus/refresh 值就刷新了
@RestController
public class ClientController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from", method = {RequestMethod.GET})
    public String from() {
        System.err.println("from=" + from);
        return from;
    }

}
