package pe.joedayz.ejemplos.cinedayz.dominio;

public class Busqueda {
	String cine;
	String artista;
	String horarios;
	String tipoPelicula;
	String subtitulos;
	String pais;
	String publicoObjetivo;
	String tipoEmision;
	String tipoTarifa;
	Integer Precio;
	Integer capacidadSala;
	public Busqueda()
	{
		
	}
	
	
	public Integer getCapacidadSala() {
		return capacidadSala;
	}


	public void setCapacidadSala(Integer capacidadSala) {
		this.capacidadSala = capacidadSala;
	}


	public String getTipoTarifa() {
		return tipoTarifa;
	}


	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}


	public Integer getPrecio() {
		return Precio;
	}


	public void setPrecio(Integer precio) {
		Precio = precio;
	}


	public String getCine() {
		return cine;
	}
	public void setCine(String cine) {
		this.cine = cine;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public String getTipoPelicula() {
		return tipoPelicula;
	}
	public void setTipoPelicula(String tipoPelicula) {
		this.tipoPelicula = tipoPelicula;
	}
	public String getSubtitulos() {
		return subtitulos;
	}
	public void setSubtitulos(String subtitulos) {
		this.subtitulos = subtitulos;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPublicoObjetivo() {
		return publicoObjetivo;
	}
	public void setPublicoObjetivo(String publicoObjetivo) {
		this.publicoObjetivo = publicoObjetivo;
	}
	public String getTipoEmision() {
		return tipoEmision;
	}
	public void setTipoEmision(String tipoEmision) {
		this.tipoEmision = tipoEmision;
	}
	
}
