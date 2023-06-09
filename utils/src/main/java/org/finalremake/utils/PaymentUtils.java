package org.finalremake.utils;

import org.finalremake.data.dto.payment.*;
import org.finalremake.data.model.payment.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.YearMonth;

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

    public static Payment getPayment3() {
        return Payment.builder()
                .id(3L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.DEBIT_CARD)
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
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.PAYPAL)
                .build();
    }

    public static PaymentResponseDTO getPaymentResponseDTO3() {
        return PaymentResponseDTO.builder()
                .id(3L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .name(PaymentType.DEBIT_CARD)
                .build();
    }

    public static CreditCardPaymentReqDTO getCreditCardPaymentReqDTO() {
        return CreditCardPaymentReqDTO.builder()
                .ACCOUNT_NUMBER("1023546396859386")
                .cvv(906)
                .goodTrough(YearMonth.of(2029, 12))
                .build();
    }

    public static DebitCardPaymentReqDTO getDebitCardPaymentReqDTO() {
        return DebitCardPaymentReqDTO.builder()
                .ACCOUNT_NUMBER("1423243543522478")
                .cvv(140)
                .goodTrough(YearMonth.of(2025, 12))
                .build();
    }

    public static PaypalPaymentReqDTO getPaypalPaymentReqDTO() {
        return PaypalPaymentReqDTO.builder()
                .ACCOUNT_NUMBER("Pepeix@gmail.com")
                .build();
    }
}
