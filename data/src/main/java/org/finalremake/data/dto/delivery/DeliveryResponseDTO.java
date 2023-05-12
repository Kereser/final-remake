package org.finalremake.data.dto.delivery;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;

@SuperBuilder
@Getter
@Setter
public class DeliveryResponseDTO extends AbstractDTO {
    private AddressResponseDTO address;
    private PaymentResponseDTO payment;
    private Double totalAmount;
}
