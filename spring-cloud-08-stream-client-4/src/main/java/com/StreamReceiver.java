package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * SinkRecevier
 *
 * @author zhuxiaohua
 * @date 2018年04月16日 13:49
 */
@EnableBinding(InputConsumer.class)
public class StreamReceiver {
    private static Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

    @StreamListener(InputConsumer.INPUT)
    public void receiver(User user) {
        logger.info("Received: {}", user);
    }
}
