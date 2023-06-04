package org.finalremake.controller.payment;

import org.finalremake.data.dto.payment.CreditCardPaymentReqDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentReqDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentReqDTO;
import org.finalremake.service.payment.PaymentServiceImpl;
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
@ContextConfiguration(classes = {PaymentController.class})
public class PaymentControllerTest {
    @MockBean private PaymentServiceImpl paymentServiceImpl;
    @Autowired private MockMvc mockMvc;
    private PaymentResponseDTO paymentResponseDTOCC;
    private PaymentResponseDTO paymentResponseDTODB;
    private PaymentResponseDTO paymentResponseDTOPaypal;
    private CreditCardPaymentReqDTO creditCardPaymentReqDTO;
    private DebitCardPaymentReqDTO debitCardPaymentReqDTO;
    private PaypalPaymentReqDTO paypalPaymentReqDTO;

    @BeforeEach
    void init() {

    }

    @Test
    void deletePayment_DeleteOnePayment_WhenValidIdFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/customers/1/payments")).andReturn();

        assertThat(res.getResponse().getStatus(), is(204));
        verify(paymentServiceImpl).deletePayment(anyLong());
        verifyNoMoreInteractions(paymentServiceImpl);
    }
}