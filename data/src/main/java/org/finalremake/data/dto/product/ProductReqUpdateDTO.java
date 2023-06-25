package org.finalremake.data.dto.product;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReqUpdateDTO {
    @Nullable private String name;
    @Min(1) @NotNull private double price;
}
