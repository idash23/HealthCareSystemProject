package edu.okcu.healthcaresystem.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userID;

    @Column(name="DOB")
    private String DOB;

    @Column(name="gender")
    private String gender;

    @Column(name="allergies")
    private String allergies;

    @Column(name="insuranceinfo")
    private String insuranceInfo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Vital> vitals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Vaccination> vacs = new ArrayList<>();

    public Long getUserID() { return userID; }

    public void setUserID(Long userID) { this.userID = userID; }

    public String getDOB() {return DOB;}

    public void setDOB(String DOB) {this.DOB = DOB;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public String getAllergies() {return allergies;}

    public void setAllergies(String allergies) {this.allergies = allergies;}

    public String getInsuranceInfo() {return insuranceInfo;}

    public void setInsuranceInfo(String insuranceInfo) {this.insuranceInfo = insuranceInfo;}

    public List<Vital> getVitals() {return vitals;}

    public void setVitals(List<Vital> vitals) {this.vitals = vitals;}

    public List<Visit> getVisits() {return visits;}

    public void setVisits(List<Visit> visits) {this.visits = visits;}

    public List<Vaccination> getVacs() {return vacs;}

    public void setVacs(List<Vaccination> vacs) {this.vacs = vacs;}
}
