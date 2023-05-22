package org.finalremake.data.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.YearMonth;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class CreditCardPayment extends AbstractPayment {
    @NotNull
    @Future
    @DateTimeFormat(pattern = "MM/yyyy")
    private YearMonth goodTrough;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;
}
