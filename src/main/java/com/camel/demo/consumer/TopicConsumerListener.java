package com.camel.demo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 * topic1，consumer
 * 能与topic2同时消费消息队列中的同一条消息
 */
@Component // required，否则无法接收消息
public class TopicConsumerListener {
    @JmsListener(destination="${topic.TOPIC}", containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic one received：" + message);
    }
}
