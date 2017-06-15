/**
 * En esta capa MODEL vamos a crear el BEAN PartidoBean
 * para definir los atributos de la Clase Partido
 */

package com.upc.deportivo.model;


import java.util.ArrayList; 

import java.util.Date;
// Se define los atributos que contiene la clase Partido
public class PartidoBean {

    
    private String codigoPartido;

    private String codigoCampeonato;


    private Date fechaPartido;
    
   

  
    private String ciudad;

   
    private String tipoCancha;


    private String equipoContrario;
    
    private String localidad;
    
    private int golFavor;
      
    private int golContra;

    
    private ArrayList<JugadorPartidoBean> jugadores;

    
    
     private boolean selectedConsultar;
     
    public PartidoBean () {
        selectedConsultar=false;
    }

 
    public String getCiudad () {
        return ciudad;
    }

    
    public void setCiudad (String val) {
        this.ciudad = val;
    }


    public String getEquipoContrario () {
        return equipoContrario;
    }

  
    public void setEquipoContrario (String val) {
        this.equipoContrario = val;
    }

 
    public Date getFechaPartido () {
        return fechaPartido;
    }

 
    public void setFechaPartido (Date val) {
        this.fechaPartido = val;
    }

    

    public ArrayList<JugadorPartidoBean> getObjJugadorPartido () {
        return jugadores;
    }


    public void setObjJugadorPartido (ArrayList<JugadorPartidoBean> val) {
        this.jugadores = val;
    }


    public String getTipoCancha () {
        return tipoCancha;
    }


    public void setTipoCancha (String val) {
        this.tipoCancha = val;
    }

    public String getCodigoCampeonato() {
        return codigoCampeonato;
    }

    public void setCodigoCampeonato(String codigoCampeonato) {
        this.codigoCampeonato = codigoCampeonato;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getGolFavor() {
        return golFavor;
    }

    public void setGolFavor(int golFavor) {
        this.golFavor = golFavor;
    }

    public int getGolContra() {
        return golContra;
    }

    public void setGolContra(int golContra) {
        this.golContra = golContra;
    }

    public String getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public boolean isSelectedConsultar() {
        return selectedConsultar;
    }

    public void setSelectedConsultar(boolean selectedConsultar) {
        this.selectedConsultar = selectedConsultar;
    }


}

