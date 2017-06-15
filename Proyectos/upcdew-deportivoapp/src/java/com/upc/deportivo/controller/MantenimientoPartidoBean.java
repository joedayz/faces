/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.controller;

import com.icesoft.faces.async.render.SessionRenderer;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.upc.deportivo.model.JugadorPartidoBean;
import com.upc.deportivo.model.PartidoBean;
import com.upc.deportivo.services.PartidoService;
import com.upc.deportivo.util.FacesUtils;
import com.upc.deportivo.view.BaseManageBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIParameter;
import javax.faces.event.PhaseId;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
public class MantenimientoPartidoBean extends BaseManageBean {

    private PartidoService partidoServices;
    private List<PartidoBean> partidos;
    private UIParameter nroPartidoEdit ;
    
    
    public  MantenimientoPartidoBean(){

        if(partidoServices!=null){
         setPartidos(partidoServices.obtenerPartidos());

        }
       
      }

    public List<PartidoBean> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<PartidoBean> partidos) {
        this.partidos = partidos;
    }
    
    
  
       public PartidoService getPartidoServices() {
        return partidoServices;
    }

    public void setPartidoServices(PartidoService partidoServices) {
        this.partidoServices = partidoServices;
        setPartidos(partidoServices.obtenerPartidos());
        
    }

    public UIParameter getNroPartidoEdit() {
        return nroPartidoEdit;
    }

    public void setNroPartidoEdit(UIParameter nroPartidoEdit) {
        this.nroPartidoEdit = nroPartidoEdit;
    }

    /**
 * Se define la accion del boton Consultar Partido
 */
     public String btnConsultaPartidoActionPerformed() {
        String codigo = nroPartidoEdit.getValue().toString();
       
       PartidoBean partido=partidoServices.obtenerPartido(codigo);
        
  
        if (partido != null) {
            
          HttpSession session=FacesUtils.getHttpSession(true);
          session.removeAttribute("partido");
          session.setAttribute("partido",partido);
            return "mantenimientoJugadorPartido";
        }

        return "";
    }


     public String  btnNuevoActionPerformed() {

         HttpSession session = FacesUtils.getHttpSession(true);
         PartidoBean p = new PartidoBean();
         p.setCodigoPartido("-1");
         p.setObjJugadorPartido(new ArrayList<JugadorPartidoBean>());
         session.removeAttribute("partido");
         session.setAttribute("partido", p);

          return "mantenimientoJugadorPartido";

    }

    
}
