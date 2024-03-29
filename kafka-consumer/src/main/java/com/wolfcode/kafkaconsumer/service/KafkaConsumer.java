package com.wolfcode.kafkaconsumer.service;

import com.wolfcode.kafkaconsumer.payload.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "kafka-message", groupId = "GroupA")
    public void consume(String message) {
        log.info("Message received {}", message);
    }


    @KafkaListener(topics = "kafka_json", groupId = "GroupA")
    public void consumeJson(Product product) {
        log.info(String.format("JsonPayload Message received %s", product));
    }
}
