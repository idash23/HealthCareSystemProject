package edu.okcu.healthcaresystem.models;

import javax.persistence.*;

@Entity
@Table(name = "vaccination")
public class Vaccination {
    /*@EmbeddedId
    private VacKey vacKey;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacsID;

    @Column(name="userid")
    private Long userID;

    @Column(name="name")
    private String name;

    @Column(name="date")
    private String date;

    @Column (name="modifyby")
    private String modifyBy;

    public Long getVacsID() {return vacsID;}

    public void setVacsID(Long vacsID) {this.vacsID = vacsID;}

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {this.userID = userID;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getModifyBy(){ return modifyBy;}

    public void setModifyBy(String modifyBy){ this.modifyBy = modifyBy;}
}
