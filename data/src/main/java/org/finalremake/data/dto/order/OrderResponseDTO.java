package org.finalremake.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;
import org.finalremake.data.dto.delivery.DeliveryResponseDTO;

import java.util.Map;

@SuperBuilder
@Getter
@Setter
public class OrderResponseDTO extends AbstractDTO {
    private DeliveryResponseDTO delivery;
    private Map<Long, Integer> productQuantity;
    private Boolean status;
}
