package org.finalremake.data.dto.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.finalremake.data.dto.AbstractDTO;

@Builder
@Getter
@Setter
public class AddressResponseDTO extends AbstractDTO {
    private String direction;
    private String city;
    private String country;
}
