package org.finalremake.data.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;

@SuperBuilder
@Getter
@Setter
public class CreditCardPaymentResponseDTO extends AbstractDTO {
    private String ACCOUNT_NUMBER;
    private PaymentResponseDTO payment;
}
