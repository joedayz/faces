package pe.joedayz.ejemplos.cinedayz.dominio;

public class Comentario {
  Integer codigo;
  String  peliculaCodigo;
  String  detalleComentario;
  String  codigoCliente;
  Pelicula pelicula;
  Cliente cliente;
  public Comentario()
  {
	  
  }
  
  
  
public Cliente getCliente() {
	return cliente;
}



public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}



public Pelicula getPelicula() {
	return pelicula;
}


public void setPelicula(Pelicula pelicula) {
	this.pelicula = pelicula;
}


public Integer getCodigo() {
	return codigo;
}
public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}
public String getPeliculaCodigo() {
	return peliculaCodigo;
}
public void setPeliculaCodigo(String peliculaCodigo) {
	this.peliculaCodigo = peliculaCodigo;
}
public String getDetalleComentario() {
	return detalleComentario;
}
public void setDetalleComentario(String detalleComentario) {
	this.detalleComentario = detalleComentario;
}
public String getCodigoCliente() {
	return codigoCliente;
}
public void setCodigoCliente(String codigoCliente) {
	this.codigoCliente = codigoCliente;
}
  
  
}
