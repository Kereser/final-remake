package org.finalremake.utils;

import org.finalremake.data.dto.delivery.DeliveryResponseDTO;
import org.finalremake.data.model.delivery.Delivery;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DeliveryUtils {
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
}
