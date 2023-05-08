package org.finalremake.data.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class CreditCardPayment extends AbstractPayment {
    @NotNull
    @Future
    @DateTimeFormat(pattern = "MM/yyyy")
    private Date goodTrough;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;
}
