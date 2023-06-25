package org.finalremake.data.dto.customer;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReqDTO {
    @NotNull private String name;
    @NotNull @Size(min = 3, max =18) private String surname;
    @Email private String email;
    @Nullable private String phone;
    @Nullable private Integer age;
}
