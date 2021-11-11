package edu.okcu.healthcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VacKey implements Serializable {

    @Column(name = "userid", nullable = false)
    private int userID;

    @Column(name = "vacsid", nullable = false)
    private int vacsID;

    public int getUserID() {return userID;}

    public void setUserID(int userID) {this.userID = userID;}

    public int getVacsID() {return vacsID;}

    public void setVacsID(int vacsID) {this.vacsID = vacsID;}
}
