package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name="userid")
    private Long userID;

    @Column(name="DOB")
    private String DOB;

    @Column(name="fname")
    private String fName;

    @Column(name="mname")
    private String mName;

    @Column(name="lname")
    private String lName;

    @Column(name="gender")
    private String gender;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getDOB() { return DOB; }

    public void setDOB(String DOB) { this.DOB = DOB; }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(Doctor doctor){
        String text = "userID: " + doctor.getUserID() + " email: " + doctor.getEmail() + " fName: " + doctor.getfName() + " mName: " + doctor.getmName()
                + " lName: " + doctor.getlName() + " DOB: " + doctor.getDOB() + " gender: " + doctor.getGender();
        return text;
    }
}