package org.finalremake.service.address;

import org.finalremake.data.dto.address.AddressReqUpdateDTO;
import org.finalremake.data.model.address.AddressMapper;
import org.finalremake.data.dto.address.AddressReqDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.data.respository.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponseDTO getAddress(Long id) {
        return null;
    }

    @Override
    public void deleteAddress(Long id) {

    }

    @Override
    public List<AddressResponseDTO> getAddresses() {
        return null;
    }

    @Override
    public List<AddressResponseDTO> getCustomerAddresses(Long customerId) {
        return null;
    }

    @Override
    public AddressResponseDTO createAddress(AddressReqDTO addressReqDTO, Long customerId) {
        return null;
    }

    @Override
    public AddressResponseDTO updateAddress(AddressReqUpdateDTO addressReqUpdateDTO, Long addressId) {
        return null;
    }
}
