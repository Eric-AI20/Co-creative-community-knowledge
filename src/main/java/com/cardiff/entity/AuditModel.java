package com.cardiff.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuditModel {

    @Column(name = "created_timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime createTimestamp;

    @Column(name = "updated_timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedTimestamp;

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(LocalDateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}

