package org.finalremake.controller.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerReqUpdateDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.finalremake.data.model.customer.Customer;
import org.finalremake.service.customer.CustomerServiceImpl;
import org.finalremake.utils.CustomerUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ContextConfiguration(classes = {CustomerController.class})
public class CustomerControllerTest {
    @MockBean private CustomerServiceImpl customerServiceImpl;
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    private Customer customer;
    private CustomerReqDTO customerReqDTO;
    private CustomerResponseDTO customerResponseDTO;
    private CustomerReqUpdateDTO customerReqUpdateDTO;

    @BeforeEach
    void init() {
        customer = CustomerUtils.getCustomer1();
        customerReqDTO = CustomerUtils.getCustomerReqDTO1();
        customerResponseDTO = CustomerUtils.getCustomerResponseDTO1();
    }

    @Test
    void createCustomer_CreateCustomer_WhenValidPayload() throws Exception {
        when(customerServiceImpl.createCustomer(Mockito.any(CustomerReqDTO.class))).thenReturn(customerResponseDTO);

        mockMvc.perform(post("/customers").content(objectMapper.writeValueAsString(customerReqDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(customerResponseDTO.getId()))
                .andExpect(jsonPath("$.email").value(customerResponseDTO.getEmail()))
                .andExpect(status().isCreated());
    }
}
