package com.camel.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * provider
 */
@RestController
public class ProducerController {
    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    @Autowired
    private Queue queue;

    @PostMapping("/queue/test")
    public String sendQueue(@RequestBody String str) {
        // 发送消息到消息队列中，queue模式
        this.sendMessage(this.queue, str);
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}