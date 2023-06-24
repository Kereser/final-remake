package org.finalremake.controller.checkout;

import jakarta.validation.Valid;
import org.finalremake.data.dto.checkout.CheckoutReqAndReqUpdateDTO;
import org.finalremake.data.dto.checkout.CheckoutResponseDTO;
import org.finalremake.service.checkout.CheckoutServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {
    private CheckoutServiceImpl checkoutServiceImpl;

    public CheckoutController(CheckoutServiceImpl checkoutServiceImpl) {
        this.checkoutServiceImpl = checkoutServiceImpl;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public CheckoutResponseDTO getCheckout(@PathVariable Long id) {
        return checkoutServiceImpl.getCheckout(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CheckoutResponseDTO createCheckout(@RequestParam Map<String, Long> params, @RequestBody @Valid CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO) {
        return checkoutServiceImpl.createCheckout(params, checkoutReqAndReqUpdateDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckoutResponseDTO updateCheckout(@PathVariable Long id, @RequestParam Map<String, Long> params, @RequestBody @Valid CheckoutReqAndReqUpdateDTO checkoutReqAndReqUpdateDTO) {
        return checkoutServiceImpl.updateCheckout(id, params, checkoutReqAndReqUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCheckout(@PathVariable Long id) {
        checkoutServiceImpl.deleteCheckout(id);
    }
}
