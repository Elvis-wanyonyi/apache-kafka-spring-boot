package com.wolfcode.kafkaconsumer.service;


import com.wolfcode.kafkaconsumer.dto.Product;
import com.wolfcode.kafkaconsumer.entity.ConsumerData;
import com.wolfcode.kafkaconsumer.repository.StringConsumerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class KafkaConsumer {

    private final StringConsumerRepository repository;
    private final ProductService productService;

    public KafkaConsumer(StringConsumerRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @Transactional
    @KafkaListener(topics = "kafka-message", groupId = "mainGroup")
    public void consume(String message) {
        try {
            log.info("Message received {}", message);

            var consumerData = ConsumerData.builder()
                    .message(message)
                    .time(LocalDateTime.now())
                    .build();
            repository.save(consumerData);
        } catch (Exception e) {
            log.error("Error processing message: {}", e.getMessage());
        }
    }


    @Transactional
    @KafkaListener(topics = "kafka-json-consumer", groupId = "mainGroup")
    public void consumeJson(Product product) {
        try {
            log.info("JsonPayload Message received {}", product.toString());

            productService.saveProduct(product);
        } catch (Exception e) {
            log.error("Error processing message: {}", e.getMessage());
        }
    }
}
