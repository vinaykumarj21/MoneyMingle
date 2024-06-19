package com.project.Splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseClass {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)//Id Auto Generated
    private int id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date CreatedAt;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date LastModifiedAt;

}
