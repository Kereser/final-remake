package org.finalremake.data.model.payment;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.finalremake.data.model.AbstractEntity;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractPayment extends AbstractEntity implements IPayment {
    @NotNull
    private String ACCOUNT_NUMBER;

    @Override
    public String getAccountNumber() {
        return ACCOUNT_NUMBER.substring(0,5) + "*".repeat(12);
    }
}
