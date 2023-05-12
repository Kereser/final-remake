package org.finalremake.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@SuperBuilder
@Getter
@Setter
public abstract class AbstractDTO {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
}
