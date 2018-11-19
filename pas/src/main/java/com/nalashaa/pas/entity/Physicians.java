package com.nalashaa.pas.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by siva on 19-11-2018.
 */
@Entity
public class Physicians extends EntityBase implements Serializable
{
    String firstName;
    String LastName;
    String email;
    String mobile;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
