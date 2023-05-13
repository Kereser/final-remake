package org.finalremake.data.dto.order;

import org.finalremake.data.model.order.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponseDTO getOrderResponseDTO(Order order);
}
