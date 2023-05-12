package org.finalremake.data.model.address;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.customer.Customer;

@Entity
@Getter
@NoArgsConstructor
public class Address extends AbstractEntity {

    @NotNull
    private String direction;

    @NotNull
    private String city;

    private String country;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;
}
