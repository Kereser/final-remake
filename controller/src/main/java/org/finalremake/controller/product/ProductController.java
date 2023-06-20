package org.finalremake.controller.product;

import jakarta.validation.Valid;
import org.finalremake.data.dto.product.ProductReqDTO;
import org.finalremake.data.dto.product.ProductReqUpdateDTO;
import org.finalremake.data.dto.product.ProductResponseDTO;
import org.finalremake.service.product.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ProductResponseDTO getProduct(@PathVariable Long id) {
        return productServiceImpl.getProduct(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDTO> getProducts() {
        return productServiceImpl.getProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(@RequestBody @Valid ProductReqDTO productReqDTO) {
        return productServiceImpl.createProduct(productReqDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody @Valid ProductReqUpdateDTO productReqUpdateDTO) {
        return productServiceImpl.updateProduct(productReqUpdateDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productServiceImpl.deleteProduct(id);
    }
}
