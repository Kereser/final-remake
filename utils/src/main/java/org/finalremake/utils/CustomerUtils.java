package org.finalremake.utils;

import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.finalremake.data.model.address.Address;
import org.finalremake.data.model.customer.Customer;
import org.finalremake.data.model.payment.Payment;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class CustomerUtils {
    public static Customer getCustomer1 () {
        return Customer.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .age(24)
                .email("Carlos@gmail.com")
                .name("Carlos")
                .surname("Ibarra")
                .phone("3213349940")
                .addresses(new ArrayList<Address>())
                .checkout(null)
                .payments(new ArrayList<Payment>())
                .build();
    }

    public static Customer getCustomer2 () {
        return Customer.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .age(52)
                .email("P@gmail.com")
                .name("Pedro")
                .surname("Sabarriaga")
                .phone("3044533392")
                .addresses(new ArrayList<Address>())
                .checkout(null)
                .payments(new ArrayList<Payment>())
                .build();
    }

    public static CustomerResponseDTO getCustomerResponseDTO1 () {
        return CustomerResponseDTO.builder()
                .id(1L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .age(24)
                .email("Carlos@gmail.com")
                .name("Carlos")
                .surname("Ibarra")
                .phone("3213349940")
                .addresses(new ArrayList<>(Arrays.asList(AddressUtils.getAddressResponseDTO1(), AddressUtils.getAddressResponseDTO2())))
                .payments(new ArrayList<>(Arrays.asList(PaymentUtils.getPaymentResponseDTO1(), PaymentUtils.getPaymentResponseDTO2())))
                .build();
    }

    public static CustomerResponseDTO getCustomerResponseDTO2 () {
        return CustomerResponseDTO.builder()
                .id(2L)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .age(52)
                .email("P@gmail.com")
                .name("Pedro")
                .surname("Sabarriaga")
                .phone("3044533392")
                .addresses(new ArrayList<>(Arrays.asList(AddressUtils.getAddressResponseDTO1())))
                .payments(new ArrayList<>(Arrays.asList(PaymentUtils.getPaymentResponseDTO1())))
                .build();
    }

    public static CustomerReqDTO getCustomerReqDTO1 () {
        return CustomerReqDTO.builder()
                .age(24)
                .email("Carlos@gmail.com")
                .name("Carlos")
                .surname("Ibarra")
                .phone("3213349940")
                .build();
    }

    public static CustomerReqDTO getCustomerReqDTO2 () {
        return CustomerReqDTO.builder()
                .age(52)
                .email("P@gmail.com")
                .name("Pedro")
                .surname("Sabarriaga")
                .phone("3044533392")
                .build();
    }
}
