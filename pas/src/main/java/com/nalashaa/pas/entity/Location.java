package com.nalashaa.pas.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by siva on 19-11-2018.
 */
@Entity
public class Location extends EntityBase implements Serializable
{
    String longitude;
    String latitude;
    String name;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
