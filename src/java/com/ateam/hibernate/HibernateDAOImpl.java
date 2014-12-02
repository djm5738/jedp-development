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

    public String checkFullName(String strUserName, String password) throws DataAccessException, java.sql.SQLException {
        String obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.groupProperty("userFullName"));
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

    public void deleteUser(String userFullName) throws DataAccessException, java.sql.SQLException {

        DetachedCriteria interviewCriteria = DetachedCriteria.forClass(Interviews.class);
        interviewCriteria.add(Restrictions.eq("userId", getUserID(getUserName(userFullName))));
        List objs = getHibernateTemplate().findByCriteria(interviewCriteria);
        for (Object interview : objs) {
            getHibernateTemplate().delete(interview);
        }

        DetachedCriteria userCriteria = DetachedCriteria.forClass(UserAttr.class);
        userCriteria.add(Restrictions.eq("userName", getUserName(userFullName)));
        objs = getHibernateTemplate().findByCriteria(userCriteria);
        getHibernateTemplate().delete(objs.get(0));

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
    
    public String getUserName(String userFullName) throws DataAccessException, java.sql.SQLException {
        String obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.add(Restrictions.eq("userFullName", userFullName));
        criteria.setProjection(Projections.property("userName"));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (String) objs.get(0);
        }

        return obj;
    }

    public List<UserAttr> listUsers() throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAttr.class);
        criteria.setProjection(Projections.property("userFullName"));
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

    public List<Candidates> listCandidates() throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(Candidates.class);
        criteria.setProjection(Projections.property("candidateName"));
        List objs = getHibernateTemplate().findByCriteria(criteria);

        return objs;
    }

    public List<Candidates> listCandidatesOfInterviewer(Integer userId) throws DataAccessException, java.sql.SQLException {
        DetachedCriteria interviewCriteria = DetachedCriteria.forClass(Interviews.class);

        interviewCriteria.setProjection(Projections.property("candidateId"));
        interviewCriteria.add(Restrictions.eq("userId", userId));

        List objs = getHibernateTemplate().findByCriteria(interviewCriteria);

        List candidateNames = new ArrayList();

        for (Object obj : objs) {
            DetachedCriteria candidateCriteria = DetachedCriteria.forClass(Candidates.class);
            candidateCriteria.setProjection(Projections.property("candidateName"));
            candidateCriteria.add(Restrictions.eq("candidateId", obj));

            List name = getHibernateTemplate().findByCriteria(candidateCriteria);

            String candidateName = (String) name.get(0);

            candidateNames.add(candidateName);
        }

        return candidateNames;
    }

    public List<Candidates> listCandidateSkills(Integer candidateId) throws DataAccessException, java.sql.SQLException {
        DetachedCriteria criteria = DetachedCriteria.forClass(CandidateSkills.class);
        criteria.setProjection(Projections.property("skillId"));
        criteria.add(Restrictions.eq("candidateId", candidateId));
        List objs = getHibernateTemplate().findByCriteria(criteria);

        return objs;
    }

    public Integer getCandidateID(String candidateName) throws DataAccessException, java.sql.SQLException {
        Integer obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(Candidates.class);
        criteria.add(Restrictions.eq("candidateName", candidateName));
        criteria.setProjection(Projections.property("candidateId"));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (Integer) objs.get(0);
        }

        return obj;
    }

    public void addInterview(com.ateam.app.Interviews obj) throws DataAccessException {
        getHibernateTemplate().save(obj);
    }

    public Integer getInterviewID(String userName, String candidateName) throws DataAccessException, java.sql.SQLException {
        Integer userId = getUserID(userName);
        Integer candidateId = getCandidateID(candidateName);
        Integer obj = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(Interviews.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("candidateId", candidateId));
        criteria.setProjection(Projections.property("interviewId"));
        List objs = getHibernateTemplate().findByCriteria(criteria);
        if ((objs != null) && (objs.size() > 0)) {
            obj = (Integer) objs.get(0);
        }

        return obj;
    }
}
