package com;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * OutputGreetings
 *
 * @author zhuxiaohua
 * @date 2018年04月16日 19:23
 */
@Service
public interface OutputProvider {
    String OUTPUT = "stream_provider_output";

    @Output(OUTPUT)
    MessageChannel output();
}
