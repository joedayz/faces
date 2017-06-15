/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.controller;

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.upc.deportivo.model.JugadorBean;
import com.upc.deportivo.services.JugadorImplement;
import com.upc.deportivo.services.JugadorService;
import com.upc.deportivo.view.BaseManageBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletException;
/*
 * Se define los atributos que contiene la clase Jugador
 */
public class MantenimientoJugadorBean extends BaseManageBean {

    private String codigo;
    private String telefono;
    private String mensaje;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String contrato;
    private boolean allChecks;
    private Date fecha;
    private JugadorBean jugadorBean;
  

    public MantenimientoJugadorBean() {
        System.out.println("AQUI SI");
   
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
 /**
 * Se define la accion del boton Ingresar. Este iguala los datos ingresados
 * para ser enviados a la capa DAO
 */
    public void btnIngresarActionPerformed() {


        jugadorBean = new JugadorBean();
      
        jugadorBean.setTelefono(telefono);
        jugadorBean.setNombre(nombre);
        jugadorBean.setApellidoPaterno(apellidoPaterno);
        jugadorBean.setApellidoMaterno(apellidoMaterno);
        jugadorBean.setDireccion(direccion);
        jugadorBean.setContrato(contrato);
        jugadorBean.setSelectedEliminar(false);
        jugadorBean.setSelectedModificar(false);
        jugadorBean.setFecha(fecha);
        jugadorBean.setPosicion(getSelectedPosicion());
        setJugadores((ArrayList<JugadorBean>) getJugadorServices().agregarJugador(jugadorBean));

    }
 /**
 * Para limpiar la ventana de ingreso de datos del Jugador
 */
    public void btnlimpiarActionPerformed() {

        
      
        codigo = "";
        telefono = "";
        mensaje = "";
        nombre = "";
        contrato = "";
        apellidoPaterno = "";
        apellidoMaterno = "";
        direccion = "";

    }
 /**
 * Elimina los Jugadores seleccionados
 */
    public boolean selectedCheck(ValueChangeEvent e) {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return true;
        }

        for (JugadorBean a : getJugadores()) {

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
        setJugadores((ArrayList<JugadorBean>) getJugadorServices().eliminarJugador());


    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public boolean isAllChecks() {
        return allChecks;
    }

    public void setAllChecks(boolean allChecks) {
        this.allChecks = allChecks;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 /**
 * Selecciona al jugador, busca sus datos y finalmente los muestra
 * en el Controller
 */
    public void rowSelectionListener(RowSelectorEvent e) throws ServletException, IOException {

        if (!e.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
        }

        jugadorBean = getJugadorServices().obtenerJugador();
        mostrarInformacionJugador(jugadorBean);

    }
 /**
 * Para mostrar la data del Jugador
 */
    public void mostrarInformacionJugador(JugadorBean jugador) {

        if (jugador != null) {
            setCodigo(jugador.getCodigo());
            setTelefono(jugador.getTelefono());
            setNombre(jugador.getNombre());
            setApellidoPaterno(jugador.getApellidoPaterno());
            setApellidoMaterno(jugador.getApellidoMaterno());
            setContrato(jugador.getContrato());
            setDireccion(jugador.getDireccion());
            setFecha(jugador.getFecha());
            setSelectedPosicion(jugador.getPosicion());
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

        jugadorBean = new JugadorBean();
        jugadorBean.setCodigo(codigo);
        jugadorBean.setTelefono(telefono);
        jugadorBean.setNombre(nombre);
        jugadorBean.setApellidoPaterno(apellidoPaterno);
        jugadorBean.setApellidoMaterno(apellidoMaterno);
        jugadorBean.setDireccion(direccion);
        jugadorBean.setContrato(contrato);
        jugadorBean.setSelectedEliminar(false);
        jugadorBean.setSelectedModificar(false);
        jugadorBean.setFecha(fecha);
        jugadorBean.setPosicion(getSelectedPosicion());
        setJugadores(getJugadorServices().modificarJugador(jugadorBean));



    }
    
    
   

}
