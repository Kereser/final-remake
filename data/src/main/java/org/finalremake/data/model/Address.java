package org.finalremake.data.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address extends AbstractEntity {

    @NotNull
    private String direction;

    @NotNull
    private String city;

    private String country;
}
