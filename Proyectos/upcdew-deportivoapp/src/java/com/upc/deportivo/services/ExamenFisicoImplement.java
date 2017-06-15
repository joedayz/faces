/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.services;
import com.upc.deportivo.dao.ExamenFisicoDao;
import com.upc.deportivo.model.ExamenFisicoBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ExamenFisicoImplement implements ExamenFisicoService{

    private List<ExamenFisicoBean> examenFisicosImplement;
     private ExamenFisicoDao examenFisicoDao;
    public ExamenFisicoImplement(){
    
//      examenFisicosImplement=new ArrayList<ExamenFisicoBean>();
         
    }
    
    public List<ExamenFisicoBean> agregarExamenFisico(ExamenFisicoBean examenFisico) {
//    getExamenFisicosImplement().add(examenFisico);
//    return getExamenFisicosImplement();
        examenFisicoDao.actualizarExamenFisico(examenFisico);
        return  getExamenFisicosImplement(examenFisico);
    }

    public List<ExamenFisicoBean> eliminarExamenFisico(ExamenFisicoBean examenFisico) {
        
//        ArrayList<ExamenFisicoBean> temp = new ArrayList<ExamenFisicoBean>();

        for (ExamenFisicoBean ef : examenFisicosImplement) {
            if (ef.isSelectedEliminar()) {
                System.out.println("PINTA EN SER  ---"+ef.getCo_ExamenFis());
   

                examenFisicoDao.eliminarExamenFisico(ef);
            }
        }
//        getExamenFisicosImplement().clear();
//        setExamenFisicosImplement(temp) ;

        return getExamenFisicosImplement(examenFisico);
    }

    public ExamenFisicoBean obtenerExamenFisico() {
        for (int i = 0; i < examenFisicosImplement.size(); i++) {
            if (examenFisicosImplement.get(i).isSelectedModificar()) {
                return examenFisicosImplement.get(i);
            }
        }
        return null;
    }

    public List<ExamenFisicoBean> modificarExamenFisico (ExamenFisicoBean examenFisico) {
    
        
     for (int i = 0; i < examenFisicosImplement.size(); i++) {
        if (examenFisicosImplement.get(i).getCo_ExamenFis().equals(examenFisico.getCo_ExamenFis())) {
                examenFisicoDao.actualizarExamenFisico(examenFisico);
            }
        }
        return getExamenFisicosImplement(examenFisico);
    }

    public ExamenFisicoBean obtenerExamenFisico(List<ExamenFisicoBean> examenFisicos) {
           for (int i = 0; i < examenFisicos.size(); i++) {

            if (examenFisicos.get(i).isSelectedModificar()) {
                
                return examenFisicos.get(i);
                }
           
           }
   return null;
    }

    public List<ExamenFisicoBean> getExamenFisicosImplement(ExamenFisicoBean examenFisico) {
        
        examenFisicosImplement = examenFisicoDao.obtenerListaExamenesFisicos(examenFisico);
        deshabilitarBolean();
        return examenFisicosImplement;
    }
   public void deshabilitarBolean() {
        for (ExamenFisicoBean jg : examenFisicosImplement) {
            jg.setSelectedEliminar(false);
            jg.setSelectedModificar(false);
        }
    }

    public void setExamenFisicosImplement(List<ExamenFisicoBean> examenFisicos) {
         
        this.examenFisicosImplement = examenFisicos;
    }

    public ExamenFisicoDao getExamenFisicoDao() {
        return examenFisicoDao;
    }

    public void setExamenFisicoDao(ExamenFisicoDao examenFisicoDao) {
        this.examenFisicoDao = examenFisicoDao;
    }

    public List<ExamenFisicoBean> BuscarExamenFisico(String nombreJugador) {
        ArrayList<ExamenFisicoBean> temp = new ArrayList<ExamenFisicoBean>();
        for (int i = 0; i < examenFisicosImplement.size(); i++) {
            if (examenFisicosImplement.get(i).getNombre().equals(nombreJugador)) {
                temp.add(examenFisicosImplement.get(i));
            }
            if (examenFisicosImplement.get(i).getNombre().equals(nombreJugador) ) {
                temp.add(examenFisicosImplement.get(i));
            }
            if (nombreJugador.equals("")) {
                return temp = (ArrayList<ExamenFisicoBean>) examenFisicosImplement;
            }
        }



        return temp;
    }

  
}
