/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.login;
import com.ateam.hibernate.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author agray
 */

public class BeanTwo {
    
	String userName;
	String password;
			
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPwd(String pwd){
		this.password=pwd;
	}
	

	public String getUserName(){
		return userName;
	}
	public String getPwd(){
		return password;
	}
	
public String checkUser() throws Exception {
    String status = "User doesn't exist";
    
		HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("HibernateDao");

		if(dao.validateUser(getUserName(),getPwd())!=null){
			System.out.println("User exists!");
			status = "User Access successful";
		}
    return status;
  		
}
}