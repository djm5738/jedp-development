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
/**
 *
 * @author Andrew
 */
public class QuestionBean implements Serializable {
    Integer skillId;
    String questionText;
    String difficulty;
    String exTime;
    String exAnswer;
    List status2;
				
	public void setSkillId(Integer skillId){
		this.skillId=skillId;
	}
	public void setQuestionText(String questionText){
		this.questionText=questionText;
	}
	public void setDifficulty(String difficulty){
		this.difficulty=difficulty;
	}
	public void setExTime(String exTime){
		this.exTime=exTime;
	}
	public void setExAnswer(String exAnswer){
		this.exAnswer=exAnswer;
	}
        
	public Integer getSkillId(){
		return skillId;
	}
	public String getQuestionText(){
		return questionText;
	}
	public String getDifficulty(){
		return difficulty;
	}
	public String getExTime(){
		return exTime;
	}
	public String getExAnswer(){
		return exAnswer;
	}
        public String generateQuestion() throws Exception {
            String status = "placeholder";
            HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");
            com.ateam.app.Questions q = new com.ateam.app.Questions();
            q.setSkillId(getSkillId());
            q.setDifficulty(getDifficulty());
            status2 = dao.generateQuestion(getSkillId(),getDifficulty());
            status = "results";
            return status;
  }
        public List questionList() throws Exception{
            return status2;
        }
}
