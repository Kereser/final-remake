package org.finalremake.data.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.YearMonth;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class DebitCardPayment extends AbstractPayment {
    @NotNull @Size(min=16, max=16) private String ACCOUNT_NUMBER;

    @NotNull @Future @DateTimeFormat(pattern = "MM/yyyy") private YearMonth goodTrough;

    @NotNull @Size(min = 3, max = 3) private int cvv;

    @OneToOne @JoinColumn(name = "payment_id", nullable = false) private Payment payment;
}
