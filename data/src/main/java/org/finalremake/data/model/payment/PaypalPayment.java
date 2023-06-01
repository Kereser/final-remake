package org.finalremake.data.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.ExcludeSuperclassListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class PaypalPayment extends AbstractPayment {
    @NotNull @Size(min=16, max=16) private String ACCOUNT_NUMBER;

    @OneToOne @JoinColumn(name = "payment_id", nullable = false) private Payment payment;

    @Override
    public String getAccountNumber() {
        return super.getAccountNumber();
    }
}
