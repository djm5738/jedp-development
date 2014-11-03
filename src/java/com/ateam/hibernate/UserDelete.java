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
public class UserDelete implements Serializable {
    private String userName;
    public UserDelete(String userName) {
        this.userName = userName;
    }
        public UserDelete() {
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    }
