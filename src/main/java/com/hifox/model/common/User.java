package com.hifox.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lihao on 2016/6/30.
 */
@Entity
public class User extends Model {

    public enum Role{
        Admin,
        User
    }

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Column(unique = true)
    private String userName;

    private String passWord;

    private String email;

    private String phone;

    private Role role;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
