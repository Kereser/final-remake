package org.finalremake.data.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.finalremake.data.dto.delivery.DeliveryResponseDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;

@SuperBuilder
@Getter
@Setter
public class OrderResponseDTO extends AbstractDTO {
    private CheckoutResponseDTO checkout;
    private DeliveryResponseDTO delivery;
    private PaymentResponseDTO payment;
    private Boolean status;
}
