package com.mycompany.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SelectorColor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color = "grey";
	 
    public void blue() {
        color = "blue";
    }
 
    public void green() {
        color = "green";
    }
 
    public void red() {
        color = "red";
    }
 
    public String getColor() {
        return color;
    }
 
    public String getCurrentTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

}
