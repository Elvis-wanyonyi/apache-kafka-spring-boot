package com.wolfcode.kafkaproducer.controller;

import com.wolfcode.kafkaproducer.payload.Product;
import com.wolfcode.kafkaproducer.service.KafkaJsonPublisher;
import com.wolfcode.kafkaproducer.service.KafkaMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kafka/")
public class ProducerController {

    private final KafkaMessagePublisher messagePublisher;
    private final KafkaJsonPublisher jsonPublisher;


    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        messagePublisher.sendMessageToTopic(message);
        return ResponseEntity.ok("message published yo topic successfully ...");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Product product) {
        jsonPublisher.sendJsonPayload(product);
        return ResponseEntity.ok("Json Message sent to kafka topic");
    }

}
