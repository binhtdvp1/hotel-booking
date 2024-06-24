package com.hrs.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @PrePersist
    private void createdAt() {
        this.createdDate = this.updatedDate = new Date();
    }

    @PreUpdate
    private void updatedAt() {
        updatedDate = new Date();
    }
}
