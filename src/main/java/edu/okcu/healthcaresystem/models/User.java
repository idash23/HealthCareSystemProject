package edu.okcu.healthcaresystem.models;

import antlr.Token;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "persontype")
    private String personType;

    @Column(name = "token")
    private String token;

    @Column(name = "lastlogin")
    private Timestamp lastLogin;

    @Column(name = "tokenexpdate")
    private Timestamp tokenExpDate;

    @Column(name = "countfailedlogin")
    private long countFailedLogin;

    public Long getUserID() {return userID;}

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //this.password = passwordEncoder.encode(password);
        this.password = password;
    }

    public void setPasswordAndHash(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public String getSalt() {return salt;}

    public void setSalt(String salt) {this.salt = salt;}

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {this.token = token;}

    public java.sql.Timestamp getLastLogin() {return lastLogin;}

    public void setLastLogin(Timestamp lastLogin) {this.lastLogin = lastLogin;}

    public java.sql.Timestamp getTokenExpDate() {return tokenExpDate;}

    public void setTokenExpDate(Timestamp tokenExpDate) {this.tokenExpDate = tokenExpDate;}

    public long getCountFailedLogin() {return countFailedLogin;}

    public void setCountFailedLogin(long CountFailedLogin) {this.countFailedLogin = CountFailedLogin;}

}

