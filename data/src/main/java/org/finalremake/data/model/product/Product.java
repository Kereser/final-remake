package org.finalremake.data.model.product;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.finalremake.data.model.AbstractEntity;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product extends AbstractEntity {
    @NotNull
    private String name;

    @Min(1)
    @NotNull
    private double price;
}
