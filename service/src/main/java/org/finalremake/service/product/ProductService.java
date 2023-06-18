package org.finalremake.service.product;

import org.finalremake.data.dto.product.ProductReqDTO;
import org.finalremake.data.dto.product.ProductReqUpdateDTO;
import org.finalremake.data.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    void deleteProduct(Long productId);
    ProductResponseDTO createProduct(ProductReqDTO productReqDTO);
    ProductResponseDTO getProduct(Long productId);
    List<ProductResponseDTO> getProducts();
    ProductResponseDTO updateProduct(ProductReqUpdateDTO productReqUpdateDTO, Long id);
}
