package org.finalremake.data.dto.checkout;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.model.address.Address;
import org.finalremake.data.model.customer.Customer;
import org.finalremake.data.model.payment.Payment;

import java.util.Map;


@Builder
@Getter
@Setter
public class CheckoutResponseDTO extends AbstractDTO {
    private Customer customer;
    private Address address;
    private Payment payment;
    private Map<Long, Integer> productQuantity;
}
