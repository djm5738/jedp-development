/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;

import com.ateam.app.*;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateOperations;
import javax.persistence.EntityManager;
import org.hibernate.criterion.*;
import org.hibernate.*;
import java.sql.*;

import javax.servlet.http.HttpSession;

/**
 *
 * @author agray
 */
public class HibernateDAOImpl extends HibernateDaoSupport implements HibernateDAO {

    Questions obj2 = null;

    public UserAttr checkUser(String strUserName) throws DataAccessException, java.sql.SQLException {
        UserAttr obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.add(Restrictions.eq("userName", strUserName));

        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (UserAttr) objs.get(0);
        }
        return obj;
    }

    public UserAttr validateUser(String strUserName, String password) throws DataAccessException, java.sql.SQLException {
        UserAttr obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.add(Restrictions.eq("userName", strUserName));
        criteria.add(Restrictions.eq("userPassword", password));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (UserAttr) objs.get(0);
        }
        return obj;
    }

    public String checkRole(String strUserName, String password) throws DataAccessException, java.sql.SQLException {
        String obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.groupProperty("userRole"));
        criteria.add(Restrictions.eq("userName", strUserName));
        criteria.add(Restrictions.eq("userPassword", password));
        criteria.setProjection(pl);
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (String) objs.get(0);
        }
        return obj;
    }

    public List<Questions> generateQuestion(String skillId, String difficulty) throws DataAccessException, java.sql.SQLException {
        Questions obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(Questions.class);
        criteria.add(Restrictions.eq("skillId", skillId));
        criteria.add(Restrictions.eq("difficulty", difficulty));
        criteria.add(Restrictions.sqlRestriction("1=1 order by rand() LIMIT 1"));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (Questions) objs.get(0);
        }
        return objs;
    }
    
    public List<Questionnaire> generateScorecard(Integer interviewId) throws DataAccessException, java.sql.SQLException {
        Questionnaire obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(Questionnaire.class);
        criteria.add(Restrictions.eq("interviewId", interviewId));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (Questionnaire) objs.get(0);
        }
        return objs;
    }

    public void addUser(com.ateam.hibernate.UserAttr obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }

    public void deleteUser(String userName) throws DataAccessException {
        UserAttr obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.add(Restrictions.eq("userName", userName));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (UserAttr) objs.get(0);
            getHibernateTemplate().delete(obj);
        }

    }
    
    public Integer getUserID(String userName) throws DataAccessException, java.sql.SQLException {
        Integer obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.setProjection(Projections.property("userId"));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (Integer) objs.get(0);
        }
        
        return obj;
    }
    
    public List<UserAttr> listUsers() throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.setProjection(Projections.property("userName"));
        List objs = getHibernateTemplate().findByCriteria(criteria);

        return objs;
    }

    public void addSkill(com.ateam.app.Skills obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }

    public List<Skills> listSkills() throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(Skills.class);
        criteria.setProjection(Projections.property("skillId"));
        List objs = getHibernateTemplate().findByCriteria(criteria);

        return objs;
    }
    
    public List<Questions> listSkillsq() throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(Questions.class);
        criteria.setProjection(Projections.distinct(Projections.property("skillId")));
        List objs = getHibernateTemplate().findByCriteria(criteria);
            return objs;
	}
    
    public List<Questionnaire> listInterviewId() throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(Questionnaire.class);
        criteria.setProjection(Projections.distinct(Projections.property("interviewId")));
        List objs = getHibernateTemplate().findByCriteria(criteria);
            return objs;
	}
    
    public void addFeedback(com.ateam.app.Questionnaire obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }
    public void addQuestion(com.ateam.app.Questions obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }

    public void addCandidate(com.ateam.app.Candidates obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }

    public void addCandidateSkills(com.ateam.app.CandidateSkills obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }
    
    public void addInterview(com.ateam.app.Interviews obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }
}
