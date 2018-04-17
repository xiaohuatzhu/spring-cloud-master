package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ClientController {

    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private StreamSender streamSender;

    @RequestMapping(value = "/provide", method = {RequestMethod.GET})
    public String provide(User user) {
        streamSender.timerMessageSource(user);
        return "success";
    }

}
