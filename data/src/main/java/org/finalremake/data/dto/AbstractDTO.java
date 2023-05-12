package org.finalremake.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class AbstractDTO {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
}
