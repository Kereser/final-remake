package org.finalremake.data.model.product;

import org.finalremake.data.dto.product.ProductResponseDTO;
import org.finalremake.data.model.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDTO getProductResponseDTO(Product product);
}
