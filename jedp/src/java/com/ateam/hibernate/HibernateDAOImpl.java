/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.hibernate.criterion.*;
import java.sql.*;

import javax.servlet.http.HttpSession;

/**
 *
 * @author agray
 */
public class HibernateDAOImpl extends HibernateDaoSupport implements HibernateDAO {

	public UserAttr checkUser(String strUserName)
			throws DataAccessException, java.sql.SQLException {
		UserAttr obj = null;
		DetachedCriteria critone = DetachedCriteria.forClass(UserAttr.class);
		critone.add(Expression.eq("userName", strUserName));

		List objs = getHibernateTemplate().findByCriteria(critone);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (UserAttr) objs.get(0);
		}
		return obj;
	}	

	public UserAttr validateUser(String strUserName,String password) 
			throws DataAccessException, java.sql.SQLException {
		UserAttr obj = null;
		DetachedCriteria crittwo = DetachedCriteria.forClass(UserAttr.class);
		crittwo.add(Expression.eq("userName", strUserName));
		crittwo.add(Expression.eq("userPassword", password));
		List objs = getHibernateTemplate().findByCriteria(crittwo);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (UserAttr) objs.get(0);
		}
		return obj;
	}	


	public void addUser(com.ateam.hibernate.UserAttr obj)
			throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
}