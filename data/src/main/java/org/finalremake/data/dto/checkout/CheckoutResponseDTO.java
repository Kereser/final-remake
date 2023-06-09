package org.finalremake.data.dto.checkout;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;

import java.util.Map;


@SuperBuilder
@Getter
@Setter
public class CheckoutResponseDTO extends AbstractDTO {
    private CustomerResponseDTO customer;
    private AddressResponseDTO address;
    private PaymentResponseDTO payment;
    private Map<Long, Integer> productQuantity;
}
