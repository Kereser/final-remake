package org.finalremake.data.dto.payment;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.YearMonth;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardPaymentReqDTO {
    @NotNull @Size(min=16, max=16) private String ACCOUNT_NUMBER;

    @NotNull @Min(100) @Max(999) private int cvv;

    @NotNull @Future @DateTimeFormat(pattern = "MM/yyyy") private YearMonth goodTrough;
}
