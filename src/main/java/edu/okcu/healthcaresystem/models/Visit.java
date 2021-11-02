package edu.okcu.healthcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @Column(name="userid")
    private Long userID;

    @Id
    @Column(name="visitid")
    private Long visitID;

    @Column(name="reason")
    private String reason;

    @Column(name="date")
    private String date;

    @Column(name="note")
    private String note;

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {this.userID = userID;}

    public Long getVisitID() {return visitID;}

    public void setVisitID(Long visitID) {this.visitID = visitID;}

    public String getReason() {return reason;}

    public void setReason(String reason) {this.reason = reason;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getNote() {return note;}

    public void setNote(String note) {this.note = note;}
}
