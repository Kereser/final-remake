package org.finalremake.utils;

import org.finalremake.data.dto.product.ProductReqDTO;
import org.finalremake.data.dto.product.ProductResponseDTO;
import org.finalremake.data.model.product.Product;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ProductUtils {
    public static Product getProduct1() {
        return Product.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name("TV")
                .price(500)
                .build();
    }

    public static Product getProduct2() {
        return Product.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name("Washing machine")
                .price(1000)
                .build();
    }

    public static ProductResponseDTO getProductResponseDTO1() {
        return ProductResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name("TV")
                .price(500)
                .build();
    }

    public static ProductResponseDTO getProductResponseDTO2() {
        return ProductResponseDTO.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name("Washing machine")
                .price(1000)
                .build();
    }

    public static ProductReqDTO getProductReqDTO1() {
        return ProductReqDTO.builder()
                .name("TV")
                .price(500)
                .build();
    }

    public static ProductReqDTO getProductReqDTO2() {
        return ProductReqDTO.builder()
                .name("Washing machine")
                .price(1000)
                .build();
    }
}
