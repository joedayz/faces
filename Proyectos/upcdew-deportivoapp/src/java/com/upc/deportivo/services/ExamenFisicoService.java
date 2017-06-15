/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.services;

import com.upc.deportivo.model.ExamenFisicoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ExamenFisicoService {

    public List<ExamenFisicoBean> agregarExamenFisico(ExamenFisicoBean examenFisicos);
    public List<ExamenFisicoBean> eliminarExamenFisico(ExamenFisicoBean examenFisicos);
    public List<ExamenFisicoBean> modificarExamenFisico(ExamenFisicoBean examenFisicos);
    public ExamenFisicoBean obtenerExamenFisico();
    public List<ExamenFisicoBean>  getExamenFisicosImplement(ExamenFisicoBean examenFisicos);
    public void  setExamenFisicosImplement(List<ExamenFisicoBean> examenFisicos);
   public List<ExamenFisicoBean> BuscarExamenFisico(String nombreJugador);
    public void deshabilitarBolean();
}
