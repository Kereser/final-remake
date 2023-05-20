package org.finalremake.data.dto.checkout;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class CheckoutReqDTO {
    @NotNull Long customerId;
    @NotNull Map<Long, Integer> productQuantity;
}
