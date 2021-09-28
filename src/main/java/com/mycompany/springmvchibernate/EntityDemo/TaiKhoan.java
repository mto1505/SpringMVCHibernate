/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.EntityDemo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 *
 * @author MinhTo
 */
@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoan implements Serializable {

    @Id
    @NotNull
    @Basic(optional = false)
    @GeneratedValue
    private Long id;
    
    @NotNull
    @Basic(optional = false)
    @Size(max=50)
    @Column(name = "username",length=50)
    private String userName;
    @NotNull
    @Basic(optional = false)
    @Size(max=50)
    @Column(name = "password",length=50)
    private String password;
    @NotNull
    @OneToOne
    @Basic(optional = false)
    @JoinColumn(nullable=false,name="idKhachHang",unique=true,referencedColumnName="id")
    private KhachHang khachHang;
   /* @Basic(optional = false)
    @NotNull
    @OneToOne
    @JoinColumn(nullable=false,name="idVaiTro",unique=true,referencedColumnName="id")
    private VaiTro vaiTro;*/

   /* @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = {
                @JoinColumn(name = "role_id")},
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "role_id"})})
    private List<Role> roles = new ArrayList<>();*/

   /* public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   
}
