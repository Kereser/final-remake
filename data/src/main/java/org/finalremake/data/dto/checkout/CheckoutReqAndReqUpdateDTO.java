package org.finalremake.data.dto.checkout;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class CheckoutReqAndReqUpdateDTO {
    @NotNull Map<Long, Integer> productQuantity;
}
