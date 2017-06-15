/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao;

import com.upc.deportivo.model.ExamenMedicoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ExamenMedicoDao {

    public List<ExamenMedicoBean> obtenerListadoExamenMedico(ExamenMedicoBean examenMedico);

    public void actualizarExamenMedico(ExamenMedicoBean examenMedico);

    public void eliminarExamenMedico(ExamenMedicoBean examenMedico);
}
