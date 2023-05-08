package org.finalremake.data.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product extends AbstractEntity{
    @NotNull
    private String name;

    @Min(1)
    @NotNull
    private double price;
}
