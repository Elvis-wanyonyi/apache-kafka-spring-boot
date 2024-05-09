package com.wolfcode.kafkaconsumer.repository;

import com.wolfcode.kafkaconsumer.entity.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto,Long> {
}
