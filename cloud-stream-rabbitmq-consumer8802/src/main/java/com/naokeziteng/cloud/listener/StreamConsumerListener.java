package com.naokeziteng.cloud.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author aku
 * @Date 2020/11/25
 * @Description
 */
@EnableBinding(Sink.class)
public class StreamConsumerListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        System.out.println("消费者1号, 接收到消息为:  " + message.getPayload() + ", 我的端口号: " + serverPort);
    }
}
