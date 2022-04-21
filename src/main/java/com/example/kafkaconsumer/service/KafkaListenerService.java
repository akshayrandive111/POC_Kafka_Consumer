package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaListenerService {

    private List<String> messages = new ArrayList<>();
    private User userFromTopic = new User();

    public List<String> getMessages() {
        return messages;
    }

    public User getUser() {
        return userFromTopic;
    }

    @KafkaListener(groupId = "group-1", topics = "topic5", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data) {
        messages.add(data);
        return messages;
    }

    @KafkaListener(groupId = "group-2", topics = "topic5", containerFactory = "userKafkaListenerContainerFactory")
    public User getJsonMsgFromTopic(User user) {
        userFromTopic = user;
        return userFromTopic;
    }
}
