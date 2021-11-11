package edu.okcu.healthcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VisitKey implements Serializable {

    @Column(name = "userid", nullable = false)
    private int userID;

    @Column(name = "visitid", nullable = false)
    private int visitID;

    public int getUserID() {return userID;}

    public void setUserID(int userID) {this.userID = userID;}

    public int getVisitID() {return visitID;}

    public void setVisitID(int visitID) {this.visitID = visitID;}
}
