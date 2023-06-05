package org.finalremake.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.product.ProductReqDTO;
import org.finalremake.data.dto.product.ProductReqUpdateDTO;
import org.finalremake.data.dto.product.ProductResponseDTO;
import org.finalremake.data.model.product.Product;
import org.finalremake.service.product.ProductServiceImpl;
import org.finalremake.utils.ProductUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ContextConfiguration(classes = {ProductController.class})
class ProductControllerTest {
    @MockBean private ProductServiceImpl productServiceImpl;
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    private Product product;
    private ProductReqDTO productReqDTO;
    private ProductResponseDTO productResponseDTO;
    private ProductReqUpdateDTO productReqUpdateDTO;

    @BeforeEach
    void init() {
        product = ProductUtils.getProduct1();
        productReqDTO = ProductUtils.getProductReqDTO1();
        productResponseDTO = ProductUtils.getProductResponseDTO1();
    }

    @Test
    void deleteProduct_DeleteOneProduct_WhenValidId() throws Exception {
        MvcResult res = mockMvc.perform(delete("/products/1")).andReturn();

        assertThat(res.getResponse().getStatus(), is(204));
        verify(productServiceImpl).deleteProduct(anyLong());
        verifyNoMoreInteractions(productServiceImpl);
    }

    @Test
    void createProduct_CreateProduct_WhenValidPayload() throws Exception {
        when(productServiceImpl.createProduct(Mockito.any(ProductReqDTO.class))).thenReturn(productResponseDTO);

        mockMvc.perform(post("/products").content(objectMapper.writeValueAsString(productReqDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productResponseDTO.getId()))
                .andExpect(jsonPath("$.name").value(productResponseDTO.getName()))
                .andExpect(status().isCreated());

        verify(productServiceImpl).createProduct(Mockito.any(ProductReqDTO.class));
        verifyNoMoreInteractions(productServiceImpl);
    }
}