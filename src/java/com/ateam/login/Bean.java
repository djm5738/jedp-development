/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.login;
import com.ateam.hibernate.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author agray
 */
public class Bean implements Serializable {

	String userName;
	String pwd;
	String confPwd;
	String userFullName;
	String userRole;
	boolean exist=false;
				
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPwd(String pwd){
		this.pwd=pwd;
	}
	public void setConfPwd(String confPwd){
		this.confPwd=confPwd;
	}
	public void setUserFullName(String userFullName){
		this.userFullName=userFullName;
	}
	public void setUserRole(String userRole){
		this.userRole=userRole;
	}
	public void setExist(boolean exist){
		this.exist=exist;
	}


	public String getUserName(){
		return userName;
	}
	public String getPwd(){
		return pwd;
	}
	public String getConfPwd(){
		return confPwd;
	}
	public String getUserFullName(){
		return userFullName;
	}
	public String getUserRole(){
		return userRole;
	}
	public boolean getExist(){
		return exist;
	}
	


public String newUser() throws Exception {
    String status = "User Already Exists";
    if (validateData()) {  
		HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");

		if(dao.checkUser(getUserName())!=null){
			exist=true;
			status = "User Already Exists";
		}else{

			com.ateam.hibernate.UserAttr user = new com.ateam.hibernate.UserAttr();

			//Set user name
			user.setUserName(getUserName());


			//Set user Password
			user.setUserPassword(getPwd());

			//Set user Name
			user.setUserFullName(getUserFullName());

			//Set Address
			user.setUserRole(getUserRole());


			dao.addUser(user);
				status = "success";
		}
        

	}
    return status;
  }

public String deleteUser() throws Exception {
    String status = "User Does Not Exist";
    if (validateData()) {  
		HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");

			com.ateam.hibernate.UserDelete user = new com.ateam.hibernate.UserDelete();
			user.setUserName(getUserName());

			dao.deleteUser(getUserName());
				status = "success";      
	}
    return status;
  }

private boolean validateData() {
    boolean status = true;
    MessageFactory mf = new MessageFactory();
    FacesContext ctx = FacesContext.getCurrentInstance();

if((userName.length())<4   ){
	ctx.addMessage("registerForm:userName", 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, mf.getMessage("errorUserName"), null));
	      status = false;
	}

if((pwd.length())<4   ){
	ctx.addMessage("registerForm:Password", 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, mf.getMessage("errorPasswordLength"), null));
	      status = false;
	}

if((confPwd.length())<4   ){
	ctx.addMessage("registerForm:confirmPassword", 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, mf.getMessage("errorPasswordLength"), null));
	      status = false;
	}

    if (!confPwd.equals(pwd)) {
      ctx.addMessage("registerForm:confirmPassword", 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, mf.getMessage("errorPasswordConfirm"), null));
	      status = false;
	}


    return status;
  }
		
}