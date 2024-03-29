package com.wolfcode.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessagePublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToTopic(String message) {
        kafkaTemplate.send("kafka-message", message);
        log.info(String.format("Message published to topic %s", message));

    }

}
