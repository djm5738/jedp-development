package com.ateam.app;

import com.ateam.hibernate.HibernateDAO;
import com.ateam.login.ServiceFinder;
import java.io.Serializable;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ryan McGill
 */
public class Candidates implements Serializable {

    private Integer candidateId;
    private String candidateName;
    private Blob candidateResume;
    private String submitDateResume;
    private String availability;
    private List<String> skillId;

    public Candidates() {
    }

    public Candidates(String candidateName) {
        this.candidateName = candidateName;
        this.submitDateResume = "0000-00-00 00:00:00";
    }

    public Candidates(String candidateName, Blob candidateResume, String submitDateResume, String availability, List<String> skillId) {
        this.candidateName = candidateName;
        this.candidateResume = candidateResume;
        this.submitDateResume = "0000-00-00 00:00:00";
        this.skillId = skillId;
        this.availability = availability;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Blob getCandidateResume() {
        return candidateResume;
    }

    public void setCandidateResume(Blob candidateResume) {
        this.candidateResume = candidateResume;
    }

    public String getSubmitDateResume() {
        return submitDateResume;
    }

    public void setSubmitDateResume(String submitDateResume) {
        this.submitDateResume = submitDateResume;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public List<String> getSkillId() {
        return skillId;
    }

    public void setSkillId(List<String> skillId) {
        this.skillId = skillId;
    }

    public void unsetFields() {
        this.setCandidateName(null);
        this.setCandidateResume(null);
        this.setSubmitDateResume(null);
        this.setAvailability(null);
        this.setSkillId(null);
    }

    public String addCandidate() throws Exception {
        String status = "success";
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");

        com.ateam.app.Candidates candidate = new com.ateam.app.Candidates(candidateName);
        dao.addCandidate(candidate);

        for (String skill : skillId) {
            com.ateam.app.CandidateSkills candidateSkill = new com.ateam.app.CandidateSkills(candidate.candidateId, skill);
            dao.addCandidateSkills(candidateSkill);
        }

        this.unsetFields();

        status = "success";

        return status;
    }

    public List listSkills() throws Exception {
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");
        List skills = dao.listSkills();
        return skills;
    }
}
