package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "docpat")
@IdClass(MyKey.class)
public class DocPat {
    @Id
    @Column(name="docid")
    private Long docID;

    @Id
    @Column(name="patid")
    private Long patID;

    @Column(name="expdate")
    private String expDate;

    @Column(name="patinfo")
    private String patInfo;

    public Long getDocID() {return docID;}

    public void setDocID(Long docID) {this.docID = docID;}

    public Long getPatID() {return patID;}

    public void setPatID(Long patID) {this.patID = patID;}

    public String getExpDate() {return expDate;}

    public void setExpDate(String expDate) {this.expDate = expDate;}

    public String getPatInfo() {return patInfo;}

    public void setPatInfo(String patInfo) {this.patInfo = patInfo;}
}
