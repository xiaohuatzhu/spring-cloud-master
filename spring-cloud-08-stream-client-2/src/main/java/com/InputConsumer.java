package com;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * InputConsumer
 *
 * @author zhuxiaohua
 * @date 2018年04月16日 19:20
 */
public interface InputConsumer {
    String INPUT = "stream_client_input";

    @Input(INPUT)
    SubscribableChannel input();
}
