/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demojsf.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author admin
 */
@ManagedBean
@RequestScoped
public class PprBean {

    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
