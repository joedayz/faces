/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.services;

import com.upc.deportivo.dao.ExamenMedicoDao;
import com.upc.deportivo.model.ExamenMedicoBean;
import com.upc.deportivo.util.Parametros;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ExamenMedicoImplement  implements ExamenMedicoService {

    private List<ExamenMedicoBean> examenesMedicosImplement;
    private ExamenMedicoDao examenMedicoDao;

    public ExamenMedicoImplement() {
    }

    public List<ExamenMedicoBean> agregarExamenMedico(ExamenMedicoBean examenMedico) {
//        examenMedicoDao.actualizarExamenMedico(examenMedico);
//        return getExamenesMedicosImplement();

        examenMedicoDao.actualizarExamenMedico(examenMedico);
        return getExamenesMedicosImplement(examenMedico);
    }

    public List<ExamenMedicoBean> eliminarExamenMedico(ExamenMedicoBean examenMedico) {


          for (ExamenMedicoBean eb : examenesMedicosImplement) {
            if (eb.isSelectedEliminar()) {
                examenMedicoDao.eliminarExamenMedico(eb);
            }
        }
        return getExamenesMedicosImplement(examenMedico);
    }

    public List<ExamenMedicoBean> modificarExamenMedico(ExamenMedicoBean examenMedico) {
         examenMedicoDao.actualizarExamenMedico(examenMedico);
        
        return getExamenesMedicosImplement(examenMedico);
    }

    public ExamenMedicoBean obtenerExamenMedico() {
        for (int i = 0; i < examenesMedicosImplement.size(); i++) {
            if (examenesMedicosImplement.get(i).isSelectedModificar()) {
                return examenesMedicosImplement.get(i);
            }
        }
        return null;
    }

    public void deshabilitarBolean() {
        for (ExamenMedicoBean jg : examenesMedicosImplement) {
            jg.setSelectedEliminar(false);
            jg.setSelectedModificar(false);
        }
    }

    public List<ExamenMedicoBean> BuscarExamenMedico(String nombreJugador) {
        ArrayList<ExamenMedicoBean> temp = new ArrayList<ExamenMedicoBean>();
        for (int i = 0; i < examenesMedicosImplement.size(); i++) {
            if (examenesMedicosImplement.get(i).getNombre().equals(nombreJugador)) {
                temp.add(examenesMedicosImplement.get(i));
            }
            if (examenesMedicosImplement.get(i).getNombre().equals(nombreJugador) ) {
                temp.add(examenesMedicosImplement.get(i));
            }
            if (nombreJugador.equals("")) {
                return temp = (ArrayList<ExamenMedicoBean>) examenesMedicosImplement;
            }
        }



        return temp;
    }

    public void setExamenesMedicosImplement(List<ExamenMedicoBean> examenMedico) {
        this.examenesMedicosImplement = examenMedico;
    }

    public List<ExamenMedicoBean> getExamenesMedicosImplement(ExamenMedicoBean examenMedico) {
        examenesMedicosImplement = examenMedicoDao.obtenerListadoExamenMedico(examenMedico);
        deshabilitarBolean();
        return examenesMedicosImplement;
    }

    public ExamenMedicoDao getExamenMedicoDao() {
        return examenMedicoDao;
    }

    public void setExamenMedicoDao(ExamenMedicoDao examenMedicoDao) {
        this.examenMedicoDao = examenMedicoDao;
    }

}
