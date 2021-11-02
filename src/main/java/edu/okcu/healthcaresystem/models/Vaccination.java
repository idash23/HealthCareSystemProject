package edu.okcu.healthcaresystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccination")
public class Vaccination {
    @Id
    @Column(name="userid")
    private Long userID;

    @Id
    @Column(name="vacsid")
    private Long vacsID;

    @Column(name="name")
    private String name;

    @Column(name="date")
    private String date;

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {this.userID = userID;}

    public Long getVacsID() {return vacsID;}

    public void setVacsID(Long vacsID) {this.vacsID = vacsID;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}
}
