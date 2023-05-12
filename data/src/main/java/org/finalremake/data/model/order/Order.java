package org.finalremake.data.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.delivery.Delivery;
import org.finalremake.data.model.checkout.Checkout;
import org.finalremake.data.model.payment.Payment;

@Entity
@Table(name = "orders")
@Builder
@AllArgsConstructor
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

    private Boolean status;
}
