package pe.joedayz.ejemplos.cinedayz.dominio;

public class DetCartelera {
	Integer detalleCarteleraCodigo;
	Integer carteleraCodigo;
	String  salaCodigo;
	Sala sala;
	String horario;
	Double precio;
	String precioDetalle;
	Cartelera cartelera;
	
	public DetCartelera() {
		
	}
	
	
	public Cartelera getCartelera() {
		return cartelera;
	}


	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
	}


	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Integer getDetalleCarteleraCodigo() {
		return detalleCarteleraCodigo;
	}
	public void setDetalleCarteleraCodigo(Integer detalleCarteleraCodigo) {
		this.detalleCarteleraCodigo = detalleCarteleraCodigo;
	}
	public Integer getCarteleraCodigo() {
		return carteleraCodigo;
	}
	public void setCarteleraCodigo(Integer carteleraCodigo) {
		this.carteleraCodigo = carteleraCodigo;
	}
	public String getSalaCodigo() {
		return salaCodigo;
	}
	public void setSalaCodigo(String salaCodigo) {
		this.salaCodigo = salaCodigo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getPrecioDetalle() {
		return precioDetalle;
	}
	public void setPrecioDetalle(String precioDetalle) {
		this.precioDetalle = precioDetalle;
	}
	
	
}
