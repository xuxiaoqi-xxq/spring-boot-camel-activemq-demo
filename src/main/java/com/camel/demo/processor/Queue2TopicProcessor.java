package com.camel.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class Queue2TopicProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("process exchange");
    }
}
