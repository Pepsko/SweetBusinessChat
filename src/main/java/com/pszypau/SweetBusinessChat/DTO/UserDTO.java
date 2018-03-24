package com.pszypau.SweetBusinessChat.DTO;

/**
 * Created by Lenovo on 2018-03-24.
 */
public class UserDTO {
    private Integer id;
    private String uuid;
    private String name;
    private String email;
    private String password;

    public UserDTO(Integer id, String uuid,String name,  String email, String password) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
