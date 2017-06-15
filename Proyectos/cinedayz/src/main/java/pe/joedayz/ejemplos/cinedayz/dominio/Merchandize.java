package pe.joedayz.ejemplos.cinedayz.dominio;

public class Merchandize {
	String merchandizeCodigo;
	String pelcodigo;
	String merchandizeTipoProducto;
	String merchandizeDetalle;
	String merchandizeFoto;
	Double merchandizePrecio;
	Pelicula pelicula;
	Integer merchandizeCantidad;
	
	public Merchandize(){

	}
	
	
	
	public Integer getMerchandizeCantidad() {
		return merchandizeCantidad;
	}



	public void setMerchandizeCantidad(Integer merchandizeCantidad) {
		this.merchandizeCantidad = merchandizeCantidad;
	}



	public String getMerchandizeCodigo() {
		return merchandizeCodigo;
	}



	public void setMerchandizeCodigo(String merchandizeCodigo) {
		this.merchandizeCodigo = merchandizeCodigo;
	}



	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	

	public String getPelcodigo() {
		return pelcodigo;
	}
	public void setPelcodigo(String pelcodigo) {
		this.pelcodigo = pelcodigo;
	}
	public String getMerchandizeTipoProducto() {
		return merchandizeTipoProducto;
	}
	public void setMerchandizeTipoProducto(String merchandizeTipoProducto) {
		this.merchandizeTipoProducto = merchandizeTipoProducto;
	}
	public String getMerchandizeDetalle() {
		return merchandizeDetalle;
	}
	public void setMerchandizeDetalle(String merchandizeDetalle) {
		this.merchandizeDetalle = merchandizeDetalle;
	}
	public String getMerchandizeFoto() {
		return merchandizeFoto;
	}
	public void setMerchandizeFoto(String merchandizeFoto) {
		this.merchandizeFoto = merchandizeFoto;
	}
	public Double getMerchandizePrecio() {
		return merchandizePrecio;
	}
	public void setMerchandizePrecio(Double merchandizePrecio) {
		this.merchandizePrecio = merchandizePrecio;
	}
	
	
    
}
