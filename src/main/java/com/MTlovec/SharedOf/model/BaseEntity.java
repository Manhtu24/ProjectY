package com.MTlovec.SharedOf.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@ToString
public class BaseEntity {

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    protected  LocalDateTime updatedAt;

}
