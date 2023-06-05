package org.finalremake.service.order;

import org.finalremake.data.dto.order.OrderResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderResponseDTO> getOrders() {
        return null;
    }

    @Override
    public OrderResponseDTO getOrder(Long id) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public OrderResponseDTO createOrder(Long checkoutId) {
        return null;
    }

    @Override
    public OrderResponseDTO updateOrder(Long orderId, Long checkoutId) {
        return null;
    }
}
