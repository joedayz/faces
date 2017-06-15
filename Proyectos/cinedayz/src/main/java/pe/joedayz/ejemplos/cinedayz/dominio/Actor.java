package pe.joedayz.ejemplos.cinedayz.dominio;

public class Actor {

	String codigoActor;
	String nombre;
	String apellido;
	String url;
	
	public Actor(){

	}
	
	public String getCodigoActor() {
		return codigoActor;
	}

	public void setCodigoActor(String codigoActor) {
		this.codigoActor = codigoActor;
	}

	public Actor(String codigo, String nombre, String apellido,String url) {
	
		this.codigoActor = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.url = url;
	}
	
//	public static Actor creaActor(String strcodigo, String strnombre,String strApellido) {
//		return new Actor( strcodigo, strnombre, strApellido );				
//	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
