package com.suth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suth.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {

    ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "sample_topic")
    public void processMessage(String content) throws JsonProcessingException {
        System.out.println("Message received: " + content);
    }
}
