package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name="userid")
public class Patient extends Person {
    @Id
    @Column(name="userid")
    private Long userID;

    @Column(name="dob")
    private String DOB;

    @Column(name="gender")
    private String gender;

    @Column(name="allergies")
    private String allergies;

    @Column(name="insuranceinfo")
    private String insuranceInfo;

    public Patient(){
        super();
        userID = 0L;
        DOB = "";
        gender = "X";
        allergies = "";
        insuranceInfo = "";
    }

    public Patient(Long userID, String fName, String lName, String phoneNumber, String address,
                   Long userIDPatient, String DOB, String gender, String allergies, String insuranceInfo){
        super(userID, fName, lName, phoneNumber, address);
        this.userID = userIDPatient;
        this.DOB = DOB;
        this.gender = gender;
        this.allergies = allergies;
        this.insuranceInfo = insuranceInfo;
    }

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Vital> vitals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Vaccination> vacs = new ArrayList<>();*/

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

    /*public List<Vital> getVitals() {return vitals;}

    public void setVitals(List<Vital> vitals) {this.vitals = vitals;}

    public List<Visit> getVisits() {return visits;}

    public void setVisits(List<Visit> visits) {this.visits = visits;}

    public List<Vaccination> getVacs() {return vacs;}

    public void setVacs(List<Vaccination> vacs) {this.vacs = vacs;}*/

    /*public void setPerson(Person person, Patient patient){
        patient.setfName(person.getfName());
        patient.setlName(person.getlName());
        patient.setPhoneNumber(person.getPhoneNumber());
        patient.setAddress(person.getAddress());
    }*/
}
