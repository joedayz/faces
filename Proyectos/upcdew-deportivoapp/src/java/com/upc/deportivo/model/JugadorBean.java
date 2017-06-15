/**
 * En esta capa MODEL vamos a crear el BEAN JugadorBean
 * para definir los atributos de la Clase Jugador
 */
package com.upc.deportivo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Se define los atributos que contiene la clase Jugador
public class JugadorBean {

    private String codigo;
    private String telefono;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String contrato;
    private boolean selectedEliminar;
    private boolean selectedModificar;
    private Date fecha;
    private String posicion;
  
    private List<ExamenMedicoBean> examenesMedicos;
    private List<ExamenFisicoBean> examenesFisicos;

    public JugadorBean() {
      


        examenesFisicos= new ArrayList<ExamenFisicoBean>();
        examenesMedicos = new ArrayList<ExamenMedicoBean>();

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isSelectedModificar() {
        return selectedModificar;
    }

    public void setSelectedModificar(boolean selectedModificar) {
        this.selectedModificar = selectedModificar;
    }

    public boolean isSelectedEliminar() {
        return selectedEliminar;
    }

    public void setSelectedEliminar(boolean selectedEliminar) {
        this.selectedEliminar = selectedEliminar;
    }


    public List<ExamenMedicoBean> getExamenesMedicos() {
        return examenesMedicos;
    }

    public void setExamenesMedicos(List<ExamenMedicoBean> examenesMedicos) {
        this.examenesMedicos = examenesMedicos;
    }

    public List<ExamenFisicoBean> getExamenesFisicos() {
        return examenesFisicos;
    }

    public void setExamenesFisicos(List<ExamenFisicoBean> examenesFisico) {
        this.examenesFisicos = examenesFisico;
    }
/**
 * Valida el examen mÃ¨dico relacionado a un jugador
 * @param  examenMedico  valida la lista de examenes mÃ¨dicos ingresados
 * @return  Retorna verdadero o Falso
 */
    public boolean validarExamenMedicoInsert(ExamenMedicoBean examenMedico) {

        for (ExamenMedicoBean em : examenesMedicos) {

            if (em.getTemporada().equals(examenMedico.getTemporada())) {

                return false;
            }
        }

        return true;
    }
/**
 * Valida el examen FÃ¬sico relacionado a un jugador
 * @param  examenFisico  valida la lista de Examenes Fisicos ingresados
 * @return  Returna verdadero o Falso
 */
    public boolean validarExamenFisicoInsert(ExamenFisicoBean examenFisico) {

        for (ExamenFisicoBean ef : examenesFisicos) {

            if (ef.getTemporada().equals(examenFisico.getTemporada())) {

                return false;
            }
        }

        return true;
    } 
/**
 * Valida la actualizaciÃ²n del examen MÃ¨dico relacionado a un jugador
 * @param  examenMedico  valida la lista de examenes medicos actualizados
 * @return  Returna verdadero o Falso
 */
    public boolean validarExamenMedicoUpdate(ExamenMedicoBean examenMedico) {

        int cont = 0;

        for (ExamenMedicoBean em : examenesMedicos) {

            if (em.getTemporada().equals(examenMedico.getTemporada())) {

                cont++;
            }
        }

        if (cont > 1) {
            return false;
        }
        return true;
    }
/**
 * Valida la actualizaciÃ²n del examen FÃ¬sico relacionado a un jugador
 * @param  examenFisico  valida la lista de examenes fÃ¬sicos actualizados
 * @return  Returna verdadero o Falso
 */
    public boolean validarExamenFisicoUpdate(ExamenFisicoBean examenFisico) {

        int cont = 0;

        for (ExamenFisicoBean ef : examenesFisicos) {
       
            if (ef.getTemporada().equals(examenFisico.getTemporada())) {
              cont++;
            }
        }
        if (cont > 1) {
            return false;
        }
        return true;
    }
}
