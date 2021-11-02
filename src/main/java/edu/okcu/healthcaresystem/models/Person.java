package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name="userID")
    private Long userID;

    @Column(name="fName")
    private String fName;

    @Column(name="lname")
    private String lname;

   @Column(name="phoneNumber")
    private long phoneNumber;

    @Column(name="address")
    private String address;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lname;
    }

    public void setlname(String lName) {
        this.lname = lname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String toString(Doctor doctor){
        String text = "userID: " + doctor.getUserID() + " email: " + doctor.getEmail() + " fName: " + doctor.getfName() + " mName: " + doctor.getmName()
                + " lName: " + doctor.getlName() + " DOB: " + doctor.getDOB() + " gender: " + doctor.getGender();
        return text;
    }
}