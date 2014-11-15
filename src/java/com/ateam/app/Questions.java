package com.ateam.app;

import com.ateam.hibernate.HibernateDAO;
import com.ateam.login.ServiceFinder;
import java.io.Serializable;

/**
 *
 * @author agray
 */
public class Questions implements Serializable {

    private Integer questionId;
    private String questionText;
    private String difficulty;
    private String exTime;
    private String exAnswer;
    private String questionType;
    private String businessUnit;
    private String skillId;

    public Questions() {
    }

    public Questions(String skillId) {
        this.skillId = skillId;
    }

    public Questions(String questionText, String difficulty, String exTime, String exAnswer, String questionType, String businessUnit, String skillId) {
        this.questionText = questionText;
        this.difficulty = difficulty;
        this.exTime = exTime;
        this.exAnswer = exAnswer;
        this.questionType = questionType;
        this.businessUnit = businessUnit;
        this.skillId = skillId;
    }

    public String getSkillId() {
        return this.skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public Integer getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getquestionText() {
        return this.questionText;
    }

    public void setquestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getexTime() {
        return this.exTime;
    }

    public void setexTime(String exTime) {
        this.exTime = exTime;
    }

    public String getexAnswer() {
        return this.exAnswer;
    }

    public void setexAnswer(String exAnswer) {
        this.exAnswer = exAnswer;
    }

    public String getquestionType() {
        return this.questionType;
    }

    public void setquestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getbusinessUnit() {
        return this.businessUnit;
    }

    public void setbusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    
    public void unsetFields() {
        this.skillId = null;
        this.questionId = null;
        this.questionText = null;
        this.difficulty = null;
        this.exTime = null;
        this.exAnswer = null;
        this.questionType = null;
        this.businessUnit = null;
    }
    
    public String addQuestion() throws Exception {
        String status = "success";
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");

        com.ateam.app.Questions question = new com.ateam.app.Questions(questionText, difficulty, exTime, exAnswer, questionType, businessUnit, skillId);
        dao.addQuestion(question);
        
        this.unsetFields();
        
        status = "success";
        
        return status;
    }
}
