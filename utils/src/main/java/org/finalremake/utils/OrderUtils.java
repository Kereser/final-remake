package org.finalremake.utils;

import org.finalremake.data.dto.order.OrderResponseDTO;
import org.finalremake.data.model.order.Order;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public final class OrderUtils {
    private OrderUtils() {}

    public static Order getOrder1() {
        return Order.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .checkout(CheckoutUtils.getCheckout1())
                .delivery(DeliveryUtils.getDelivery1())
                .payment(PaymentUtils.getPayment1())
                .active(Boolean.TRUE)
                .build();
    }

    public static Order getOrder2() {
        return Order.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .checkout(CheckoutUtils.getCheckout2())
                .delivery(DeliveryUtils.getDelivery2())
                .payment(PaymentUtils.getPayment2())
                .active(Boolean.TRUE)
                .build();
    }

    public static OrderResponseDTO getOrderResponseDTO1() {
        return OrderResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .delivery(DeliveryUtils.getDeliveryResponseDTO1())
                .productQuantity(CheckoutUtils.getCheckout1().getProductQuantity())
                .active(Boolean.TRUE)
                .build();
    }

    public static OrderResponseDTO getOrderResponseDTO2() {
        return OrderResponseDTO.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .delivery(DeliveryUtils.getDeliveryResponseDTO2())
                .productQuantity(CheckoutUtils.getCheckout2().getProductQuantity())
                .active(Boolean.TRUE)
                .build();
    }
}
