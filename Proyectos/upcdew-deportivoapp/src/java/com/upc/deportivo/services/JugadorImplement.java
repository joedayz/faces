/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.services;

import com.upc.deportivo.dao.JugadorDao;
import com.upc.deportivo.model.JugadorBean;
import com.upc.deportivo.util.Parametros;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class JugadorImplement implements JugadorService {

    private List<JugadorBean> jugadoresImplement;
    private JugadorDao jugadorDao;

    public JugadorImplement() {
    }

    public List<JugadorBean> agregarJugador(JugadorBean jugador) {

        jugadorDao.actualizarJugador(jugador);
        return getJugadores();
    }

    public List<JugadorBean> eliminarJugador() {

        for (JugadorBean jg : jugadoresImplement) {
            if (jg.isSelectedEliminar()) {
                jugadorDao.eliminarJugador(jg);
            }
        }
        return getJugadores();
    }

    public List<JugadorBean> modificarJugador(JugadorBean jugador) {

        for (int i = 0; i < jugadoresImplement.size(); i++) {
            if (jugadoresImplement.get(i).getCodigo().equals(jugador.getCodigo())) {
                jugadorDao.actualizarJugador(jugador);
            }
        }
        return getJugadores();
    }

    public JugadorBean obtenerJugador() {
        for (int i = 0; i < jugadoresImplement.size(); i++) {
            if (jugadoresImplement.get(i).isSelectedModificar()) {
                return jugadoresImplement.get(i);
            }
        }
        return null;
    }

    public void deshabilitarBolean() {
        for (JugadorBean jg : jugadoresImplement) {
            jg.setSelectedEliminar(false);
            jg.setSelectedModificar(false);
        }
    }

    public List<JugadorBean> BuscarJugador(String nombreJugador, String posicion) {
        ArrayList<JugadorBean> temp = new ArrayList<JugadorBean>();
        for (int i = 0; i < jugadoresImplement.size(); i++) {
            if (jugadoresImplement.get(i).getNombre().equals(nombreJugador) || jugadoresImplement.get(i).getPosicion().equals(posicion)) {
                temp.add(jugadoresImplement.get(i));
            }
            if (jugadoresImplement.get(i).getNombre().equals(nombreJugador) && jugadoresImplement.get(i).getPosicion().equals(posicion)) {
                temp.add(jugadoresImplement.get(i));
            }
            if (nombreJugador.equals("")) {
                return temp = (ArrayList<JugadorBean>) jugadoresImplement;
            }
        }



        return temp;
    }

    public void setJugadores(List<JugadorBean> jugadores) {
        this.jugadoresImplement = jugadores;
    }

    public List<JugadorBean> getJugadores() {
        jugadoresImplement = jugadorDao.obtenerListaJugadores();
        deshabilitarBolean();
        return jugadoresImplement;
    }

    public JugadorDao getJugadorDao() {
        return jugadorDao;
    }

    public void setJugadorDao(JugadorDao jugadorDao) {
        this.jugadorDao = jugadorDao;
    }
}
