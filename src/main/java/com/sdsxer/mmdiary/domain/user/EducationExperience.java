package com.sdsxer.mmdiary.domain.user;

import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.domain.common.School;
import com.sdsxer.mmdiary.domain.base.IdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EducationExperience extends IdEntity {

    @ManyToOne
    private School school;
    private int admissionYear;
    @ManyToOne
    private User user;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
