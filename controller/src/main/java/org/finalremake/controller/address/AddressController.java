package org.finalremake.controller.address;

import jakarta.validation.Valid;
import org.finalremake.data.dto.address.AddressReqDTO;
import org.finalremake.data.dto.address.AddressReqUpdateDTO;
import org.finalremake.data.dto.address.AddressResponseDTO;
import org.finalremake.service.address.AddressServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private AddressServiceImpl addressServiceImpl;

    public AddressController(AddressServiceImpl addressServiceImpl) {
        this.addressServiceImpl = addressServiceImpl;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public AddressResponseDTO getAddress(@PathVariable Long id) {
        return addressServiceImpl.getAddress(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressResponseDTO> getAddresses() {
        return addressServiceImpl.getAddresses();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Long id) {
        addressServiceImpl.deleteAddress(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponseDTO updateAddress(@PathVariable Long id, @RequestBody @Valid AddressReqUpdateDTO addressReqUpdateDTO) {
        return addressServiceImpl.updateAddress(addressReqUpdateDTO, id);
    }
}

