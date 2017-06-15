/**
 * En esta capa MODEL vamos a crear el BEAN JugadorPartidoBean
 * para definir los atributos de la Clase JugadorPartido
 */

package com.upc.deportivo.model;

import java.util.ArrayList; 


public class JugadorPartidoBean {
    
    private JugadorBean jugador;
    private boolean selectedEliminar;
    private boolean selectedModificar;
    private String codigo;
    private String codigoJugadorPartido;

  
    private int numPasesbuenos;


    private int numPasesErrados;

 
    private int posicionAdelanta;


    private int scalaRendimiento;

     private int goles;
      
     private int tarjetaAmarillas;
     
     private int tarjetaRojas;
     
     private String indiciplina;
     
     private String lesiones;
     
     private String codigoPartido;
     
     private String nombreJugador;
     
     
   
    public JugadorPartidoBean () {
    }

 
    public int getNumPasesErrados () {
        return numPasesErrados;
    }

  
    public void setNumPasesErrados (int val) {
        this.numPasesErrados = val;
    }


    public int getNumPasesbuenos () {
        return numPasesbuenos;
    }

    
    public void setNumPasesbuenos (int val) {
        this.numPasesbuenos = val;
    }

  
   
  
   

 
    public int getScalaRendimiento () {
        return scalaRendimiento;
    }

  
    public void setScalaRendimiento (int val) {
        this.scalaRendimiento = val;
    }

    public JugadorBean getJugador() {
        return jugador;
    }

    public void setJugador(JugadorBean jugador) {
        this.jugador = jugador;
    }

    public boolean isSelectedEliminar() {
        return selectedEliminar;
    }

    public void setSelectedEliminar(boolean selectedEliminar) {
        this.selectedEliminar = selectedEliminar;
    }

    public boolean isSelectedModificar() {
        return selectedModificar;
    }

    public void setSelectedModificar(boolean selectedModificar) {
        this.selectedModificar = selectedModificar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPosicionAdelanta() {
        return posicionAdelanta;
    }

    public void setPosicionAdelanta(int posicionAdelanta) {
        this.posicionAdelanta = posicionAdelanta;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getTarjetaAmarillas() {
        return tarjetaAmarillas;
    }

    public void setTarjetaAmarillas(int tarjetaAmarillas) {
        this.tarjetaAmarillas = tarjetaAmarillas;
    }

    public int getTarjetaRojas() {
        return tarjetaRojas;
    }

    public void setTarjetaRojas(int tarjetaRojas) {
        this.tarjetaRojas = tarjetaRojas;
    }

  

    public String getLesiones() {
        return lesiones;
    }

    public void setLesiones(String lesiones) {
        this.lesiones = lesiones;
    }

    public String getIndiciplina() {
        return indiciplina;
    }

    public void setIndiciplina(String indiciplina) {
        this.indiciplina = indiciplina;
    }

    public String getCodigoJugadorPartido() {
        return codigoJugadorPartido;
    }

    public void setCodigoJugadorPartido(String codigoJugadorPartido) {
        this.codigoJugadorPartido = codigoJugadorPartido;
    }

    public String getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(String codigPartido) {
        this.codigoPartido = codigPartido;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

 
}

