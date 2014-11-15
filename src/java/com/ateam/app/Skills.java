package com.ateam.app;

import com.ateam.hibernate.HibernateDAO;
import com.ateam.login.ServiceFinder;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ryan McGill
 */
public class Skills implements Serializable {

    private String skillId;
    private String skillDesc;
    private String newSkill;

    public Skills() {
    }

    public Skills(String skillId) {
        this.skillId = skillId;
    }

    public Skills(String skillId, String skillDesc) {
        this.skillId = skillId;
        this.skillDesc = skillDesc;
    }

    public String getSkillId() {
        return this.skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillDesc() {
        return this.skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }
    
    public void setNewSkill(String newSkill) {
        this.newSkill = newSkill;
    }
    
    public String getNewSkill() {
        return this.newSkill;
    }
       
    public void unsetFields() {
        this.setSkillId(null);
        this.setSkillDesc(null);
        this.setNewSkill(null);
    }

    public String addSkill() throws Exception {
        String status = "success";
        HibernateDAO dao = (HibernateDAO) ServiceFinder.findBean("SpringHibernateDao");

        com.ateam.app.Skills skill = new com.ateam.app.Skills(newSkill);
        dao.addSkill(skill);
        
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
