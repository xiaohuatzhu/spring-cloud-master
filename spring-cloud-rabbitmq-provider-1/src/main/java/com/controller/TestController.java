package com.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Controller
 *
 * @author zhuxiaohua
 * @date 2018年04月04日 14:51
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private AmqpTemplate rabbitTemplate;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String send(String msg) {
        String context = "Provider-发送消息: " + msg + ", 时间: " + new Date();
        System.out.println(context);
        this.rabbitTemplate.convertAndSend("hello", context);
        return context;
    }
}
