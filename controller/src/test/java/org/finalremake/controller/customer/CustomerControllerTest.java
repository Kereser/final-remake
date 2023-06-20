package org.finalremake.controller.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerReqUpdateDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.finalremake.data.dto.payment.CreditCardPaymentReqDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentReqDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentReqDTO;
import org.finalremake.data.model.customer.Customer;
import org.finalremake.service.address.AddressServiceImpl;
import org.finalremake.service.customer.CustomerServiceImpl;
import org.finalremake.service.payment.PaymentServiceImpl;
import org.finalremake.utils.AddressUtils;
import org.finalremake.utils.CustomerUtils;
import org.finalremake.utils.PaymentUtils;
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
@ContextConfiguration(classes = {CustomerController.class})
public class CustomerControllerTest {
    @MockBean private CustomerServiceImpl customerServiceImpl;
    @MockBean private AddressServiceImpl addressServiceImpl;
    @MockBean private PaymentServiceImpl paymentServiceImpl;
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    private Customer customer;
    private CustomerReqDTO customerReqDTO;
    private CustomerResponseDTO customerResponseDTO;
    private CustomerReqUpdateDTO customerReqUpdateDTO;
    private AddressResponseDTO addressResponseDTO;
    private PaymentResponseDTO paymentResponseDTOCC;
    private CreditCardPaymentReqDTO creditCardPaymentReqDTO;
    private PaymentResponseDTO paymentResponseDTODC;
    private DebitCardPaymentReqDTO debitCardPaymentReqDTO;
    private PaymentResponseDTO paymentResponseDTOPaypal;
    private PaypalPaymentReqDTO paypalPaymentReqDTO;

    @BeforeEach
    void init() {
        customer = CustomerUtils.getCustomer1();
        customerReqDTO = CustomerUtils.getCustomerReqDTO1();
        customerResponseDTO = CustomerUtils.getCustomerResponseDTO1();
        customerReqUpdateDTO = CustomerUtils.getCustomerReqUpdateDTO1();
        addressResponseDTO = AddressUtils.getAddressResponseDTO1();

        creditCardPaymentReqDTO = PaymentUtils.getCreditCardPaymentReqDTO();
        paymentResponseDTOCC = PaymentUtils.getPaymentResponseDTO1();

        paymentResponseDTODC = PaymentUtils.getPaymentResponseDTO3();
        debitCardPaymentReqDTO = PaymentUtils.getDebitCardPaymentReqDTO();

        paymentResponseDTOPaypal = PaymentUtils.getPaymentResponseDTO2();
        paypalPaymentReqDTO = PaymentUtils.getPaypalPaymentReqDTO();
    }

    @Test
    void createCustomer_CreateCustomer_WhenValidPayload() throws Exception {
        when(customerServiceImpl.createCustomer(Mockito.any(CustomerReqDTO.class))).thenReturn(customerResponseDTO);

        mockMvc.perform(post("/customers").content(objectMapper.writeValueAsString(customerReqDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(customerResponseDTO.getId()))
                .andExpect(jsonPath("$.email").value(customerResponseDTO.getEmail()))
                .andExpect(status().isCreated());

        verify(customerServiceImpl).createCustomer(Mockito.any(CustomerReqDTO.class));
        verifyNoMoreInteractions(customerServiceImpl);
    }

    @Test
    void deleteCustomer_DeleteCustomer_WhenValidId() throws Exception {
        MvcResult res = mockMvc.perform(delete("/customers/1")).andReturn();

        assertThat(res.getResponse().getStatus(), is(204));
        verify(customerServiceImpl).deleteCustomer(anyLong());
        verifyNoMoreInteractions(customerServiceImpl);
    }

    @Nested
    class getCustomer {
        @Test
        void getCustomers_GetAllCustomers_WhenValidRequest() throws Exception {
            when(customerServiceImpl.getCustomers()).thenReturn(new ArrayList<>(Arrays.asList(customerResponseDTO)));

            mockMvc.perform(get("/customers"))
                    .andExpect(jsonPath("$.length()").value(1))
                    .andExpect(jsonPath("[0].id").value(customerResponseDTO.getId()))
                    .andExpect(jsonPath("[0].email").value(customerResponseDTO.getEmail()))
                    .andExpect(status().isOk());

            verify(customerServiceImpl).getCustomers();
            verifyNoMoreInteractions(customerServiceImpl);
        }

        @Test
        void getCustomer_GetOneCustomer_WhenValidId() throws Exception {
            when(customerServiceImpl.getCustomer(anyLong())).thenReturn(customerResponseDTO);

            mockMvc.perform(get("/customers/1"))
                    .andExpect(jsonPath("$.id").value(customerResponseDTO.getId()))
                    .andExpect(jsonPath("$.name").value(customerResponseDTO.getName()))
                    .andExpect(status().isFound());

            verify(customerServiceImpl).getCustomer(anyLong());
            verifyNoMoreInteractions(customerServiceImpl);
        }
    }

    @Test
    void updateCustomer_UpdateOneCustomer_WhenValidPayload() throws Exception {
        when(customerServiceImpl.updateCustomer(Mockito.any(CustomerReqUpdateDTO.class), anyLong())).thenReturn(customerResponseDTO);

        mockMvc.perform(put("/customers/1").content(objectMapper.writeValueAsString(customerReqUpdateDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(customerResponseDTO.getId()))
                .andExpect(jsonPath("$.email").value(customerResponseDTO.getEmail()))
                .andExpect(status().isOk());

        verify(customerServiceImpl).updateCustomer(Mockito.any(CustomerReqUpdateDTO.class), anyLong());
        verifyNoMoreInteractions(customerServiceImpl);
    }

    @Nested
    class CustomerAddress {
        @Test
        void getCustomerAddresses_GetAddressesForGivenCustomer_WhenValidId() throws Exception {
            when(addressServiceImpl.getCustomerAddresses(anyLong())).thenReturn(new ArrayList<>(Arrays.asList(addressResponseDTO)));

            mockMvc.perform(get("/customers/1/addresses"))
                    .andExpect(jsonPath("[0].id").value(addressResponseDTO.getId()))
                    .andExpect(jsonPath("[0].city").value(addressResponseDTO.getCity()))
                    .andExpect(status().isOk());
        }
    }

    @Nested
    class CustomerPayments {
        @Test
        void deletePayment_DeleteOnePayment_WhenValidId () throws Exception {
            MvcResult res = mockMvc.perform(delete("/customers/1/payments/1")).andReturn();

            assertThat(res.getResponse().getStatus(), is(204));
            verify(paymentServiceImpl).deletePayment(anyLong());
            verifyNoMoreInteractions(paymentServiceImpl);
        }

        @Nested
        class CreatePayments {
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
    }
}
