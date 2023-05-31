package org.finalremake.data.model.delivery;

import org.finalremake.data.dto.delivery.DeliveryResponseDTO;
import org.finalremake.data.model.delivery.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryResponseDTO getDeliveryResponseDTO(Delivery delivery);
}
