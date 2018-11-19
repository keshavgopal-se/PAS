package com.nalashaa.pas.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by siva on 19-11-2018.
 */
@Entity
public class PatientSettings extends EntityBase implements Serializable
{
    boolean email;
    boolean sms;
    boolean watsApp;
    boolean nativeApp;

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    public boolean isNativeApp() {
        return nativeApp;
    }

    public void setNativeApp(boolean nativeApp) {
        this.nativeApp = nativeApp;
    }

    public boolean isWatsApp() {
        return watsApp;
    }

    public void setWatsApp(boolean watsApp) {
        this.watsApp = watsApp;
    }
}
