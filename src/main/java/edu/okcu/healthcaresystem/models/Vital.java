package edu.okcu.healthcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vital")
public class Vital {
    @Id
    @Column(name="userid")
    private Long userID;

    @Id
    @Column(name="vitalid")
    private Long vitalID;

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

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {this.userID = userID;}

    public Long getVitalID() {return vitalID;}

    public void setVitalID(Long vitalID) {this.vitalID = vitalID;}

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
}
