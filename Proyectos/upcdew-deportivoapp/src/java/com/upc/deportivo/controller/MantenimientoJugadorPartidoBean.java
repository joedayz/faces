/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.controller;

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.upc.deportivo.model.JugadorBean;
import com.upc.deportivo.model.JugadorPartidoBean;
import com.upc.deportivo.model.PartidoBean;
import com.upc.deportivo.services.JugadorPartidoService;
import com.upc.deportivo.util.FacesUtils;
import com.upc.deportivo.view.BaseManageBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/*
 * Se define los atributos que contiene la clase JugadorPartido
 */
public class MantenimientoJugadorPartidoBean extends BaseManageBean {

    private Date fechaPartido;
    private List<JugadorPartidoBean> jugadoresPartido;
    private JugadorPartidoService jugadorPartidoServices;
    private JugadorBean jugadorBean;
    private boolean allChecks;
    private int golesContra;
    private int golesFavor;
    private  PartidoBean   partidoBean
;
    private String codigoPartido;
    
    

    public MantenimientoJugadorPartidoBean() {

        jugadoresPartido=new ArrayList<JugadorPartidoBean>();
        HttpSession session=FacesUtils.getHttpSession(false);


        partidoBean=  (PartidoBean) session.getAttribute("partido");
        session.removeAttribute("partido");

           
        if(partidoBean!=null){
            mostrarInformacionPartido(partidoBean);

        }

        
        
    }
    
    public MantenimientoJugadorPartidoBean(PartidoBean partido) {
            
            
    }
 /**
 * Se define la accion del boton Grabar. Este iguala los datos ingresados
 * para ser enviados a la capa DAO
 */
    public boolean btnGrabarActionPerformed(ActionEvent e) {
        
           if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return true;
        }
        
        PartidoBean partido=new PartidoBean();
        partido.setCodigoPartido(getCodigoPartido());
        partido.setCiudad(getSelectedCiudad());
        partido.setEquipoContrario(getSelectedEquipoContrario());
        partido.setFechaPartido(getFechaPartido());
        partido.setTipoCancha(getSelectedTipoCancha());
        partido.setCodigoCampeonato(getSelectedCampeonato());
        partido.setObjJugadorPartido((ArrayList<JugadorPartidoBean>) getJugadoresPartido());
        partido.setLocalidad(getSelectedLocalidad());
        partido.setGolFavor(getGolesFavor());
        partido.setGolContra(getGolesContra());
       
      
          HttpSession session=FacesUtils.getHttpSession(false);

        partidoBean=jugadorPartidoServices.grabarPartidoJugador(partido);

        if(partidoBean.getCodigoPartido()!="-1"){
         FacesUtils.addErrorMessageFromResource("msg.info.grabarExito",null);
        }else{
         FacesUtils.addErrorMessageFromResource("msg.info.grabarError",null);
          }
        
        System.out.println("getGolContra"+partidoBean.getGolContra());
        session.setAttribute("partido", partidoBean);
         mostrarInformacionPartido(partidoBean);



        return true;
    }

    

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public JugadorPartidoService getJugadorPartidoServices() {
        return jugadorPartidoServices;
    }

    public void setJugadorPartidoServices(JugadorPartidoService jugadorPartidoServices) {
        this.jugadorPartidoServices = jugadorPartidoServices;
    }

    public void rowSelectionJugadorListener(RowSelectorEvent e) throws ServletException, IOException {

        if (e.getPhaseId() != PhaseId.INVOKE_APPLICATION) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return;
        }

        jugadorBean = getJugadorServices().obtenerJugador();

        JugadorPartidoBean jp = new JugadorPartidoBean();
        jp.setJugador(jugadorBean);
        jp.setNombreJugador(jugadorBean.getNombre());
        jp.setCodigo(jugadorBean.getCodigo());
        jp.setCodigoJugadorPartido("-1");
        getJugadoresPartido().add(jp);

        closePopupBuscarJugador();

    }

    public boolean isAllChecks() {
        return allChecks;
    }

    public void setAllChecks(boolean allChecks) {
        this.allChecks = allChecks;
    }
 /**
 * Elimina los Jugadores por Partido seleccionados
 */
    public boolean selectedCheck(ValueChangeEvent e) {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return true;
        }

        for (JugadorPartidoBean a : getJugadoresPartido()) {

            a.setSelectedEliminar(allChecks);

        }
        return true;
    }

    public List<JugadorPartidoBean> getJugadoresPartido() {
        return jugadoresPartido;
    }

    public void setJugadoresPartido(List<JugadorPartidoBean> jugadoresPartido) {
        this.jugadoresPartido = jugadoresPartido;
    }
 /**
 * Se define la accion del boton Eliminar
 */
    public void btnEliminarActionPerformed() {

        List<JugadorPartidoBean> temp = new ArrayList<JugadorPartidoBean>();
        for (JugadorPartidoBean a : getJugadoresPartido()) {

            if (!a.isSelectedEliminar()) {
                temp.add(a);
            }

        }

        getJugadoresPartido().clear();
        setJugadoresPartido(temp);

    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public PartidoBean getPartidoBean() {
        return partidoBean;
    }

    public void setPartidoBean(PartidoBean partidoBean) {
        this.partidoBean = partidoBean;
    }
    
     /**
 * Para mostrar la data del Partido
 */
    public void mostrarInformacionPartido(PartidoBean p){
    
        setCodigoPartido(p.getCodigoPartido());
        setSelectedCiudad(p.getCiudad());
        setSelectedEquipoContrario(p.getEquipoContrario());
        setFechaPartido(p.getFechaPartido() );
        setSelectedTipoCancha(p.getTipoCancha());
        setSelectedCampeonato(p.getCodigoCampeonato());
        setSelectedLocalidad(p.getLocalidad());
        setGolesFavor(p.getGolFavor());
        setGolesContra(p.getGolContra());
        setJugadoresPartido(p.getObjJugadorPartido());
        
    
    }

      public void btnRegresarActionPerformed(ActionEvent event) {

      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "regresar");

   }

    /**
     * @return the codigoPartido
     */
    public String getCodigoPartido() {
        return codigoPartido;
    }

    /**
     * @param codigoPartido the codigoPartido to set
     */
    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

}
