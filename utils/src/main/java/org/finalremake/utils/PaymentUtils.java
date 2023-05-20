package org.finalremake.utils;

import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.model.payment.Payment;
import org.finalremake.data.model.payment.PaymentType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class PaymentUtils {
    public static Payment getPayment1() {
        return Payment.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.CREDIT_CARD)
                .customer(CustomerUtils.getCustomer1())
                .build();
    }

    public static Payment getPayment2() {
        return Payment.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.PAYPAL)
                .customer(CustomerUtils.getCustomer2())
                .build();
    }

    public static PaymentResponseDTO getPaymentResponseDTO1() {
        return PaymentResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.CREDIT_CARD)
                .build();
    }

    public static PaymentResponseDTO getPaymentResponseDTO2() {
        return PaymentResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.PAYPAL)
                .build();
    }
}
