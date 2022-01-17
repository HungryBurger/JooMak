package com.joomak.backend.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime sysRegAt;

    @LastModifiedDate
    private LocalDateTime sysUpdAt;

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String updater;

}
