/*
 * MenuBarBean
 *
 * Creado el 26/04/2009, 03:07:52 AM
 */
package com.upc.deportivo.view;

import com.icesoft.faces.component.menubar.MenuItem;
import java.util.ArrayList;
import java.util.List;
import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Ricardo Rodríguez
 */
public final class MenuBarBean {

   private final Logger logger = Logger.getLogger(MenuBarBean.class.getName());
   private List<MenuItem> menuModel;
   /**
    * orientation of the menubar ("horizontal" or "vertical")
    */
   private String orientation;

   public MenuBarBean() {
      orientation = "horizontal";
      int indexOf = -1;

    //  UsuarioBean usuarioBean = FacesUtils.getManagedBean( ManageBeanNames.BEAN_USUARIO, UsuarioBean.class);
    

      menuModel = new ArrayList<MenuItem>();

    
      MenuItem menuItem = null;

 

         menuItem = new MenuItem();
         menuItem.setValue("Mantenimientos");
       //  menuItem.setLink("listadoGuia.iface");
         menuModel.add(menuItem);

         MenuItem jugador = new MenuItem();
         jugador.setValue("Jugador");
         jugador.setLink("../mantenimiento/mantenimientoJugador.iface");
         menuItem.getChildren().add(jugador);

        MenuItem examenMedico = new MenuItem();
         examenMedico.setValue("Examen Medico");
         examenMedico.setLink("../mantenimiento/mantenimientoExamenMedico.iface");
         menuItem.getChildren().add(examenMedico);

         MenuItem examenFisico = new MenuItem();
         examenFisico.setValue("Examen Fisico");
         examenFisico.setLink("../mantenimiento/mantenimientoExamenFisico.iface");
         menuItem.getChildren().add(examenFisico);
         

         
//         MenuItem examenMedico = new MenuItem();
//         examenMedico.setValue("Examen Fisico");
//         examenMedico.setLink("examenFisico.iface");
//         menuItem.getChildren().add(examenFisico);

        




         menuItem = new MenuItem();
         menuItem.setValue("Campeonato");
        // menuItem.setLink("listadoGuia.iface");
          menuModel.add(menuItem);

         MenuItem partido = new MenuItem();
         partido.setValue("Partido");
         // partido.setLink("../mantenimiento/mantenimientoJugadorPartido.iface");
         partido.setLink("../mantenimiento/mantenimientoPartido.iface");
         menuItem.getChildren().add(partido);



         menuItem = new MenuItem();
         menuItem.setValue("Estadistica");
          menuItem.setLink("../reportes/resultadoPartido.iface");
      //   menuItem.setLink("estaditica.iface");
         menuModel.add(menuItem);

    


      menuItem = new MenuItem();
      menuItem.setValue("salir");
      menuItem.setLink("../../welcomeServlet?accion=salir");
      menuModel.add(menuItem);
   }

   /**
    * Get the orientation of the menu ("horizontal" or "vertical")
    *
    * @return the orientation of the menu
    */
   public String getOrientation() {
      return orientation;
   }

   /**
    * Set the orientation of the menu ("horizontal" or "vertical").
    *
    * @param orientation the new orientation of the menu
    */
   public void setOrientation(String orientation) {
      this.orientation = orientation;
   }

   /**
    * @return the menuModel
    */
   public List getMenuModel() {
      return menuModel;
   }

   public String goListadoValorizacion(){
      if (logger.isDebugEnabled()) {
         logger.debug("Estoy en el listado Valorización");
      }
      return "valorizacion";
   }
   
   public void goPedidosPendientes() {
      if (logger.isDebugEnabled()) {
         logger.debug("en goPedidosPendientes");
      }
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "pedidosPendientes");
   }



   private MethodExpression createActionMethodExpression(String expression) {
      MethodExpression action= FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createMethodExpression(
              FacesContext.getCurrentInstance().getELContext(),expression,
              String.class, new Class[]{});
      return action;
   }
}
