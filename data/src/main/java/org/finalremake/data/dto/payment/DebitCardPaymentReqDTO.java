package org.finalremake.data.dto.payment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.YearMonth;

@Builder
@Getter
@Setter
public class DebitCardPaymentReqDTO {
    @NotNull
    @Size(min=16, max=16) private String ACCOUNT_NUMBER;

    @NotNull
    @Future
    @DateTimeFormat(pattern = "MM/yyyy")
    private YearMonth goodTrough;
}
