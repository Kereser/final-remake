package org.finalremake.data.dto.product;

import org.finalremake.data.model.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDTO getProductResponseDTO(Product product);
}
