package com.weather.region.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U>
        implements Serializable {

    @Column(name = "created_by")
    @CreatedBy
    @NotFound(action = NotFoundAction.IGNORE)
    private U createdBy;

    @Column(name = "created_when")
    @CreatedDate
    private Instant createdWhen;

    @Column(name = "modified_by")
    @LastModifiedBy
    @NotFound(action = NotFoundAction.IGNORE)
    private U modifyBy;

    @Column(name = "modified_when")
    @LastModifiedDate
    private Instant modifyWhen;

}