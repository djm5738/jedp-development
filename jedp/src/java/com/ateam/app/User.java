/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;
import java.util.*;
/**
 *
 * @author Andrew
 */
public class User {
    public static final String ADMIN_USER_ROLE = "admin";
    public static final String INTERVIEWER_USER_ROLE = "interviewer";
    
    private String userNameNew;
    private Set rolesNew;
    


public User(String userName, Set roles){
userNameNew = userName;
rolesNew = new HashSet(roles);
}

public String getUserName(){
return userNameNew;
}

public void setUserName(String userName){
    userNameNew = userName;
}

public Set getRoles(){
    return Collections.unmodifiableSet(rolesNew);
}

public void addRole(String role){
    rolesNew.add(role);
}
public void removeRole(String role){
    rolesNew.remove(role);
}
public boolean isInterviewerUser(){
    return getRoles().contains(INTERVIEWER_USER_ROLE);
}
public boolean isAdminUser(){
    return getRoles().contains(ADMIN_USER_ROLE);
}

public String toString(){
    StringBuffer buff = new StringBuffer();
    buff.append("user name " + getUserName() + " ");
    for (Iterator it = getRoles().iterator(); it.hasNext();){
        buff.append((String)it.next() + " ");
    }
    return buff.toString();
}
}
