package com.ateam.app;

import com.ateam.hibernate.HibernateDAO;
import com.ateam.login.ServiceFinder;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ryan McGill
 */
public class CandidateSkills implements Serializable {

    private Integer candidateId;
    private String skillId;
    private List skillList;

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

    public List getSkillList() {
        return skillList;
    }

    public void setSkillList(List skillList) {
        this.skillList = skillList;
    }

    public void unsetFields() {
        this.setCandidateId(null);
        this.setSkillId(null);
        this.setSkillList(null);
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

    public void listCandidateSkills(String candidateName) throws Exception {
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        candidateId = dao.getCandidateID(candidateName);
        skillList = dao.listCandidateSkills(candidateId);
    }
}
