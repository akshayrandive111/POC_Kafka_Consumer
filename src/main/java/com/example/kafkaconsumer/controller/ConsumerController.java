package com.example.kafkaconsumer.controller;

import com.example.kafkaconsumer.model.User;
import com.example.kafkaconsumer.service.KafkaListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private KafkaListenerService kafkaListenerService;

    @GetMapping("/consumeStringMessage")
    public List<String> consumeMsg() {
        return kafkaListenerService.getMessages();
    }

    @GetMapping("/consumeJsonMessage")
    public User consumeJsonMessage() {
        return kafkaListenerService.getUser();
    }
}
