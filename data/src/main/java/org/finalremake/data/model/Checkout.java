package org.finalremake.data.model;

import jakarta.persistence.*;
import org.finalremake.data.model.payment.Payment;

import java.util.Map;

@Entity
public class Checkout extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @ElementCollection
    @CollectionTable(name = "product_quantity",
    joinColumns = {@JoinColumn(name = "checkout_id")})
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Long, Integer> productQuantity;
}
