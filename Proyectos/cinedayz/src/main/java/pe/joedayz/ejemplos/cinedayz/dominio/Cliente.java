package pe.joedayz.ejemplos.cinedayz.dominio;

import java.util.Date;

public class Cliente {
	
	Date fechaRegistro;
	String codigo;
	String nombre;
	String apellido1;
	String apellido2;
	String tipoUsuario;	
	String clave;	
	String email;
	Integer intentos=0; 
	String status;
	
	
	public Cliente(){

	}
	
	

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = new Date();
	}

	public Cliente(String codigo, String clave, Integer intentos,String nombre, String apellido1,String apellido2, String strEmail,String strStatus,String strTipoUsuario)
	{
		this.codigo=codigo;
		this.clave=clave;
		this.tipoUsuario=strTipoUsuario;
		this.intentos=intentos;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.email=strEmail;
		this.status = strStatus;
	}
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getClave() {
		return clave;
	}
	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

}
