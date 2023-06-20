package org.finalremake.controller.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.payment.CreditCardPaymentReqDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentReqDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentReqDTO;
import org.finalremake.data.model.payment.CreditCardPayment;
import org.finalremake.service.payment.PaymentServiceImpl;
import org.finalremake.utils.PaymentUtils;
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
@ContextConfiguration(classes = {PaymentController.class})
public class PaymentControllerTest {
    @MockBean private PaymentServiceImpl paymentServiceImpl;
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    private PaymentResponseDTO paymentResponseDTOCC;
    private CreditCardPaymentReqDTO creditCardPaymentReqDTO;

    private PaymentResponseDTO paymentResponseDTODC;
    private DebitCardPaymentReqDTO debitCardPaymentReqDTO;

    private PaymentResponseDTO paymentResponseDTOPaypal;
    private PaypalPaymentReqDTO paypalPaymentReqDTO;

    @BeforeEach
    void init() {
        creditCardPaymentReqDTO = PaymentUtils.getCreditCardPaymentReqDTO();
        paymentResponseDTOCC = PaymentUtils.getPaymentResponseDTO1();

        paymentResponseDTODC = PaymentUtils.getPaymentResponseDTO3();
        debitCardPaymentReqDTO = PaymentUtils.getDebitCardPaymentReqDTO();

        paymentResponseDTOPaypal = PaymentUtils.getPaymentResponseDTO2();
        paypalPaymentReqDTO = PaymentUtils.getPaypalPaymentReqDTO();
    }

    @Test
    void deletePayment_DeleteOnePayment_WhenValidIdFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/customers/1/payments/1")).andReturn();

        assertThat(res.getResponse().getStatus(), is(204));
        verify(paymentServiceImpl).deletePayment(anyLong());
        verifyNoMoreInteractions(paymentServiceImpl);
    }

    @Test
    void createCreditCardPayment_CreateCCPayment_WhenValidPayload() throws Exception {
        when(paymentServiceImpl.createCreditCardPayment(Mockito.any(CreditCardPaymentReqDTO.class), anyLong())).thenReturn(paymentResponseDTOCC);

        mockMvc.perform(post("/customers/1/payments/credit-card").content(objectMapper.writeValueAsString(creditCardPaymentReqDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(paymentResponseDTOCC.getId()))
                .andExpect(jsonPath("$.name").value(paymentResponseDTOCC.getName()))
                .andExpect(status().isCreated());

        verify(paymentServiceImpl).createCreditCardPayment(Mockito.any(CreditCardPaymentReqDTO.class), anyLong());
        verifyNoMoreInteractions(paymentServiceImpl);
    }

    @Test
    void createDebitCardPayment_CreateDBPayment_WhenValidPayload() throws Exception {
        when(paymentServiceImpl.createDebitCardPayment(Mockito.any(DebitCardPaymentReqDTO.class), anyLong())).thenReturn(paymentResponseDTODC);

        mockMvc.perform(post("/customers/1/payments/debit-card").content(objectMapper.writeValueAsString(debitCardPaymentReqDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(paymentResponseDTODC.getId()))
                .andExpect(jsonPath("$.name").value(paymentResponseDTODC.getName()))
                .andExpect(status().isCreated());

        verify(paymentServiceImpl).createDebitCardPayment(Mockito.any(DebitCardPaymentReqDTO.class), anyLong());
        verifyNoMoreInteractions(paymentServiceImpl);
    }

    @Test
    void createPaypalPayment_CreatePaypalPayment_WhenValidPayload() throws Exception {
        when(paymentServiceImpl.createPaypalPayment(Mockito.any(PaypalPaymentReqDTO.class), anyLong())).thenReturn(paymentResponseDTOPaypal);

        mockMvc.perform(post("/customers/1/payments/paypal").content(objectMapper.writeValueAsString(paypalPaymentReqDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(paymentResponseDTOPaypal.getId()))
                .andExpect(jsonPath("$.name").value(paymentResponseDTOPaypal.getName()))
                .andExpect(status().isCreated());

        verify(paymentServiceImpl).createPaypalPayment(Mockito.any(PaypalPaymentReqDTO.class), anyLong());
        verifyNoMoreInteractions(paymentServiceImpl);
    }
}