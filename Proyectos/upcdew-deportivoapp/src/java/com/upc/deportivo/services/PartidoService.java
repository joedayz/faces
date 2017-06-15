/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.services;

import com.upc.deportivo.model.PartidoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface PartidoService {

    
    public List<PartidoBean> obtenerPartidos();
    public  PartidoBean obtenerPartido(String codigo);
    
}
