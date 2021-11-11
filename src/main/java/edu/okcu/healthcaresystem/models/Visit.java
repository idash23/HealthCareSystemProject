package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitID;

    @Column(name="userid")
    private Long userID;

    @Column(name="reason")
    private String reason;

    @Column(name="date")
    private String date;

    @Column(name="note")
    private String note;

    //public VisitKey getVisitKey() {return visitKey;}

    //public void setVisitKey(VisitKey visitKey) {this.visitKey = visitKey;}

    public Long getVisitID() {return visitID;}

    public void setVisitID(Long visitID) {this.visitID = visitID;}

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {this.userID = userID;}

    public String getReason() {return reason;}

    public void setReason(String reason) {this.reason = reason;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getNote() {return note;}

    public void setNote(String note) {this.note = note;}
}
