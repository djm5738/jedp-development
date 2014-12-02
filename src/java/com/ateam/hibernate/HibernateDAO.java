/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;

import com.ateam.login.*;
import com.ateam.app.*;
import java.util.*;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author agray
 */
public interface HibernateDAO {

    public UserAttr checkUser(String strUserName) throws DataAccessException, java.sql.SQLException;

    public UserAttr validateUser(String strUserName, String password) throws DataAccessException, java.sql.SQLException;

    public String checkRole(String strUserName, String password) throws DataAccessException, java.sql.SQLException;

    public String checkFullName(String strUserName, String password) throws DataAccessException, java.sql.SQLException;

    public List<Questions> generateQuestion(String skillId, String difficulty) throws DataAccessException, java.sql.SQLException;

    public List<Questionnaire> generateScorecard(Integer interviewId) throws DataAccessException, java.sql.SQLException;

    public Integer getUserID(String userName) throws DataAccessException, java.sql.SQLException;
    
    public String getUserName(String userFullName) throws DataAccessException, java.sql.SQLException;

    public List<UserAttr> listUsers() throws DataAccessException, java.sql.SQLException;

    public void addUser(com.ateam.hibernate.UserAttr obj) throws DataAccessException;

    public void deleteUser(String userFullName) throws DataAccessException, java.sql.SQLException;

    public void addSkill(com.ateam.app.Skills obj) throws DataAccessException;

    public List<Skills> listSkills() throws DataAccessException, java.sql.SQLException;

    public List<Questions> listSkillsq() throws DataAccessException, java.sql.SQLException;

    public List<Questionnaire> listInterviewId() throws DataAccessException, java.sql.SQLException;

    public void addFeedback(com.ateam.app.Questionnaire obj) throws DataAccessException;

    public void addQuestion(com.ateam.app.Questions obj) throws DataAccessException;

    public void addCandidate(com.ateam.app.Candidates obj) throws DataAccessException;

    public void addCandidateSkills(com.ateam.app.CandidateSkills obj) throws DataAccessException;

    public List<Candidates> listCandidates() throws DataAccessException, java.sql.SQLException;
    
    public List<Candidates> listCandidatesOfInterviewer(Integer userId) throws DataAccessException, java.sql.SQLException;
    
    public List<Candidates> listCandidateSkills(Integer candidateId) throws DataAccessException, java.sql.SQLException;
    
    public Integer getCandidateID(String candidateName) throws DataAccessException, java.sql.SQLException;

    public void addInterview(com.ateam.app.Interviews obj) throws DataAccessException;
    
    public Integer getInterviewID(String userName, String candidateName) throws DataAccessException, java.sql.SQLException;
}
