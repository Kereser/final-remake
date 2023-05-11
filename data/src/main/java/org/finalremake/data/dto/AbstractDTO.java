package org.finalremake.data.dto;

import java.time.Instant;

public abstract class AbstractDTO {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
}
