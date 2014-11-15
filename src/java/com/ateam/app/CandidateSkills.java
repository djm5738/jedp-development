package com.ateam.app;

import com.ateam.hibernate.HibernateDAO;
import com.ateam.login.ServiceFinder;
import java.io.Serializable;

/**
 *
 * @author Ryan McGill
 */
public class CandidateSkills implements Serializable {

    private Integer candidateId;
    private String skillId;

    public CandidateSkills() {
    }

    public CandidateSkills(Integer candidateId, String skillId) {
        this.candidateId = candidateId;
        this.skillId = skillId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public void unsetFields() {
        this.setCandidateId(null);
        this.setSkillId(null);
    }

    public String addCandidateSkills() throws Exception {
        String status = "success";
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");

        com.ateam.app.CandidateSkills candidateSkills = new com.ateam.app.CandidateSkills(candidateId, skillId);
        dao.addCandidateSkills(candidateSkills);
        
        this.unsetFields();
        
        status = "success";
        
        return status;
    }
}