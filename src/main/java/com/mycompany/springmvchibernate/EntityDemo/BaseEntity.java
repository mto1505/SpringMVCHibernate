/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.EntityDemo;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author MinhTo
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Column(name = "createDate")
    @CreatedDate
    private Date createDate;
    @Column(name = "modifiedDate")
    @LastModifiedDate
    private Date modifiedDate;

    public BaseEntity() {
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    @Column(name = "createBy")
    @CreatedBy
    private String createBy;
    @Column(name = "modifiedBy")
    @LastModifiedBy
    private Date modifiedBy;
}
