package com.wolfcode.kafkaproducer.service;


import com.wolfcode.kafkaproducer.dto.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
@Slf4j
public class KafkaJsonPublisher {

    private final KafkaTemplate<String, Product> kafkaTemplate;


    public void sendJsonPayload(Product product){

        log.info(String.format("Payload Message sent %s", product));

        kafkaTemplate.send("kafka-json-consumer", product);
    }
}