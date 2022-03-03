package com.suth.service;

import com.suth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String kafkaTopic = "bootcamp-topic";

    public void send(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }

    public void sendUser(String user) {
        kafkaTemplate.send(kafkaTopic, user);
    }

    public void sendData() {
        while (true) {
            String message = new Date()  + " " + Math.random();

            kafkaTemplate.send(kafkaTopic, message);
        }
    }
}
