package org.finalremake.data.dto.customer;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerReqUpdateDTO {
    @Nullable private String name;
    @Nullable @Size(min = 3, max =18) private String surname;
    @Email @NotNull private String email;
    @Nullable private String phone;
    @Nullable private Integer age;
}
