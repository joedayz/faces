/**
 * En esta capa MODEL vamos a crear el BEAN ExamenMedicoBean
 * para definir los atributos de la Clase ExamenMedico
 */

package com.upc.deportivo.model;

import java.util.Date;
// Se define los atributos que contiene la clase Medico
public class ExamenMedicoBean {

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
    private boolean selectedEliminar;
    private boolean selectedModificar;

    public String getCo_ExamenMed() {
        return co_ExamenMed;
    }

    public void setCo_ExamenMed(String co_ExamenMed) {
        this.co_ExamenMed = co_ExamenMed;
    }

    //Set's and get's
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

}
