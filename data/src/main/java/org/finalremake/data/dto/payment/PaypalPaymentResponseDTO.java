package org.finalremake.data.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.finalremake.data.dto.AbstractDTO;

@Builder
@Getter
@Setter
public class PaypalPaymentResponseDTO extends AbstractDTO {
    private String ACCOUNT_NUMBER;
    private PaymentResponseDTO paymentResponseDTO;
}
