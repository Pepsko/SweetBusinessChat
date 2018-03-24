package com.pszypau.SweetBusinessChat.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity
@Table(name = "USERSTABLE")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //@NotBlank
  //  private String uuid = UUID.randomUUID().toString();
    @NotBlank
    private String name;
   // @Email
   // @NotBlank
   // private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String role;

    public UserEntity( String uuid,  String name,   String email,  String password, String role) {
      //  this.uuid = uuid;
        this.name = name;
       // this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserEntity(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public UserEntity() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   // public String getUuid() {
   //     return uuid;
   // }

   // public void setUuid(String uuid) {
  //      this.uuid = uuid;
   // }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public String getEmail() {
   //     return email;
   // }

   // public void setEmail(String email) {
  //     this.email = email;
   // }

    public void setPassword(String password) {
        this.password = password;
    }

}