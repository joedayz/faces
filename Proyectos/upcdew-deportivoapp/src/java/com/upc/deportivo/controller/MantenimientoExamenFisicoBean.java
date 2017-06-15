/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.controller;

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.upc.deportivo.model.ExamenFisicoBean;
import com.upc.deportivo.services.ExamenFisicoImplement;
import com.upc.deportivo.services.ExamenFisicoService;
import com.upc.deportivo.view.BaseManageBean;
import com.upc.deportivo.model.JugadorBean;

import com.upc.deportivo.util.FacesUtils;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletException;

 /**
 * Se define los atributos que contiene la clase MantenimientoExamenFisico
 */
public class MantenimientoExamenFisicoBean extends BaseManageBean {

    private String co_ExamenFis;
    private String codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String descripcion;
    private String tipoExamenFisico;
    private Double resultado;
    private String temporada;
    private boolean allChecks;
    private ExamenFisicoBean examenFisicoBean;
    private List<ExamenFisicoBean> examenFisicos;
    private JugadorBean jugadorBean;
  
        

    public List<ExamenFisicoBean> getExamenFisicos() {
        return examenFisicos;
    }

    public void setExamenFisicos(List<ExamenFisicoBean> examenFisicos) {
        this.examenFisicos = examenFisicos;
    }

    public ExamenFisicoBean getExamenFisicoBean() {
        return examenFisicoBean;
    }

    public void setExamenFisicoBean(ExamenFisicoBean examenFisicoBean) {
        this.examenFisicoBean = examenFisicoBean;
    }




 public String getCo_ExamenFis() {
        return co_ExamenFis;
   }

    public void setCo_ExamenFis(String co_ExamenFis) {
        this.co_ExamenFis = co_ExamenFis;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

  

    public void setExamenMedicoBean(ExamenFisicoBean examenFisicoBean) {
        this.examenFisicoBean = examenFisicoBean;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getTipoExamenFisico() {
        return tipoExamenFisico;
    }

    public void setTipoExamenFisico(String tipoExamenFisico) {
        this.tipoExamenFisico = tipoExamenFisico;
    }

    /**
 * Se define la accion del boton Grabar. Graba en un arreglo el examen FÃ¬sico para pasarlo a la Base de Datos
 * para ser enviados a la capa DAO
 */

    public void btnGrabarActionPerformed() {


           
        examenFisicoBean = new ExamenFisicoBean();

        examenFisicoBean.setCodigo(codigo);
        examenFisicoBean.setNombre(nombre);
        examenFisicoBean.setApellidoMaterno(apellidoMaterno);
        examenFisicoBean.setApellidoPaterno(apellidoPaterno);
        examenFisicoBean.setDescripcion(descripcion);
        examenFisicoBean.setTipoExamenFisico(getSelectedTipoExamenFisico());
        examenFisicoBean.setResultado(resultado);
        examenFisicoBean.setTemporada(getSelectedTemporada());
        examenFisicoBean.setSelectedEliminar(false);
        examenFisicoBean.setSelectedModificar(false);
         setExamenFisicos((ArrayList<ExamenFisicoBean>) getExamenFisicoServices().agregarExamenFisico(examenFisicoBean));

    }
     /**
 * Para limpiar la ventana de ingreso de datos del examen fisico
 */
    public void btnlimpiarActionPerformed() {

        codigo = "";
        nombre = "";
        apellidoPaterno = "";
        apellidoMaterno = "";
        tipoExamenFisico="";
        descripcion="";
        resultado =null;
        temporada="";
       
    }
 /**
 * Elimina los Examenes Fisicos seleccionados
 */
    public boolean selectedCheck(ValueChangeEvent e) {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return true;
        }
         //Procede a eliminar el Examen Fisico seleccionado con check

        for (ExamenFisicoBean a : getExamenFisicos()) {

            a.setSelectedEliminar(allChecks);

        }
        return true;
    }
 /**
 * Se define la accion del boton Eliminar
 */
    public void btnEliminarActionPerformed(ActionEvent e) {


         if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();

        }
        btnlimpiarActionPerformed();
        
        ExamenFisicoBean ef=new ExamenFisicoBean();
        ef.setCodigo(jugadorBean.getCodigo());
        setExamenFisicos((ArrayList<ExamenFisicoBean>) getExamenFisicoServices().eliminarExamenFisico( ef));

    }

   


