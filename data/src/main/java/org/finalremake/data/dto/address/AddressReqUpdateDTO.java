package org.finalremake.data.dto.address;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressReqUpdateDTO {
    @NotNull String direction;
    @Nullable String country;
    @Nullable String city;
}
