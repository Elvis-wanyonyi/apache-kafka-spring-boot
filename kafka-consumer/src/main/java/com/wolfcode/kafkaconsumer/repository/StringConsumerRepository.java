package com.wolfcode.kafkaconsumer.repository;

import com.wolfcode.kafkaconsumer.entity.ConsumerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringConsumerRepository extends JpaRepository<ConsumerData, Long> {

}
