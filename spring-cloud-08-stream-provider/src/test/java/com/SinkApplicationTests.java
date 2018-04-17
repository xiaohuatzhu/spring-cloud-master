package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * SinkApplicationTests
 *
 * @author zhuxiaohua
 * @date 2018年04月16日 13:59
 */
@RunWith(SpringRunner.class)
@EnableBinding(value = {SinkApplicationTests.StreamSender.class})
public class SinkApplicationTests {
    @Resource
    private StreamSender sinkSender;

    @Test
    public void sinkSenderTester() {
        sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
    }

    public interface StreamSender {

        String OUTPUT = "input";

        @Output(StreamSender.OUTPUT)
        MessageChannel output();
    }
}
