package org.finalremake.data.dto.payment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PaypalPaymentReqDTO {
    @NotNull
    @Size(min=16, max=16) private String ACCOUNT_NUMBER;
}
