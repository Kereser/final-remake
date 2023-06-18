package org.finalremake.service.product;

import org.finalremake.data.dto.product.ProductReqDTO;
import org.finalremake.data.dto.product.ProductReqUpdateDTO;
import org.finalremake.data.dto.product.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public ProductResponseDTO createProduct(ProductReqDTO productReqDTO) {
        return null;
    }

    @Override
    public ProductResponseDTO getProduct(Long productId) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductReqUpdateDTO productReqUpdateDTO, Long id) {
        return null;
    }
}
