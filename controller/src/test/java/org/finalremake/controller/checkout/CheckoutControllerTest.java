package org.finalremake.controller.checkout;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.checkout.CheckoutReqAndReqUpdateDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.finalremake.service.checkout.CheckoutServiceImpl;
import org.finalremake.utils.CheckoutUtils;
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
        when(checkoutServiceImpl.createCheckout(anyMap(), Mockito.any(CheckoutReqAndReqUpdateDTO.class))).thenReturn(checkoutResponseDTO);

        mockMvc.perform(post("/checkouts").param("customerId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(checkoutReqAndReqUpdateDTO)))
                .andExpect(jsonPath("$.id").value(checkoutResponseDTO.getId()))
                .andExpect(jsonPath("$.customer.id").value(checkoutResponseDTO.getCustomer().getId()))
                .andExpect(status().isCreated());

        verify(checkoutServiceImpl).createCheckout(anyMap(), Mockito.any(CheckoutReqAndReqUpdateDTO.class));
        verifyNoMoreInteractions(checkoutServiceImpl);
    }

    @Test
    void deleteCheckout_deleteOneCheckout_WhenValidId() throws Exception {
        MvcResult res = mockMvc.perform(delete("/checkouts/1")).andReturn();

        assertThat(res.getResponse().getStatus(), is(204));
        verify(checkoutServiceImpl).deleteCheckout(anyLong());
        verifyNoMoreInteractions(checkoutServiceImpl);
    }

    @Test
    void updateCheckout_updateOneCheckout_WhenValidPayload() throws Exception {
        when(checkoutServiceImpl.updateCheckout(anyLong(), anyMap(), Mockito.any(CheckoutReqAndReqUpdateDTO.class))).thenReturn(checkoutResponseDTO);

        mockMvc.perform(put("/checkouts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(checkoutReqAndReqUpdateDTO)))
                .andExpect(jsonPath("$.id").value(checkoutResponseDTO.getId()))
                .andExpect(jsonPath("$.customer.id").value(checkoutResponseDTO.getCustomer().getId()))
                .andExpect(status().isOk());

        verify(checkoutServiceImpl).updateCheckout(anyLong(), anyMap(), Mockito.any(CheckoutReqAndReqUpdateDTO.class));
        verifyNoMoreInteractions(checkoutServiceImpl);
    }

    @Test
    void getCheckout_getOneCheckout_WhenValidId() throws Exception {
        when(checkoutServiceImpl.getCheckout(anyLong())).thenReturn(checkoutResponseDTO);

        mockMvc.perform(get("/checkouts/1"))
                .andExpect(jsonPath("$.id").value(checkoutResponseDTO.getId()))
                .andExpect(jsonPath("$.customer.id").value(checkoutResponseDTO.getCustomer().getId()))
                .andExpect(status().isFound());

        verify(checkoutServiceImpl).getCheckout(anyLong());
        verifyNoMoreInteractions(checkoutServiceImpl);
    }
}