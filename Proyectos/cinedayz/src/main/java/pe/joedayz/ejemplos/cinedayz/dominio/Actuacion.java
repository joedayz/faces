package pe.joedayz.ejemplos.cinedayz.dominio;

public class Actuacion {
  Integer codigoActuacion;
  String codigoPelicula ;
  String codigoActor;
  Actor actor;
  Pelicula pelicula;
 public Actuacion()
 {
	  
 }
 
public Pelicula getPelicula() {
	return pelicula;
}

public void setPelicula(Pelicula pelicula) {
	this.pelicula = pelicula;
}

public Actor getActor() {
	return actor;
}


public void setActor(Actor actor) {
	this.actor = actor;
}


public String getCodigoActor() {
	return codigoActor;
}

  public void setCodigoActor(String codigoActor) {
	this.codigoActor = codigoActor;
 }


  public String getCodigoPelicula() {
	return codigoPelicula;
}

public void setCodigoPelicula(String codigoPelicula) {
	this.codigoPelicula = codigoPelicula;
}

public Integer getCodigoActuacion() {
	return codigoActuacion;
}
public void setCodigoActuacion(Integer codigoActuacion) {
	this.codigoActuacion = codigoActuacion;
}

  
}
