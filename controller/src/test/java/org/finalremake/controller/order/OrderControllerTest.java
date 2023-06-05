package org.finalremake.controller.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.order.OrderResponseDTO;
import org.finalremake.service.order.OrderServiceImpl;
import org.finalremake.utils.OrderUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ContextConfiguration(classes = {OrderController.class})
class OrderControllerTest {
    @MockBean private OrderServiceImpl orderServiceImpl;
    @Autowired private MockMvc mockMvc;
    private OrderResponseDTO orderResponseDTO;

    @BeforeEach
    void init() {
        orderResponseDTO = OrderUtils.getOrderResponseDTO1();
    }

    @Test
    void createOrder_CreateOneOrder_WhenValidPayload() throws Exception {
        when(orderServiceImpl.createOrder(anyLong())).thenReturn(orderResponseDTO);

        mockMvc.perform(post("/orders").param("customerId", "1"))
                .andExpect(jsonPath("$.payment").value(orderResponseDTO.getPayment()))
                .andExpect(jsonPath("$.id").value(orderResponseDTO.getId()))
                .andExpect(status().isCreated());

        verify(orderServiceImpl).createOrder(anyLong());
        verifyNoMoreInteractions(orderServiceImpl);
    }

    @Test
    void deleteOrder_DeleteOneOrder_WhenValidId() throws Exception {
        MvcResult res = mockMvc.perform(delete("/orders/1")).andReturn();

        assertThat(res.getResponse().getStatus(), is(204));
        verify(orderServiceImpl).deleteOrder(anyLong());
        verifyNoMoreInteractions(orderServiceImpl);
    }
}