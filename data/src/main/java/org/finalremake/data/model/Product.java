package org.finalremake.data.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;

@Entity
public class Product extends AbstractEntity{
    private String name;
    @Min(1)
    private double price;
}
