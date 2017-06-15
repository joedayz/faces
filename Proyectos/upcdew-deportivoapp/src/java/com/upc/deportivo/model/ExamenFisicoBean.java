/**
 * En esta capa MODEL vamos a crear el BEAN ExamenFisicoBean
 * para definir los atributos de la Clase ExamenFisico
 */

package com.upc.deportivo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamenFisicoBean {
    private String co_ExamenFis;
    private String codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String descripcion;
    private String tipoExamenFisico;
    private Double resultado;
    private String temporada;
    private boolean selectedEliminar;
    private boolean selectedModificar;

    private List<ExamenFisicoBean> examenesFisicos;
// Se define los atributos que contiene la clase ExamenFisico
    public ExamenFisicoBean() {
      
        examenesFisicos= new ArrayList<ExamenFisicoBean>();

    }

//Set's and get's de los atributos

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

    public String getCo_ExamenFis() {
        return co_ExamenFis;
    }

    public void setCo_ExamenFis(String co_ExamenFis) {
        this.co_ExamenFis = co_ExamenFis;
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

    /*************************************************************/

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

    public List<ExamenFisicoBean> getExamenesFisicos() {
        return examenesFisicos;
    }

    public void setExamenesFisicos(List<ExamenFisicoBean> examenesFisico) {
        this.examenesFisicos = examenesFisico;
    }
/**
 * Valida el examen Físico relacionado a un jugador
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
 * Valida la actualización del examen Físico relacionado a un jugador
 * @param  examenFisico  valida la lista de examenes físicos actualizados
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
