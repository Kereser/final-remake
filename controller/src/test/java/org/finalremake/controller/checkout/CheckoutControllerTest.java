package org.finalremake.controller.checkout;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.checkout.CheckoutReqAndReqUpdateDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.finalremake.service.checkout.CheckoutServiceImpl;
import org.finalremake.utils.CheckoutUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
@ContextConfiguration(classes = {CheckoutController.class})
class CheckoutControllerTest {
    @MockBean private CheckoutServiceImpl checkoutServiceImpl;
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    private CheckoutResponseDTO checkoutResponseDTO;
    private CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO;
    private Map<Long, Integer> productsQuantity;

    @BeforeEach
    void init() {
        checkoutResponseDTO = CheckoutUtils.getCheckoutResponseDTO1();
        checkoutReqAndReqUpdateDTO = CheckoutUtils.getCheckoutReqDTO1();
    }

    @Test
    void createCheckout_createOneCheckout_WhenValidPayload() throws Exception {
        when(checkoutServiceImpl.createCheckout(anyLong(), anyMap())).thenReturn(checkoutResponseDTO);

        mockMvc.perform(post("/checkouts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(checkoutReqAndReqUpdateDTO)))
                .andExpect(jsonPath("$.id").value(checkoutResponseDTO.getId()))
                .andExpect(jsonPath("$.customer").value(checkoutResponseDTO.getCustomer()))
                .andExpect(status().isCreated());

        verify(checkoutServiceImpl).createCheckout(anyLong(), anyMap());
        verifyNoMoreInteractions(checkoutServiceImpl);
    }
}