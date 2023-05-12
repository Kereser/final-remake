package org.finalremake.data.model.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.address.Address;
import org.finalremake.data.model.payment.Payment;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Delivery extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id", nullable = false)
    private Payment payment;

    private Double totalAmount;
}
