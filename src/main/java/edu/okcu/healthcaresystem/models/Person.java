package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "person")
public class Person {
    @Id
    @Column(name="userid")
    private Long userID;

    @Column(name="fname")
    private String fName;

    @Column(name="lname")
    private String lName;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="address")
    private String address;

    public Person(){
        userID = 0L;
        fName = "";
        lName = "";
        phoneNumber = "";
        address = "";
    }

    public Person(Long userID, String fName, String lName, String phoneNumber, String address){
        this.userID = userID;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

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
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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