    public boolean isAllChecks() {
        return allChecks;
    }

    public void setAllChecks(boolean allChecks) {
        this.allChecks = allChecks;
    }
 /**
 * Se define la accion del seleccion
 */
    public void rowSelectionListener(RowSelectorEvent e) throws ServletException, IOException {
        //Selecciona el ExamenFisico y procede a buscarlo

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
        }

        
        examenFisicoBean = getExamenFisicoServices().obtenerExamenFisico();

        mostrarInformacionExameFisico(examenFisicoBean);
        /**Se cierra el popup luego de seleccionar el item del pedido**/
       
    }
 /**
 * Para mostrar la data del ExamenFisico
 */
    public void mostrarInformacionExameFisico(ExamenFisicoBean examenFisico) {

      if(examenFisico!=null){
        setCodigo(jugadorBean.getCodigo());
        setNombre(jugadorBean.getNombre());
        setApellidoMaterno(jugadorBean.getApellidoMaterno());
        setApellidoPaterno(jugadorBean.getApellidoPaterno());
        setDescripcion(examenFisico.getDescripcion());
        setTipoExamenFisico(examenFisico.getTipoExamenFisico());
        setResultado(examenFisico.getResultado());
        setTemporada(examenFisico.getTemporada());
        setSelectedTemporada(examenFisico.getTemporada());
        setCo_ExamenFis(examenFisico.getCo_ExamenFis());
    }
         }
 /**
 * Se define la accion del boton Modificar
 */
       public void  btnModificarActionPerformed(ActionEvent e) {

               if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
                    e.setPhaseId(PhaseId.INVOKE_APPLICATION);
                    e.queue();
                }
        examenFisicoBean=new ExamenFisicoBean();
        examenFisicoBean.setCodigo(codigo);
        examenFisicoBean.setNombre(nombre);
        examenFisicoBean.setApellidoMaterno(apellidoMaterno);
        examenFisicoBean.setApellidoPaterno(apellidoPaterno);
        examenFisicoBean.setDescripcion(descripcion);
        examenFisicoBean.setTipoExamenFisico(getSelectedTipoExamenFisico());
        examenFisicoBean.setResultado(resultado);
        examenFisicoBean.setTemporada(getSelectedTemporada());
        examenFisicoBean.setCo_ExamenFis(getCo_ExamenFis());
        setExamenFisicos(getExamenFisicoServices().modificarExamenFisico(examenFisicoBean));

  }
        /**
 * Selecciona al jugador, busca sus datos y finalmente los muestra
 * en el Controller
 */

       public void rowSelectionJugadorListener(RowSelectorEvent e) throws ServletException, IOException {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
                    e.setPhaseId(PhaseId.INVOKE_APPLICATION);
                    e.queue();
                }

     jugadorBean=getJugadorServices().obtenerJugador();
     
      btnlimpiarActionPerformed();
      setCodigo(jugadorBean.getCodigo());
      setNombre(jugadorBean.getNombre());
      setApellidoMaterno(jugadorBean.getApellidoMaterno());
      setApellidoPaterno(jugadorBean.getApellidoPaterno());
      
      ExamenFisicoBean ef=new ExamenFisicoBean();
      ef.setCodigo(jugadorBean.getCodigo());
      
      System.out.println("PINTA EN CONTROLLER ---"+ef.getCodigo());
      setExamenFisicos(getExamenFisicoServices().getExamenFisicosImplement(ef));
  
    
      closePopupBuscarJugador();
  }

    public void btnBuscarJugadorActionPerformed(ActionEvent e) {
        setJugadores((ArrayList<JugadorBean>) getJugadorServices().BuscarJugador(getDescripcionNombreJugador(), getSelectedPosicion()));

    }
    public JugadorBean getJugadorBean() {
        return jugadorBean;
    }

    public void setJugadorBean(JugadorBean jugadorBean) {
        this.jugadorBean = jugadorBean;
    }


}
