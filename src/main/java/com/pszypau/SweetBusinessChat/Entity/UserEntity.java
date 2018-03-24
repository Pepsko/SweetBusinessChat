package com.pszypau.SweetBusinessChat.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "USERSTABLE")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String uuid = UUID.randomUUID().toString();
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public UserEntity( String uuid,  String name,  String surname,   String email,  String password) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}