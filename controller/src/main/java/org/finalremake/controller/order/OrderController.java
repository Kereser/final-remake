package org.finalremake.controller.order;

import org.finalremake.data.dto.order.OrderResponseDTO;
import org.finalremake.service.order.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public OrderResponseDTO getOrder(@PathVariable Long id) {
        return orderServiceImpl.getOrder(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDTO createOrder(@RequestParam Long checkoutId) {
        return orderServiceImpl.createOrder(checkoutId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDTO updateOrder(@PathVariable Long id, @RequestParam Long checkoutId) {
        return orderServiceImpl.updateOrder(id, checkoutId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderServiceImpl.deleteOrder(id);
    }


}
