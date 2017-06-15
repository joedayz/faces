/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.services;

import com.upc.deportivo.dao.PartidoDao;
import com.upc.deportivo.model.PartidoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PartidoImplement implements PartidoService {
    
    private PartidoDao partidoDao;
    

    public List<PartidoBean> obtenerPartidos() {
      
    return partidoDao.obtenerPartidos();
    }

    public PartidoDao getPartidoDao() {
        return partidoDao;
    }

    public void setPartidoDao(PartidoDao partidoDao) {
        this.partidoDao = partidoDao;
    }

    public PartidoBean obtenerPartido(String codigo) {
      return partidoDao.obtenerPartido(codigo);
    }

}
