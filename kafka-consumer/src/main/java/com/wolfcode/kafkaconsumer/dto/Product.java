package com.wolfcode.kafkaconsumer.dto;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
}