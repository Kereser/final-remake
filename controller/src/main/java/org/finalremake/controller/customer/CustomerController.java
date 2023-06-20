package org.finalremake.controller.customer;

import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerReqUpdateDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
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
    public CustomerResponseDTO createCustomer(@RequestBody CustomerReqDTO customerReqDTO) {
        return customerServiceImpl.createCustomer(customerReqDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerReqUpdateDTO customerReqUpdateDTO) {
        return customerServiceImpl.updateCustomer(customerReqUpdateDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerServiceImpl.deleteCustomer(id);
    }
}
