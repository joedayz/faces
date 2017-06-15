/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao;

import com.upc.deportivo.model.JugadorBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface JugadorDao {

    public List<JugadorBean> obtenerListaJugadores();

    public void actualizarJugador(JugadorBean jugador);

    public void eliminarJugador(JugadorBean jugador);
}
