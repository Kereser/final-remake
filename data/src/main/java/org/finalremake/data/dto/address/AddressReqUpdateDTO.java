package org.finalremake.data.dto.address;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddressReqUpdateDTO {
    @NotNull String direction;
    @Nullable String country;
    @Nullable String city;
}
