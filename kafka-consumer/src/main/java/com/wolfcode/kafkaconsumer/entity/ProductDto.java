package com.wolfcode.kafkaconsumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductDto {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
}
