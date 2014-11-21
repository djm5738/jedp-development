package com.ateam.app;

import com.ateam.hibernate.HibernateDAO;
import com.ateam.login.ServiceFinder;
import java.io.Serializable;

/**
 *
 * @author Ryan McGill
 */
public class Interviews implements Serializable {

    private Integer interviewId;
    private String interviewDate;
    private String decision;
    private String decisionDate;
    private Integer candidateId;
    private String userName;
    private Integer userId;

    public Interviews() {
    }

    public Interviews(Integer candidateId) throws Exception {
        this.interviewDate="0000-00-00 00:00:00";
        this.candidateId=candidateId;
        //getInterviewerID();
        this.userId=1;
    }

    public Interviews(String interviewDate, String decision, String decisionDate, Integer candidateId, Integer userId) {
        this.interviewDate=interviewDate;
        this.decision=decision;
        this.decisionDate=decisionDate;
        this.candidateId=candidateId;
        this.userId=userId;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(String decisionDate) {
        this.decisionDate = decisionDate;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public void unsetFields() {
        this.candidateId=null;
        this.decision=null;
        this.decisionDate=null;
        this.interviewDate=null;
        this.interviewId=null;
        this.userId=null;
    }
    
    public void getInterviewerID() throws Exception {
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        userId = dao.getUserID(getUserName());
    }
}