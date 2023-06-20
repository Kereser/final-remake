package org.finalremake.controller.customer;

import jakarta.validation.Valid;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerReqUpdateDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.finalremake.data.dto.payment.CreditCardPaymentReqDTO;
import org.finalremake.data.dto.payment.DebitCardPaymentReqDTO;
import org.finalremake.data.dto.payment.PaymentResponseDTO;
import org.finalremake.data.dto.payment.PaypalPaymentReqDTO;
import org.finalremake.service.address.AddressServiceImpl;
import org.finalremake.service.customer.CustomerServiceImpl;
import org.finalremake.service.payment.PaymentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerServiceImpl customerServiceImpl;
    private AddressServiceImpl addressServiceImpl;
    private PaymentServiceImpl paymentServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl, AddressServiceImpl addressServiceImpl, PaymentServiceImpl paymentServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
        this.addressServiceImpl = addressServiceImpl;
        this.paymentServiceImpl = paymentServiceImpl;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {
        return customerServiceImpl.getCustomer(id);
    }

    @GetMapping("/{id}/addresses")
    public List<AddressResponseDTO> getCustomerAddresses(@PathVariable Long id) {
        return addressServiceImpl.getCustomerAddresses(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponseDTO> getCustomers() {
        return customerServiceImpl.getCustomers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO createCustomer(@RequestBody @Valid CustomerReqDTO customerReqDTO) {
        return customerServiceImpl.createCustomer(customerReqDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerReqUpdateDTO customerReqUpdateDTO) {
        return customerServiceImpl.updateCustomer(customerReqUpdateDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerServiceImpl.deleteCustomer(id);
    }

    @RestController
    @RequestMapping("/customers/{id}/payments")
    class CustomerPayments {

        @DeleteMapping("/{paymentId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        void deletePayment(@PathVariable Long paymentId) {
            paymentServiceImpl.deletePayment(paymentId);
        }

        @PostMapping("/credit-card")
        @ResponseStatus(HttpStatus.CREATED)
        public PaymentResponseDTO createCreditCardPayment(@RequestBody @Valid CreditCardPaymentReqDTO creditCardPaymentReqDTO, @PathVariable Long id) {
            return paymentServiceImpl.createCreditCardPayment(creditCardPaymentReqDTO, id);
        }

        @PostMapping("/debit-card")
        @ResponseStatus(HttpStatus.CREATED)
        public PaymentResponseDTO createDebitCardPayment(@RequestBody @Valid DebitCardPaymentReqDTO debitCardPaymentReqDTO, @PathVariable Long id) {
            return paymentServiceImpl.createDebitCardPayment(debitCardPaymentReqDTO, id);
        }

        @PostMapping("/paypal")
        @ResponseStatus(HttpStatus.CREATED)
        public PaymentResponseDTO createPaypalPayment(@RequestBody @Valid PaypalPaymentReqDTO paypalPaymentReqDTO, @PathVariable Long id) {
            return paymentServiceImpl.createPaypalPayment(paypalPaymentReqDTO, id);
        }
    }
}
