/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.view;
import com.upc.deportivo.model.JugadorBean;
import com.upc.deportivo.util.FacesUtils;
import com.upc.deportivo.util.Parametros;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
/**
 *
 * @author USUARIO
 */
public class UsuarioBean   {

    
    private static final long serialVersionUID = 1;

   private String usuario;
   private String clave;
   private String nombre;
  

   public UsuarioBean() {
  
      usuario = "";
      clave = "";
   
   }
   
   
   public String getUsuario() {
      return usuario;
   }

   /**
    * @param usuario el usuario para ser asignado
    */
   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   /**
    * @return el clave
    */
   public String getClave() {
      return clave;
   }

   /**
    * @param clave el clave para ser asignado
    */
   public void setClave(String clave) {
      this.clave = clave;
   }

  
   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();
      
      return sb.toString();
   }

 

   public String btnIngresarActionPerformed() {
       
       
 
      
       return "cambioClave";
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
