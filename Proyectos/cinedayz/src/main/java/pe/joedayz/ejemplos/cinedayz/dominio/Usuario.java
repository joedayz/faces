package pe.joedayz.ejemplos.cinedayz.dominio;

import static org.junit.Assert.assertEquals;

public class Usuario extends Cliente{
	
	String unidad;
	String position;
	String telefono;	
	String tipodoc;
	String docidentity;
	String numeroDoc;
	//String usuarioTipo;//interno Externo
	//String usuarioStatus;
	String direccion;
	
	
	public Usuario() {
	
	}



	public Usuario(String codigo, String clave, String status, Integer intentos,String nombre, String apellido1,
			String apellido2,
			String strEmail,
			String unidad, String position, String telefono,   String tipodoc,
			String docidentity, String usuTipo,String usuStatus, String usuDirec, String strStatus, String numeroDoc ) {
		super(codigo,clave,intentos,nombre,apellido1,apellido2,strEmail,strStatus,usuTipo);
		this.unidad = unidad;
		this.position = position;
		this.telefono = telefono;		
		this.email=strEmail;
		this.tipodoc=tipodoc;
		this.docidentity = docidentity;	
		this.direccion=usuDirec;
		this.numeroDoc=numeroDoc;
	}
	
	
	
	public String getNumeroDoc() {
		return numeroDoc;
	}



	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getDocidentity() {
		return docidentity;
	}
	public void setDocidentity(String docidentity) {
		this.docidentity = docidentity;
	}
	public String getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

		
}
