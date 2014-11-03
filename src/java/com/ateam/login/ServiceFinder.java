/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.login;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.servlet.ServletContext;
 import org.springframework.context.ApplicationContext; 
 import org.springframework.web.context.support.WebApplicationContextUtils; 
 import java.util.Map; 
 import javax.servlet.ServletRequest; 
 import javax.servlet.http.HttpServletRequest; 
/**
 *
 * @author agray
 */

 public class ServiceFinder { 


	public static Object findBean(String beanName){
		FacesContext context= FacesContext.getCurrentInstance();

		ServletContext servletContext = 
		    (ServletContext)context.getExternalContext().getContext();
		ApplicationContext appContext =
		    WebApplicationContextUtils.getWebApplicationContext(servletContext);

		Object o = appContext.getBean(beanName);

		return o;

	}

 } 
