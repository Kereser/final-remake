package org.finalremake.data.model.order;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.customer.Customer;
import org.finalremake.data.model.delivery.Delivery;
import org.finalremake.data.model.checkout.Checkout;
import org.finalremake.data.model.payment.Payment;

import java.util.Map;

@Entity
@Table(name = "orders")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    private Map<Long, Integer> productQuantity;

    private Boolean active;
}
