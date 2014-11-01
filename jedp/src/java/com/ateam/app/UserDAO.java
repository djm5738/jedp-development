/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;
import java.util.Set;
import java.util.List;
import com.ateam.hibernate.*;
/**
 *
 * @author Andrew
 */
public interface UserDAO {
    public User getUser(String userID) throws DAOException;
    public void removeUser(String userID) throws DAOException;
    public void addUser(User user) throws DAOException;
    public void updateUser(User user) throws DAOException;
    public List getUsers() throws DAOException;
    public void removeRole(String roleName) throws DAOException;
    public void addRole(UserRole role) throws DAOException;
    public Set getRolesNames() throws DAOException;
    
    
}
