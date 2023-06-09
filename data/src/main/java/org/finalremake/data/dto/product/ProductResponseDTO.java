package org.finalremake.data.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;

@SuperBuilder
@Getter
@Setter
public class ProductResponseDTO extends AbstractDTO {
    private String name;
    private double price;
}
