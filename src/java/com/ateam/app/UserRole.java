/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;

/**
 *
 * @author Andrew
 */
public class UserRole {
    private String nameNew;
    private String commentsNew;
    
    public UserRole(String name, String comments){
        nameNew = name;
        commentsNew = comments;
    }
    public String getName(){
        return nameNew;
    }
    public String getComments(){
        return commentsNew;
    }
    public String toString(){
        return "Role name" + getName() + " comments " + getComments();
    }
}
