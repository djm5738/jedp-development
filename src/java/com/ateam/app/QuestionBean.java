/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;

import com.ateam.hibernate.*;
import com.ateam.login.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
@ManagedBean
@SessionScoped
public class QuestionBean implements Serializable {

    private String skillId;
    private String questionText;
    private String difficulty;
    private String exTime;
    private String exAnswer;
    private String questionType;
    private String businessUnit;
    private String feedback;
    private String feedbackStarter;
    private Integer questionId;
    private Integer interviewId;
    private List generatedQuestionList;
    private com.ateam.app.Questions generatedQuestion;
    private List generatedScorecardList;
    private com.ateam.app.Questionnaire generatedScorecard;
    private HibernateDAO dao;
    private com.ateam.app.Questions q;
    private String candidateName;

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setExTime(String exTime) {
        this.exTime = exTime;
    }

    public void setExAnswer(String exAnswer) {
        this.exAnswer = exAnswer;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setFeedbackStarter(String feedbackStarter) {
        this.feedbackStarter = feedbackStarter;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public String getSkillId() {
        return skillId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getExTime() {
        return exTime;
    }

    public String getExAnswer() {
        return exAnswer;
    }

    public String getquestionType() {
        return questionType;
    }

    public String getbusinessUnit() {
        return businessUnit;
    }

    public String getFeedback() {
        return feedback;
    }
    
    public String getFeedbackStarter() {
        return feedbackStarter;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void unsetFields() {
        this.skillId = null;
        this.difficulty = null;
        this.feedback = null;
        this.feedbackStarter = null;
        this.questionId = null;
        this.interviewId = null;
    }

    public void unsetAllFields() {
        this.skillId = null;
        this.questionText = null;
        this.difficulty = null;
        this.exTime = null;
        this.exAnswer = null;
        this.questionType = null;
        this.businessUnit = null;
        this.feedback = null;
        this.feedbackStarter = null;
        this.questionId = null;
        this.interviewId = null;
        this.generatedQuestion = null;
        this.generatedScorecard = null;
    }

    public String generateQuestion() throws Exception {
        String status;
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        q = new com.ateam.app.Questions();
        q.setSkillId(getSkillId());
        q.setDifficulty(getDifficulty());
        generatedQuestionList = dao.generateQuestion(getSkillId(), getDifficulty());
        generatedQuestion = (Questions) generatedQuestionList.get(0);
        this.unsetFields();
        status = "results";
        return status;
    }

    public String adminGenerateQuestion() throws Exception {
        String status;
        dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        q = new com.ateam.app.Questions();
        q.setSkillId(getSkillId());
        q.setDifficulty(getDifficulty());
        generatedQuestionList = dao.generateQuestion(getSkillId(), getDifficulty());
        generatedQuestion = (Questions) generatedQuestionList.get(0);
        this.unsetFields();
        status = "adminResults";
        return status;
    }

    public String adminGenerateScorecard() throws Exception {
        String status;
        dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        com.ateam.app.Questionnaire s = new com.ateam.app.Questionnaire();
        s.setInterviewId(getInterviewId());
        generatedScorecardList = dao.generateScorecard(getInterviewId());
        generatedScorecard = (Questionnaire) generatedScorecardList.get(0);
        status = "adminResultssc";
        return status;
    }

    public String generateScorecard() throws Exception {
        String status;
        dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        com.ateam.app.Questionnaire s = new com.ateam.app.Questionnaire();
        s.setInterviewId(getInterviewId());
        generatedScorecardList = dao.generateScorecard(getInterviewId());
        generatedScorecard = (Questionnaire) generatedScorecardList.get(0);
        status = "resultssc";
        return status;
    }

    public List scorecardReport() throws Exception {
        return generatedScorecardList;
    }

    public List questionList() throws Exception {
        return generatedQuestionList;
    }

    public void addQuestion() throws Exception {
        q.setSkillId(getSkillId());
        q.setDifficulty(getDifficulty());
        generatedQuestionList.add(dao.generateQuestion(getSkillId(), getDifficulty()));
    }

    public List listSkillsq() throws Exception {
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        com.ateam.app.Questions r = new com.ateam.app.Questions();
        List skills = dao.listSkillsq();
        return skills;
    }

    public List listInterviewId() throws Exception {
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        com.ateam.app.Questionnaire t = new com.ateam.app.Questionnaire();
        List interviewIds = dao.listInterviewId();
        return interviewIds;
    }

    public String addFeedback() throws Exception {
        String status;
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        com.ateam.app.Questionnaire s = new com.ateam.app.Questionnaire();
        s.setFeedback(getFeedbackStarter() + getFeedback());

        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        String userName = (String) session.getAttribute("username");

        s.setInterviewId(dao.getInterviewID(userName, this.getCandidateName()));
        s.setQuestionId(generatedQuestion.getQuestionId());
        dao.addFeedback(s);
        
        this.unsetAllFields();
        status = "success";
        return status;
    }
}
