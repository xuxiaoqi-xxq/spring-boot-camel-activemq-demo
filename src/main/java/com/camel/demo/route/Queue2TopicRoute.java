package com.camel.demo.route;

import com.camel.demo.processor.Queue2TopicProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Queue2TopicRoute extends RouteBuilder {

    @Autowired
    private Queue2TopicProcessor processor;

    @Value("${camel-queue}")
    private String queue;

    @Value("${camel-topic}")
    private String topic;

    @Override
    public void configure() throws Exception {
        from(queue).process(processor).to(topic);
    }
}
