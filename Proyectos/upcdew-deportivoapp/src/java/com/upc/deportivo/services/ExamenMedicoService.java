/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.services;

import com.upc.deportivo.model.ExamenMedicoBean;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ExamenMedicoService {

    public List<ExamenMedicoBean> agregarExamenMedico(ExamenMedicoBean examenesMedicos);
    public List<ExamenMedicoBean> eliminarExamenMedico(ExamenMedicoBean examenMedicos);
    public List<ExamenMedicoBean> modificarExamenMedico(ExamenMedicoBean examenesMedicos);
    public ExamenMedicoBean obtenerExamenMedico();
    public List<ExamenMedicoBean>  getExamenesMedicosImplement(ExamenMedicoBean examenMedicos);
    public void  setExamenesMedicosImplement(List<ExamenMedicoBean> examenesMedicos);
      public List<ExamenMedicoBean> BuscarExamenMedico(String nombreJugador);
        public void deshabilitarBolean();


   }
