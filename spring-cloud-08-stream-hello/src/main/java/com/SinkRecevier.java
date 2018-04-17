package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * SinkRecevier
 *
 * @author zhuxiaohua
 * @date 2018年04月16日 13:49
 */
@EnableBinding(Sink.class)
public class SinkRecevier {
    private static Logger logger = LoggerFactory.getLogger(SinkRecevier.class);

    @StreamListener(Sink.INPUT)
    public void receiver(Object payLoad) {
        logger.info("Received: {}", payLoad);
    }
}
