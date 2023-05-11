package org.finalremake.data.dto.checkout;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.finalremake.data.model.payment.Payment;

import java.util.Map;


@Builder
@Getter
@Setter
public class CheckoutResponseDTO extends AbstractDTO {
    private CustomerResponseDTO customer;
    private AddressResponseDTO address;
    private Payment payment;
    private Map<Long, Integer> productQuantity;
}
