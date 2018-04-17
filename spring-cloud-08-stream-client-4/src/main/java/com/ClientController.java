package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {


    @RequestMapping(value = "/consumer", method = {RequestMethod.GET})
    public String consumer(String msg) {
        System.err.println("Consumer: " + msg);
        return msg;
    }

}
