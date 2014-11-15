/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;
import java.io.Serializable;

/**
 *
 * @author agray
 */
public class UserAttr implements Serializable {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userFullName;
    private String userRole;

    public UserAttr() {
    }

    public UserAttr(Integer userId) {
        this.userId = userId;
    }
    public UserAttr(String userName, String userPassword, String userFullName, String userRole) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userRole = userRole;
    }
    
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFullName() {
        return this.userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
