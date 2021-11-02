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

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "personType")
    private String personType;

    @Column(name = "token")
    private String token;

    @Column(name = "lastLogin")
    private Timestamp lastLogin;

    @Column(name = "TokenExpDate")
    private Timestamp TokenExpDate;

    @Column(name = "CountFailedLogin")
    private long CountFailedLogin;

    public Long getUserID() {

        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public String getSalt() {

        return salt;
    }

    public void setSalt(String salt) {

        this.salt = salt;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String Token) {
        this.token = token;

    }

        public java.sql.Timestamp getLastLogin() {
            return lastLogin;
        }

        public void setlastLogin (java.sql.Timestamp lastLogin) {
            this.lastLogin = lastLogin;
        }

            public java.sql.Timestamp getTokenExpDate() {
                return TokenExpDate;
            }

            public void setTokenExpDate(java.sql.Timestamp tokenExpDate) {
                this.TokenExpDate = TokenExpDate;

            }

                public long getCountfailedLogin() {
                    return CountFailedLogin;
                }

                public void setCountFailedLogin(long CountFailedLogin) {
                    this.CountFailedLogin = CountFailedLogin;


        }

    }

