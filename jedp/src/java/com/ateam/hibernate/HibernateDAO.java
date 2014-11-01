/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;
import com.ateam.login.*;
import java.util.*;
import org.springframework.dao.DataAccessException;
/**
 *
 * @author agray
 */
public interface HibernateDAO {
   	public UserAttr checkUser(String strUserName) throws DataAccessException,java.sql.SQLException;
	public UserAttr validateUser(String strUserName,String password) throws DataAccessException,java.sql.SQLException;
	public void addUser(com.ateam.hibernate.UserAttr obj) throws DataAccessException; 
}
