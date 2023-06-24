package org.finalremake.data.dto.checkout;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutReqAndReqUpdateDTO {
    @NotNull Map<Long, Integer> productQuantity;
}
