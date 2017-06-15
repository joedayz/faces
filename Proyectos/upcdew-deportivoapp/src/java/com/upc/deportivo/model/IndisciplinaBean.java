/**
 * En esta capa MODEL vamos a crear el BEAN IndisciplinaBean
 * para definir los atributos de la Clase Indisciplina
 */
package com.upc.deportivo.model;

// Se define los atributos que contiene la clase Indisciplina cometida
// por el jugador

public class IndisciplinaBean {

 
    private String fecIndisciplina;

    private String descripcion;

    private String TipoCastipo;


    private Double porcentajeDescuento;


    private int diasSuspension;


    private int numTarjeAmarilla;


    private int numTarjetaRojas;

    
    public IndisciplinaBean () {
    }

   
    public String getTipoCastipo () {
        return TipoCastipo;
    }

 
    public void setTipoCastipo (String val) {
        this.TipoCastipo = val;
    }

   
    public String getDescripcion () {
        return descripcion;
    }

   
    public void setDescripcion (String val) {
        this.descripcion = val;
    }

 
    public int getDiasSuspension () {
        return diasSuspension;
    }

  
    public void setDiasSuspension (int val) {
        this.diasSuspension = val;
    }


    public String getFecIndisciplina () {
        return fecIndisciplina;
    }


    public void setFecIndisciplina (String val) {
        this.fecIndisciplina = val;
    }

 
    public int getNumTarjeAmarilla () {
        return numTarjeAmarilla;
    }

  
    public void setNumTarjeAmarilla (int val) {
        this.numTarjeAmarilla = val;
    }


    public int getNumTarjetaRojas () {
        return numTarjetaRojas;
    }


    public void setNumTarjetaRojas (int val) {
        this.numTarjetaRojas = val;
    }

   
    public Double getPorcentajeDescuento () {
        return porcentajeDescuento;
    }


    public void setPorcentajeDescuento (Double val) {
        this.porcentajeDescuento = val;
    }

}

