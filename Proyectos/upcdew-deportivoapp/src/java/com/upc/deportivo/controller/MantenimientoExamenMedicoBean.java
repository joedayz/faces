 /**
 * Se define los atributos que contiene la clase MantenimientoExamenMedico
 */
package com.upc.deportivo.controller;

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.upc.deportivo.model.ExamenMedicoBean;
import com.upc.deportivo.model.JugadorBean;
import com.upc.deportivo.services.ExamenMedicoImplement;
import com.upc.deportivo.services.ExamenMedicoService;
import com.upc.deportivo.services.JugadorService;
import com.upc.deportivo.util.FacesUtils;
import com.upc.deportivo.view.BaseManageBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletException;

import javax.faces.event.ActionEvent;

/**
 *
 * @author USUARIO
 */
public class MantenimientoExamenMedicoBean extends BaseManageBean {

    private String co_ExamenMed;
    private String codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Double talla;
    private String examenSangre;
    private String examenOrina;
    private Double alturaPromedioSalto;
    private String temporada;
    private Double resistencia;
    private Double longitudMuslo;
    private Double longitudCintura;
    private Double longitudPecho;
    private Double longitudAntebrazo;
    private Double longitudBrazo;
    private Double longitudCuello;
    private Double peso;
    private boolean allChecks;
    private ExamenMedicoBean examenMedicoBean;
    private List<ExamenMedicoBean> examenesMedicos;
    private JugadorBean jugadorBean;


    public List<ExamenMedicoBean> getExamenesMedicos() {
        return examenesMedicos;
    }

    public void setExamenesMedicos(List<ExamenMedicoBean> examenesMedicos) {
        this.examenesMedicos = examenesMedicos;
    }

//    private Date fecha;
//    ExamenMedicoBean examenMedicoBean;

    public MantenimientoExamenMedicoBean() {

     
//        examenesMedicos = new ArrayList();

    }

    public String getCo_ExamenMed() {
        return co_ExamenMed;
    }

    public void setCo_ExamenMed(String co_ExamenMed) {
        this.co_ExamenMed = co_ExamenMed;
    }

    public Double getAlturaPromedioSalto() {
        return alturaPromedioSalto;
    }

