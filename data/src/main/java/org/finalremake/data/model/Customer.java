package org.finalremake.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Customer extends AbstractEntity {

    private String name;

    @NotNull
    @Size(min = 3, max =18)
    private String surname;

    @Email
    private String email;

    private Integer phone;

    private Integer age;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
