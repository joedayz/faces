/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.view;

import com.upc.deportivo.model.JugadorBean;
import com.upc.deportivo.model.ExamenMedicoBean;
import com.upc.deportivo.services.ExamenFisicoService;
import com.upc.deportivo.services.ExamenMedicoService;
import com.upc.deportivo.services.JugadorImplement;
import com.upc.deportivo.services.JugadorService;
import com.upc.deportivo.services.PartidoService;
import com.upc.deportivo.util.FacesUtils;
import com.upc.deportivo.util.Parametros;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author USUARIO
 */
public class BaseManageBean {

    protected final Logger logger = Logger.getLogger(BaseManageBean.class.getName());
    private SelectItem[] lstPosicion;
    private String selectedPosicion;
    private SelectItem[] lstTemporada;
    private String selectedTemporada;
    private boolean popupVisibleBuscarJugadores = false;
    private String descripcionNombreJugador;
    private List<JugadorBean> jugadores;
    
    private JugadorService jugadorServices;
    private ExamenMedicoService examenMedicoServices;
    private ExamenFisicoService examenFisicoServices;
    private SelectItem[] lstTipoExamenFisico;
    private String selectedTipoExamenFisico;
    private SelectItem[] lstCampeonato;
    private String selectedCampeonato;
    private SelectItem[] lstCiudad;
    private String selectedCiudad;
    private SelectItem[] lstTipoCancha;
    private String selectedTipoCancha;
    private SelectItem[] lstEquipoContrario;
    private String selectedEquipoContrario;
    private SelectItem[] lstLocalidad;
    private String selectedLocalidad;

