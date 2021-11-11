package edu.okcu.healthcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VitalKey implements Serializable {

    @Column(name = "userid", nullable = false)
    private int userID;

    @Column(name = "vitalid", nullable = false)
    private int vitalID;

    public int getUserID() {return userID;}

    public void setUserID(int userID) {this.userID = userID;}

    public int getVitalID() {return vitalID;}

    public void setVitalID(int vitalID) {this.vitalID = vitalID;}
}
