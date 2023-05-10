package org.finalremake.data.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.Customer;

@Entity
public class Payment extends AbstractEntity {
    private PaymentType name;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;
}
