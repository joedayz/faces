/**
 * En esta capa MODEL vamos a crear el BEAN LesionBean
 * para definir los atributos de la Clase Lesion
 */

package com.upc.deportivo.model;

// Se define los atributos que contiene la clase Lesion de un Jugador

public class LesionBean {

    
    private String fecLesion;

    
    private String tipoLesion;

    
    private int tiempoDescanso;

 
    private String Temporada;


    public LesionBean () {
    }

     
    public String getTemporada () {
        return Temporada;
    }

   
    public void setTemporada (String val) {
        this.Temporada = val;
    }

  
    public String getFecLesion () {
        return fecLesion;
    }

    
    public void setFecLesion (String val) {
        this.fecLesion = val;
    }

    
    public int getTiempoDescanso () {
        return tiempoDescanso;
    }

     
    public void setTiempoDescanso (int val) {
        this.tiempoDescanso = val;
    }


    public String getTipoLesion () {
        return tipoLesion;
    }

    
    public void setTipoLesion (String val) {
        this.tipoLesion = val;
    }

}

