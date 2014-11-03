/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;
import java.util.*;
import java.sql.*;
import com.ateam.app.*;
/**
 *
 * @author Andrew
 */
public class UserDAOMySQL {
    public UserDAOMySQL(){
        
    }
        public User getUser (String userID){
            String query = "SELECT Users.USER_NAME " + "FROM Users " + "WHERE Users.USER_ID = " + userID;
            Connection conn = null;
            Statement statement = null;
            ResultSet rs = null;
            try{
                String userName = null;
                
            }
            catch(Exception DAOException){
               String userName; 
            }
            return null;
                    }    
    
}
