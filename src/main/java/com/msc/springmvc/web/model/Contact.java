package com.msc.springmvc.web.model;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * This code was written by Marcelo Caldas.
 * e-Mail: mscaldas@gmail.com
 * <p/>
\ * Project: springmvc-web
 * <p/>
 * Date: 11/12/13
 * <p/>
 */
public class Contact implements Serializable {
    private static final Logger logger = Logger.getLogger(Contact.class.getName());
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private String security;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
