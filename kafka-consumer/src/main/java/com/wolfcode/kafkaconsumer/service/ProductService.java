package com.wolfcode.kafkaconsumer.service;

import com.wolfcode.kafkaconsumer.dto.Product;
import com.wolfcode.kafkaconsumer.entity.ProductDto;
import com.wolfcode.kafkaconsumer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(Product product) {

        var productDto = ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        productRepository.save(productDto);
    }
}
