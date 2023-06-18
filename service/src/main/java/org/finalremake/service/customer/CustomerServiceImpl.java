package org.finalremake.service.customer;

import org.finalremake.data.dto.customer.CustomerReqDTO;
import org.finalremake.data.dto.customer.CustomerReqUpdateDTO;
import org.finalremake.data.dto.customer.CustomerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerResponseDTO getCustomer(Long customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        return null;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerReqDTO customerReqDTO) {
        return null;
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerReqUpdateDTO customerUpdateDTO, Long id) {
        return null;
    }
}
