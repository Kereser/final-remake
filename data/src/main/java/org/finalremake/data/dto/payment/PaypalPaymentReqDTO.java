package org.finalremake.data.dto.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaypalPaymentReqDTO {
    @NotNull @Email private String ACCOUNT_NUMBER;
}
