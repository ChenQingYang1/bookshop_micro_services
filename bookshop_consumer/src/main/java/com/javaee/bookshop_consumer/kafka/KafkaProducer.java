package com.javaee.bookshop_consumer.kafka;

import com.google.gson.Gson;
import com.javaee.bookshop_consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendKafkaMessage(User user){
        kafkaTemplate.send("myTopic", new Gson().toJson(user));
    }
}
