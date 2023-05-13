package org.finalremake.data.model.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.model.AbstractEntity;
import org.finalremake.data.model.address.Address;
import org.finalremake.data.model.checkout.Checkout;
import org.finalremake.data.model.payment.Payment;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class Customer extends AbstractEntity {

    private String name;

    @NotNull
    @Size(min = 3, max =18)
    private String surname;

    @Email
    private String email;

    private String phone;

    private Integer age;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToOne(mappedBy = "customer")
    private Checkout checkout;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;
}
