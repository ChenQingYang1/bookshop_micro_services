package com.javaee.bookshop_user_provider.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void obtainMessage(ConsumerRecord<String,String> consumerRecord){
        System.out.println("消费者获取到消息");
        String key = consumerRecord.key();
        String value = consumerRecord.value();
        System.out.println("key="+key+" value="+value);
    }
}
