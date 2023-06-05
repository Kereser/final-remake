package org.finalremake.service.order;

import org.finalremake.data.dto.order.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    List<OrderResponseDTO> getOrders();
    OrderResponseDTO getOrder(Long id);
    void deleteOrder(Long id);
    OrderResponseDTO createOrder(Long checkoutId);
    OrderResponseDTO updateOrder(Long orderId, Long checkoutId);
}


