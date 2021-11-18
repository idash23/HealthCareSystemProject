package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "vital")
public class Vital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vitalID;

    @Column(name="userid")
    private Long userID;

    @Column(name="height")
    private int height;

    @Column(name="weight")
    private int weight;

    @Column(name="temp")
    private double temp;

    @Column(name="bloodPress")
    private int bloodPress;

    @Column(name="date")
    private String date;

    @Column (name="modifyby")
    private String modifyBy;

    /*public VitalKey getVitalKey() {return vitalKey;}

    public void setVitalKey(VitalKey vitalKey) {this.vitalKey = vitalKey;}*/

    public Long getVitalID() {return vitalID;}

    public void setVitalID(Long vitalID) {this.vitalID = vitalID;}

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {this.userID = userID;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}

    public int getWeight() {return weight;}

    public void setWeight(int weight) {this.weight = weight;}

    public double getTemp() {return temp;}

    public void setTemp(double temp) {this.temp = temp;}

    public int getBloodPress() {return bloodPress;}

    public void setBloodPress(int bloodPress) {this.bloodPress = bloodPress;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getModifyBy(){ return modifyBy;}

    public void setModifyBy(String modifyBy){ this.modifyBy = modifyBy;}
}
