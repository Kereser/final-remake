package org.finalremake.data.dto.address;

import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.model.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AbstractDTO.class}, componentModel = "spring")
public interface AddressMapper {
    AddressResponseDTO getAddressResponseDTO(Address address);
}
