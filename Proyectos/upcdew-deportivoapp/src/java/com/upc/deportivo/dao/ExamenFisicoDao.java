/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao;

import com.upc.deportivo.model.ExamenFisicoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ExamenFisicoDao {

    public List<ExamenFisicoBean> obtenerListaExamenesFisicos(ExamenFisicoBean examenFisico);

    public void actualizarExamenFisico(ExamenFisicoBean examenFisico);

    public void eliminarExamenFisico(ExamenFisicoBean examenFisico);
}
