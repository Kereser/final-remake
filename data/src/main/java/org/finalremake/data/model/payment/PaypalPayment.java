package org.finalremake.data.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PaypalPayment extends AbstractPayment {

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Override
    public String getAccountNumber() {
        return super.getAccountNumber();
    }
}
