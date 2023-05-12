package org.finalremake.data.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.finalremake.data.dto.AbstractDTO;

@Builder
@Getter
@Setter
public class DebitCardPaymentResponseDTO extends AbstractDTO {
    private String ACCOUNT_NUMBER;
    private PaymentResponseDTO payment;
}
