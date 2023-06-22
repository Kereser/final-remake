package org.finalremake.utils;

import org.finalremake.data.dto.delivery.DeliveryResponseDTO;
import org.finalremake.data.model.checkout.Checkout;
import org.finalremake.data.model.delivery.Delivery;
import org.finalremake.data.model.product.Product;
import org.finalremake.data.respository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DeliveryUtils {
    @Autowired private ProductRepository productRepository;

    public DeliveryUtils(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static Delivery getDelivery1() {
        return Delivery.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .address(AddressUtils.getAddress1())
                .payment(PaymentUtils.getPayment1())
                .totalAmount(2500.00)
                .build();
    }

    public static Delivery getDelivery2() {
        return Delivery.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .address(AddressUtils.getAddress2())
                .payment(PaymentUtils.getPayment2())
                .totalAmount(5000.00)
                .build();
    }

    public static DeliveryResponseDTO getDeliveryResponseDTO1() {
        return DeliveryResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .address(AddressUtils.getAddressResponseDTO1())
                .payment(PaymentUtils.getPaymentResponseDTO1())
                .totalAmount(2500.00)
                .build();
    }

    public static DeliveryResponseDTO getDeliveryResponseDTO2() {
        return DeliveryResponseDTO.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .address(AddressUtils.getAddressResponseDTO2())
                .payment(PaymentUtils.getPaymentResponseDTO2())
                .totalAmount(5000.00)
                .build();
    }

    public Delivery createDelivery(Checkout checkout) {
        return Delivery.builder()
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .address(checkout.getAddress())
                .payment(checkout.getPayment())
                .totalAmount(getTotalAmount(checkout.getProductQuantity()))
                .build();
    }

    private Double getTotalAmount(Map<Long, Integer> productQuantity) {
        double totalAmount = 0;
        for (Long productId : productQuantity.keySet()) {
            Optional<Product> p = productRepository.findById(productId);
            totalAmount += p.map(Product::getPrice).orElse(0.0);
        }
        return totalAmount;
    }

    public Map.Entry<String, String> isValidDelivery(Delivery delivery) {
        if (delivery.getAddress() == null) return new AbstractMap.SimpleEntry<>("Address", "Address is required");
        else if (delivery.getPayment() == null) return new AbstractMap.SimpleEntry<>("Payment", "Payment is required");
        else return new AbstractMap.SimpleEntry<>(null, null);
    }
}
