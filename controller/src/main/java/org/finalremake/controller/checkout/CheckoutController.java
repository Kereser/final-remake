package org.finalremake.controller.checkout;

import org.finalremake.service.checkout.CheckoutServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {
    private CheckoutServiceImpl checkoutServiceImpl;

    public CheckoutController(CheckoutServiceImpl checkoutServiceImpl) {
        this.checkoutServiceImpl = checkoutServiceImpl;
    }
}
