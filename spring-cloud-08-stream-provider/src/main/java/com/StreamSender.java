package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SinkRecevier
 *
 * @author zhuxiaohua
 * @date 2018年04月16日 13:49
 */
@EnableBinding(value = {OutputProvider.class})
@Service
public class StreamSender {

    private static Logger logger = LoggerFactory.getLogger(StreamSender.class);

    @Resource
    private OutputProvider outputProvider;

    public void timerMessageSource(User user) {
        logger.info("Sending message: " + user);
        outputProvider.output().send(MessageBuilder.withPayload(user).build());
    }

}
