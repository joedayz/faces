/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.services;

import com.upc.deportivo.model.JugadorBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface JugadorService {

    public List<JugadorBean> agregarJugador(JugadorBean jugador);

    public List<JugadorBean> eliminarJugador();

    public List<JugadorBean> modificarJugador(JugadorBean jugador);

  
    public JugadorBean obtenerJugador();

    public List<JugadorBean> BuscarJugador(String nombreJugador, String posicion);

    public void setJugadores(List<JugadorBean> jugadores);

    public void deshabilitarBolean();

    public List<JugadorBean> getJugadores();
    
   
}