    public BaseManageBean() {


        lstPosicion = new SelectItem[4];
        String label = "Delantero";// FacesUtils.getMessageResourceString("cbo.posicion.delantero");

        lstPosicion[0] = new SelectItem(Parametros.DELANTERO, label);


        label = "Arquero";// FacesUtils.getMessageResourceString("cbo.posicion.arquero");

        lstPosicion[1] = new SelectItem(Parametros.ARQUERO, label);


        label = "Defenza";// FacesUtils.getMessageResourceString("cbo.posicion.defensa");

        lstPosicion[2] = new SelectItem(Parametros.DEFENSA, label);


        label = "MedioCampo";// FacesUtils.getMessageResourceString("cbo.posicion.mediocampo");

        lstPosicion[3] = new SelectItem(Parametros.MEDIOCAMPO, label);


         lstTemporada = new SelectItem[4];
        String label1 = "TEMPORADA_2010-01";// FacesUtils.getMessageResourceString("cbo.temporada.temporada1");

        lstTemporada[0] = new SelectItem(Parametros.TEMPORADA1, label1);


        label1 = "TEMPORADA_2010-02";//FacesUtils.getMessageResourceString("cbo.temporada.temporada2");

        lstTemporada[1] = new SelectItem(Parametros.TEMPORADA2, label1);


        label1 = "TEMPORADA_2010-03";// FacesUtils.getMessageResourceString("cbo.temporada.temporada3");

        lstTemporada[2] = new SelectItem(Parametros.TEMPORADA3, label1);


        label1 = "TEMPORADA_2010-04";// FacesUtils.getMessageResourceString("cbo.temporada.temporada4");

        lstTemporada[3] = new SelectItem(Parametros.TEMPORADA4, label1);

        lstTipoExamenFisico = new SelectItem[4];
        String label2 = "fuerza";// FacesUtils.getMessageResourceString("cbo.tipoExamenFisico.fuerza");

        lstTipoExamenFisico[0] = new SelectItem(Parametros.FUERZA, label2);


        label2 = "resistencia";// FacesUtils.getMessageResourceString("cbo.tipoExamenFisico.resistencia");

        lstTipoExamenFisico[1] = new SelectItem(Parametros.RESISTENCIA, label2);


        label2 = "rapidez";// FacesUtils.getMessageResourceString("cbo.tipoExamenFisico.rapidez");

        lstTipoExamenFisico[2] = new SelectItem(Parametros.RAPIDEZ, label2);


        label2 = "salto";// FacesUtils.getMessageResourceString("cbo.tipoExamenFisico.salto");

        lstTipoExamenFisico[3] = new SelectItem(Parametros.SALTO, label2);



        lstCampeonato = new SelectItem[4];

        String label3 = FacesUtils.getMessageResourceString("cbo.Campeonato1");
        lstCampeonato[0] = new SelectItem(Parametros.CAMPEONATO1, label3);


        label3 = FacesUtils.getMessageResourceString("cbo.Campeonato2");
        lstCampeonato[1] = new SelectItem(Parametros.CAMPEONATO2, label3);


        label3 = FacesUtils.getMessageResourceString("cbo.Campeonato3");
        lstCampeonato[2] = new SelectItem(Parametros.CAMPEONATO3, label3);


        label3 = FacesUtils.getMessageResourceString("cbo.Campeonato4");
        lstCampeonato[3] = new SelectItem(Parametros.CAMPEONATO4, label3);



        lstCiudad = new SelectItem[4];

        String label4 = FacesUtils.getMessageResourceString("cbo.Ciudad1");
        lstCiudad[0] = new SelectItem(Parametros.CIUDAD1, label4);


        label4 = FacesUtils.getMessageResourceString("cbo.Ciudad2");
        lstCiudad[1] = new SelectItem(Parametros.CIUDAD2, label4);


        label4 = FacesUtils.getMessageResourceString("cbo.Ciudad3");
        lstCiudad[2] = new SelectItem(Parametros.CIUDAD3, label4);


        label4 = FacesUtils.getMessageResourceString("cbo.Ciudad4");
        lstCiudad[3] = new SelectItem(Parametros.CIUDAD4, label4);


        lstTipoCancha = new SelectItem[2];

        String label5 = FacesUtils.getMessageResourceString("cbo.tipoCancha1");
        lstTipoCancha[0] = new SelectItem(Parametros.TIPOCANCHA1, label5);


        label5 = FacesUtils.getMessageResourceString("cbo.tipoCancha2");
        lstTipoCancha[1] = new SelectItem(Parametros.TIPOCANCHA2, label5);


        lstEquipoContrario = new SelectItem[4];

        String label6 = FacesUtils.getMessageResourceString("cbo.lstEquipoContrario1");
        lstEquipoContrario[0] = new SelectItem(Parametros.EQUIPOCONTRARIO1, label6);


        label6 = FacesUtils.getMessageResourceString("cbo.lstEquipoContrario2");
        lstEquipoContrario[1] = new SelectItem(Parametros.EQUIPOCONTRARIO2, label6);


        label6 = FacesUtils.getMessageResourceString("cbo.lstEquipoContrario3");
        lstEquipoContrario[2] = new SelectItem(Parametros.EQUIPOCONTRARIO3, label6);


        label6 = FacesUtils.getMessageResourceString("cbo.lstEquipoContrario4");
        lstEquipoContrario[3] = new SelectItem(Parametros.EQUIPOCONTRARIO4, label6);

        lstLocalidad = new SelectItem[2];

        String label7 = FacesUtils.getMessageResourceString("cbo.localidad1");
        lstLocalidad[0] = new SelectItem(Parametros.LOCAL, label7);


        label7 = FacesUtils.getMessageResourceString("cbo.localidad2");
        lstLocalidad[1] = new SelectItem(Parametros.VISITANTE, label7);



    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public SelectItem[] getLstPosicion() {

        return lstPosicion;
    }

    public void setLstPosicion(SelectItem[] lstPosicion) {
        this.lstPosicion = lstPosicion;
    }

    public String getSelectedPosicion() {
        return selectedPosicion;
    }

    public void setSelectedPosicion(String selectedPosicion) {
        this.selectedPosicion = selectedPosicion;
    }

    public SelectItem[] getLstTemporada() {
        return lstTemporada;
    }

    public void setLstTemporada(SelectItem[] lstTemporada) {
        this.lstTemporada = lstTemporada;
    }

    public String getSelectedTemporada() {
        return selectedTemporada;
    }

    public void setSelectedTemporada(String selectedTemporada) {
        this.selectedTemporada = selectedTemporada;
    }

    public boolean isPopupVisibleBuscarJugadores() {
        return popupVisibleBuscarJugadores;
    }

    public void setPopupVisibleBuscarJugadores(boolean popupVisibleBuscarJugadores) {
        this.popupVisibleBuscarJugadores = popupVisibleBuscarJugadores;
    }

    public void closePopupBuscarJugador() {
        setPopupVisibleBuscarJugadores(false);
    }

    public void openPopupBuscarJugador() {
        setPopupVisibleBuscarJugadores(true);
    }

    public String getDescripcionNombreJugador() {
        return descripcionNombreJugador;
    }

    public void setDescripcionNombreJugador(String descripcionNombreJugador) {
        this.descripcionNombreJugador = descripcionNombreJugador;
    }

    public SelectItem[] getLstTipoExamenFisico() {
        return lstTipoExamenFisico;
    }

    public void setLstTipoExamenFisico(SelectItem[] lstTipoExamenFisico) {
        this.lstTipoExamenFisico = lstTipoExamenFisico;
    }

    public String getSelectedTipoExamenFisico() {
        return selectedTipoExamenFisico;
    }

    public void setSelectedTipoExamenFisico(String selectedTipoExamenFisico) {
        this.selectedTipoExamenFisico = selectedTipoExamenFisico;
    }

    public void btnBuscarJugadorActionPerformed(ActionEvent e) {
    }

    public List<JugadorBean> getJugadores() {

        return jugadores;
    }

    public void setJugadores(List<JugadorBean> jugadores) {

        this.jugadores = jugadores;

    }

    public ExamenMedicoService getExamenMedicoServices() {
        return examenMedicoServices;
    }

    public void setExamenMedicoServices(ExamenMedicoService examenMedicoServices) {
        this.examenMedicoServices = examenMedicoServices;
    }

    public JugadorService getJugadorServices() {
        return jugadorServices;
    }

    public void setJugadorServices(JugadorService jugadorServices) {
        this.jugadorServices = jugadorServices;

        setJugadores(jugadorServices.getJugadores());
    }

    public ExamenFisicoService getExamenFisicoServices() {
        return examenFisicoServices;
    }

    public void setExamenFisicoServices(ExamenFisicoService examenFisicoServices) {
        this.examenFisicoServices = examenFisicoServices;
    }

    public SelectItem[] getLstCampeonato() {
        return lstCampeonato;
    }

    public void setLstCampeonato(SelectItem[] lstCampeonato) {
        this.lstCampeonato = lstCampeonato;
    }

    public String getSelectedCampeonato() {
        return selectedCampeonato;
    }

    public void setSelectedCampeonato(String selectedCampeonato) {
        this.selectedCampeonato = selectedCampeonato;
    }

    public SelectItem[] getLstCiudad() {
        return lstCiudad;
    }

    public void setLstCiudad(SelectItem[] lstCiudad) {
        this.lstCiudad = lstCiudad;
    }

    public String getSelectedCiudad() {
        return selectedCiudad;
    }

    public void setSelectedCiudad(String selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    public SelectItem[] getLstTipoCancha() {
        return lstTipoCancha;
    }

    public void setLstTipoCancha(SelectItem[] lstTipoCancha) {
        this.lstTipoCancha = lstTipoCancha;
    }

    public String getSelectedTipoCancha() {
        return selectedTipoCancha;
    }

    public void setSelectedTipoCancha(String selectedTipoCancha) {
        this.selectedTipoCancha = selectedTipoCancha;
    }

    public SelectItem[] getLstEquipoContrario() {
        return lstEquipoContrario;
    }

    public void setLstEquipoContrario(SelectItem[] lstEquipoContrario) {
        this.lstEquipoContrario = lstEquipoContrario;
    }

    public String getSelectedEquipoContrario() {
        return selectedEquipoContrario;
    }

    public void setSelectedEquipoContrario(String selectedEquipoContrario) {
        this.selectedEquipoContrario = selectedEquipoContrario;
    }

    public SelectItem[] getLstLocalidad() {
        return lstLocalidad;
    }

    public void setLstLocalidad(SelectItem[] lstLocalidad) {
        this.lstLocalidad = lstLocalidad;
    }

    public String getSelectedLocalidad() {
        return selectedLocalidad;
    }

    public void setSelectedLocalidad(String selectedLocalidad) {
        this.selectedLocalidad = selectedLocalidad;
    }

  
}
