package org.finalremake.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.product.ProductReqDTO;
import org.finalremake.data.dto.product.ProductReqUpdateDTO;
import org.finalremake.data.dto.product.ProductResponseDTO;
import org.finalremake.data.model.product.Product;
import org.finalremake.service.product.ProductServiceImpl;
import org.finalremake.utils.ProductUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;

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
    private ProductReqDTO productReqDTO;
    private ProductResponseDTO productResponseDTO;
    private ProductReqUpdateDTO productReqUpdateDTO;

    @BeforeEach
    void init() {
        productReqDTO = ProductUtils.getProductReqDTO1();
        productResponseDTO = ProductUtils.getProductResponseDTO1();
        productReqUpdateDTO = ProductUtils.getProductReqUpdateDTO1();
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

    @Test
    void updateProduct_UpdateProduct_WhenValidPayload() throws Exception {
        when(productServiceImpl.updateProduct(Mockito.any(ProductReqUpdateDTO.class), anyLong())).thenReturn(productResponseDTO);

        mockMvc.perform(put("/products/1").content(objectMapper.writeValueAsString(productReqUpdateDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(productResponseDTO.getId()))
                .andExpect(jsonPath("$.price").value(productResponseDTO.getPrice()))
                .andExpect(status().isOk());

        verify(productServiceImpl).updateProduct(Mockito.any(ProductReqUpdateDTO.class), anyLong());
        verifyNoMoreInteractions(productServiceImpl);
    }

    @Nested
    class getProduct {
        @Test
        void getProduct_GetOneProduct_WhenValidInput() throws Exception {
            when(productServiceImpl.getProduct(anyLong())).thenReturn(productResponseDTO);

            mockMvc.perform(get("/products/1"))
                  .andExpect(jsonPath("$.id").value(productResponseDTO.getId()))
                  .andExpect(jsonPath("$.price").value(productResponseDTO.getPrice()))
                  .andExpect(status().isFound());

            verify(productServiceImpl).getProduct(anyLong());
            verifyNoMoreInteractions(productServiceImpl);
        }

        @Test
        void getProducts_GetAllProducts_WhenValid() throws Exception {
            when(productServiceImpl.getProducts()).thenReturn(new ArrayList<>(Arrays.asList(productResponseDTO)));

            mockMvc.perform(get("/products"))
                 .andExpect(jsonPath("$[0].id").value(productResponseDTO.getId()))
                 .andExpect(jsonPath("$[0].price").value(productResponseDTO.getPrice()))
                 .andExpect(status().isOk());

            verify(productServiceImpl).getProducts();
            verifyNoMoreInteractions(productServiceImpl);
        }
    }
}