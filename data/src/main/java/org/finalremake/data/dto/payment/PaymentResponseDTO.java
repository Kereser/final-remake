package org.finalremake.data.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.model.payment.PaymentType;

@SuperBuilder
@Getter
@Setter
public class PaymentResponseDTO extends AbstractDTO {
    private PaymentType name;
}
