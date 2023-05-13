package org.finalremake.data.dto.address;

import org.finalremake.data.model.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressResponseDTO getAddressResponseDTO(Address address);
}
