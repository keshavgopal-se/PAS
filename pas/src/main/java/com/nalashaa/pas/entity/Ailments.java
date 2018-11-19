package com.nalashaa.pas.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by siva on 19-11-2018.
 */
@Entity
public class Ailments extends EntityBase implements Serializable
{
    String name;
    String description;
    String icdCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }
}