    public void setAlturaPromedioSalto(Double alturaPromedioSalto) {
        this.alturaPromedioSalto = alturaPromedioSalto;
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

    public String getExamenOrina() {
        return examenOrina;
    }

    public void setExamenOrina(String examenOrina) {
        this.examenOrina = examenOrina;
    }

    public String getExamenSangre() {
        return examenSangre;
    }

    public void setExamenSangre(String examenSangre) {
        this.examenSangre = examenSangre;
    }

    public ExamenMedicoBean getExamenMedicoBean() {

        return examenMedicoBean;
    }

    public void setExamenMedicoBean(ExamenMedicoBean examenMedicoBean) {

        this.examenMedicoBean = examenMedicoBean;
    }

   
    public Double getLongitudAntebrazo() {
        return longitudAntebrazo;
    }

    public void setLongitudAntebrazo(Double longitudAntebrazo) {
        this.longitudAntebrazo = longitudAntebrazo;
    }

    public Double getLongitudBrazo() {
        return longitudBrazo;
    }

    public void setLongitudBrazo(Double longitudBrazo) {
        this.longitudBrazo = longitudBrazo;
    }

    public Double getLongitudCintura() {
        return longitudCintura;
    }

    public void setLongitudCintura(Double longitudCintura) {
        this.longitudCintura = longitudCintura;
    }

    public Double getLongitudCuello() {
        return longitudCuello;
    }

    public void setLongitudCuello(Double longitudCuello) {
        this.longitudCuello = longitudCuello;
    }

    public Double getLongitudMuslo() {
        return longitudMuslo;
    }

    public void setLongitudMuslo(Double longitudMuslo) {
        this.longitudMuslo = longitudMuslo;
    }

    public Double getLongitudPecho() {
        return longitudPecho;
    }

    public void setLongitudPecho(Double longitudPecho) {
        this.longitudPecho = longitudPecho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getResistencia() {
        return resistencia;
    }

    public void setResistencia(Double resistencia) {
        this.resistencia = resistencia;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

     /**
 * Se define la accion del boton Ingresar. Este iguala los datos ingresados
 * para ser enviados a la capa DAO.
 */
    public void btnIngresarActionPerformed() {


      
       examenMedicoBean = new ExamenMedicoBean();

        examenMedicoBean.setCodigo(codigo);
        examenMedicoBean.setAlturaPromedioSalto(alturaPromedioSalto);
        examenMedicoBean.setApellidoMaterno(apellidoMaterno);
        examenMedicoBean.setApellidoPaterno(apellidoPaterno);
        examenMedicoBean.setExamenOrina(examenOrina);
        examenMedicoBean.setExamenSangre(examenSangre);
        examenMedicoBean.setLongitudAntebrazo(longitudAntebrazo);
        examenMedicoBean.setLongitudBrazo(longitudBrazo);
        examenMedicoBean.setLongitudCintura(longitudCintura);
        examenMedicoBean.setLongitudCuello(longitudCuello);
        examenMedicoBean.setLongitudMuslo(longitudMuslo);
        examenMedicoBean.setLongitudPecho(longitudPecho);
        examenMedicoBean.setNombre(nombre);
        examenMedicoBean.setPeso(peso);
        examenMedicoBean.setResistencia(resistencia);
        examenMedicoBean.setTalla(talla);
        examenMedicoBean.setTemporada(getSelectedTemporada());
        examenMedicoBean.setSelectedEliminar(false);
        examenMedicoBean.setSelectedModificar(false);
        setExamenesMedicos((ArrayList<ExamenMedicoBean>) getExamenMedicoServices().agregarExamenMedico(examenMedicoBean));

    }

 /**
 * Para limpiar la ventana de ingreso de datos del Examen Medico
 */

    public void btnlimpiarActionPerformed() {

        codigo = "";
        nombre = "";
        apellidoPaterno = "";
        apellidoMaterno = "";
        talla = null;
        examenSangre = "";
        examenOrina = "";
        alturaPromedioSalto = null;
        temporada = "";
        resistencia = null;
        longitudMuslo = null;
        longitudCintura = null;
        longitudPecho = null;
        longitudAntebrazo = null;
        longitudBrazo = null;
        longitudCuello = null;
        peso = null;

    }
 /**
 * Elimina los Examenes Medicos seleccionados
 */
    public boolean selectedCheck(ValueChangeEvent e) {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return true;
        }

        for (ExamenMedicoBean a : getExamenesMedicos()) {

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
        setExamenesMedicos((ArrayList<ExamenMedicoBean>) getExamenMedicoServices().eliminarExamenMedico( this.getExamenMedicoBean() ));


    }

//    public List<ExamenMedicoBean> getExamenesMedicos() {
//
//        examenesMedicos = getExamenMedicoServices().getExamenesMedicosImplement();
//
//        return examenesMedicos;
//    }
//
//    public void setExamenMedicos(ArrayList<ExamenMedicoBean> examenMedicos) {
//      this.examenesMedicos = examenesMedicos;
//    }

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
      
        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
        }

        examenMedicoBean = getExamenMedicoServices().obtenerExamenMedico();


        mostrarInformacionExamenMedico(examenMedicoBean);

    }
 /**
 * Para mostrar la data del ExamenMedico
 */
    public void mostrarInformacionExamenMedico(ExamenMedicoBean examenMedico) {
        if (examenMedico != null) {
            setCodigo(examenMedico.getCodigo());
            setAlturaPromedioSalto(examenMedico.getAlturaPromedioSalto());
            setApellidoMaterno(examenMedico.getApellidoMaterno());
            setApellidoPaterno(examenMedico.getApellidoPaterno());
            setExamenOrina(examenMedico.getExamenOrina());
            setExamenSangre(examenMedico.getExamenSangre());
            setLongitudAntebrazo(examenMedico.getLongitudAntebrazo());
            setLongitudBrazo(examenMedico.getLongitudBrazo());
            setLongitudCintura(examenMedico.getLongitudCintura());
            setLongitudCuello(examenMedico.getLongitudCuello());
            setLongitudMuslo(examenMedico.getLongitudMuslo());
            setLongitudPecho(examenMedico.getLongitudPecho());
            setNombre(examenMedico.getNombre());
            setPeso(examenMedico.getPeso());
            setResistencia(examenMedico.getResistencia());
            setTalla(examenMedico.getTalla());
            setCo_ExamenMed(examenMedico.getCo_ExamenMed());


            setTemporada(examenMedico.getTemporada());
            setSelectedTemporada(examenMedico.getTemporada());

        }
    }
 /**
 * Se define la accion del boton Modificar
 */
    public void btnModificarActionPerformed(ActionEvent e) {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
        }
        examenMedicoBean = new ExamenMedicoBean();
        examenMedicoBean.setCo_ExamenMed(co_ExamenMed);
        examenMedicoBean.setCodigo(codigo);
        examenMedicoBean.setAlturaPromedioSalto(alturaPromedioSalto);
        examenMedicoBean.setApellidoMaterno(apellidoMaterno);
        examenMedicoBean.setApellidoPaterno(apellidoPaterno);
        examenMedicoBean.setExamenOrina(examenOrina);
        examenMedicoBean.setExamenSangre(examenSangre);
        examenMedicoBean.setLongitudAntebrazo(longitudAntebrazo);
        examenMedicoBean.setLongitudBrazo(longitudBrazo);
        examenMedicoBean.setLongitudCintura(longitudCintura);
        examenMedicoBean.setLongitudCuello(longitudCuello);
        examenMedicoBean.setLongitudMuslo(longitudMuslo);
        examenMedicoBean.setLongitudPecho(longitudPecho);
        examenMedicoBean.setNombre(nombre);
        examenMedicoBean.setPeso(peso);
        examenMedicoBean.setResistencia(resistencia);
        examenMedicoBean.setTalla(talla);
        examenMedicoBean.setTemporada(getSelectedTemporada());
        setExamenesMedicos(getExamenMedicoServices().modificarExamenMedico(examenMedicoBean));



    }
     /**
 * Selecciona al jugador, busca sus datos y finalemnte los muestra
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
      ExamenMedicoBean em=new ExamenMedicoBean();
      em.setCodigo(jugadorBean.getCodigo());
      setExamenesMedicos(getExamenMedicoServices().getExamenesMedicosImplement(em));
  

      closePopupBuscarJugador();
  }


}
