package org.finalremake.data.model.payment;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.model.AbstractEntity;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractPayment extends AbstractEntity implements IPayment {
    @NotNull @Size(min=16, max=16) private String ACCOUNT_NUMBER;

    @Override
    public String getAccountNumber() {
        return ACCOUNT_NUMBER.substring(0,5) + "*".repeat(12);
    }
}
