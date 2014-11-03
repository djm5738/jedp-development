/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.login;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author agray
 */
public class MessageFactory {
	ResourceBundle bundle;
	Locale locale;
	
	public MessageFactory() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	bundle = ResourceBundle.getBundle("com.ateam.login.messages", locale);
	}
	
	public String getMessage(String key) {
		return bundle.getString(key);
	}
	
}
