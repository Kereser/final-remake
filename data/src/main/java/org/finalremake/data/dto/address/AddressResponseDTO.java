package org.finalremake.data.dto.address;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.finalremake.data.dto.AbstractDTO;

@SuperBuilder
@Getter
@Setter
public class AddressResponseDTO extends AbstractDTO {
    private String direction;
    private String city;
    private String country;
}
