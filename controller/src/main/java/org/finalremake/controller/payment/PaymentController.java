package org.finalremake.controller.payment;

import org.finalremake.service.payment.PaymentServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/{customerId}/payments")
public class PaymentController {
    private PaymentServiceImpl paymentServiceImpl;

    public PaymentController(PaymentServiceImpl paymentServiceImpl) {
        this.paymentServiceImpl = paymentServiceImpl;
    }
}
