package org.finalremake.utils;

import org.finalremake.data.dto.checkout.CheckoutReqDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.finalremake.data.model.checkout.Checkout;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class CheckoutUtils {
    private static final Map<Long, Integer> productQuantity1 = new HashMap<>(){{put(1L, 1); put(2L, 2);}};
    private static final Map<Long, Integer> productQuantity2 = new HashMap<>(){{put(1L, 2); put(2L, 4);}};

    public static Checkout getCheckout1() {
        return Checkout.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .customer(CustomerUtils.getCustomer1())
                .payment(PaymentUtils.getPayment1())
                .address(AddressUtils.getAddress1())
                .productQuantity(productQuantity1)
                .build();
    }

    public static Checkout getCheckout2() {
        return Checkout.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .customer(CustomerUtils.getCustomer2())
                .payment(PaymentUtils.getPayment2())
                .address(AddressUtils.getAddress2())
                .productQuantity(productQuantity2)
                .build();
    }

    public static CheckoutResponseDTO getCheckoutResponseDTO1() {
        return CheckoutResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .customer(CustomerUtils.getCustomerResponseDTO1())
                .address(AddressUtils.getAddressResponseDTO1())
                .payment(PaymentUtils.getPaymentResponseDTO1())
                .productQuantity(productQuantity1)
                .build();
    }

    public static CheckoutResponseDTO getCheckoutResponseDTO2() {
        return CheckoutResponseDTO.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .customer(CustomerUtils.getCustomerResponseDTO2())
                .address(AddressUtils.getAddressResponseDTO2())
                .payment(PaymentUtils.getPaymentResponseDTO2())
                .productQuantity(productQuantity2)
                .build();
    }

    public static CheckoutReqDTO getCheckoutReqDTO1() {
        return CheckoutReqDTO.builder()
                .customerId(1L)
                .productQuantity(productQuantity1)
                .build();
    }

    public static CheckoutReqDTO getCheckoutReqDTO2() {
        return CheckoutReqDTO.builder()
                .customerId(2L)
                .productQuantity(productQuantity2)
                .build();
    }
}
