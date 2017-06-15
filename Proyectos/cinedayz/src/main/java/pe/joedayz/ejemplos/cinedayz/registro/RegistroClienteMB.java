package pe.joedayz.ejemplos.cinedayz.registro;

import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.Usuario;
 

public class RegistroClienteMB {
ClienteService clienteService;
String usuario;
String clave;

String nombre;
String apellido1;
String apellido2;
String email_adress;

public Usuario usuarioEncontrado;
public Cliente clienteEncontrado;

String clienteCodigo;
String clienteClave;



public Cliente getClienteEncontrado() {
	return clienteEncontrado;
}
public void setClienteEncontrado(Cliente clienteEncontrado) {
	this.clienteEncontrado = clienteEncontrado;
}
public String getClienteCodigo() {
	return clienteCodigo;
}
public void setClienteCodigo(String clienteCodigo) {
	this.clienteCodigo = clienteCodigo;
}
public String getClienteClave() {
	return clienteClave;
}
public void setClienteClave(String clienteClave) {
	this.clienteClave = clienteClave;
}
public Usuario getUsuarioEncontrado() {
	return usuarioEncontrado;
}
public void setUsuarioEncontrado(Usuario usuarioEncontrado) {
	this.usuarioEncontrado = usuarioEncontrado;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getClave() {
	return clave;
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
public String getEmail_adress() {
	return email_adress;
}
public void setEmail_adress(String email_adress) {
	this.email_adress = email_adress;
}
public void setClienteService(ClienteService clienteService) {
	this.clienteService = clienteService;
}

public String registrar() {
	System.out.println("Ok...");
	
	Cliente cliente = new Cliente();
	cliente.setNombre(this.nombre);
	cliente.setApellido1(this.apellido1);
	cliente.setApellido2(this.apellido2);
	cliente.setEmail(this.email_adress);
	try {
		Cliente resultado = clienteService.crearCodigoCliente(cliente);
		clienteService.registrar(resultado);
		this.nombre = resultado.getCodigo();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "";
}

  public void autenticaCliente(){
	  clienteEncontrado = clienteService.autenticarCliente(clienteCodigo, clienteClave);
  }

  public void autentica() {  

	   usuarioEncontrado = clienteService.autenticarAdmin(usuario, clave);
	  System.out.println("usuarioEncontrado "+usuarioEncontrado.getApellido1() );
	  //FacesContext context = FacesContext.getCurrentInstance();  
	           
	  //context.addMessage(null, new FacesMessage("Successful", "Hello "+usuario));  
	    
	  }  

}
 