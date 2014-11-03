/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;
import java.io.Serializable;

/**
 *
 * @author agray
 */
public class Questions implements Serializable {
    private Integer skillId;
    private Integer questionId;
    private String questionText;
    private String difficulty;
    private String exTime;
    private String exAnswer;

    public Questions(Integer skillId, Integer questionID, String questionText, String difficulty, String exTime, String exAnswer) {
        this.skillId = skillId;
        this.questionId = questionID;
        this.questionText = questionText;
        this.difficulty = difficulty;
        this.exTime = exTime;
        this.exAnswer = exAnswer;
    }

    public Questions () {
    }

    public Questions(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Integer skillId) {
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

}