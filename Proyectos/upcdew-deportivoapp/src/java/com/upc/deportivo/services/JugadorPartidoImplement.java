/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.services;

import com.upc.deportivo.dao.JugadorPartidoDao;
import com.upc.deportivo.dao.PartidoDao;
import com.upc.deportivo.model.JugadorPartidoBean;
import com.upc.deportivo.model.PartidoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class JugadorPartidoImplement implements JugadorPartidoService {

      private JugadorPartidoDao jugadorPartidoDao;
      private PartidoDao partidoDao;
    
    public PartidoBean grabarPartidoJugador(PartidoBean partido) {
        
        PartidoBean partidoTemp = partido;

        partidoTemp=partidoDao.actualizarPartido(partido);
        
        System.out.println("PINTA CODIGO---"+partidoTemp.getCodigoPartido());


        for (JugadorPartidoBean jpb : partido.getObjJugadorPartido()) {

            jpb.setCodigoPartido(partidoTemp.getCodigoPartido());

            jugadorPartidoDao.actualizarJugadorPartido(jpb);

        }

        partido = partidoDao.obtenerPartido(partidoTemp.getCodigoPartido());

        return partido;
    }

    public JugadorPartidoDao getJugadorPartidoDao() {
        return jugadorPartidoDao;
    }

    public void setJugadorPartidoDao(JugadorPartidoDao jugadorPartidoDao) {
        this.jugadorPartidoDao = jugadorPartidoDao;
    }

    public PartidoDao getPartidoDao() {
        return partidoDao;
    }

    public void setPartidoDao(PartidoDao partidoDao) {
        this.partidoDao = partidoDao;
    }

   

 

}
