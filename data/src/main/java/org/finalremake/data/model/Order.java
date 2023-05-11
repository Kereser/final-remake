package org.finalremake.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.finalremake.data.model.payment.Payment;

@Entity
public class Order extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "checkout_id", referencedColumnName = "id", nullable = false)
    private Checkout checkout;

    @OneToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    private Delivery delivery;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id", nullable = false)
    private Payment payment;

    private Boolean status;
}
