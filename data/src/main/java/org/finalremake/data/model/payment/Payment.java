package org.finalremake.data.model.payment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.customer.Customer;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class Payment extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private PaymentType name;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;
}
