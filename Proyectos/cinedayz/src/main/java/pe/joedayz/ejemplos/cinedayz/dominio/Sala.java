package pe.joedayz.ejemplos.cinedayz.dominio;

public class Sala {

	String codigoSala;	
	String nombreSala;
	Integer capacidadSala;
	String descripcionSala;
	String localCodigo;
	Local local;
	
	public Sala()
	{
		
	}
	
	
	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}


	public String getCodigoSala() {
		return codigoSala;
	}
	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}
	public String getNombreSala() {
		return nombreSala;
	}
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}
	public Integer getCapacidadSala() {
		return capacidadSala;
	}
	public void setCapacidadSala(Integer capacidadSala) {
		this.capacidadSala = capacidadSala;
	}
	public String getDescripcionSala() {
		return descripcionSala;
	}
	public void setDescripcionSala(String descripcionSala) {
		this.descripcionSala = descripcionSala;
	}
	public String getLocalCodigo() {
		return localCodigo;
	}
	public void setLocalCodigo(String localCodigo) {
		this.localCodigo = localCodigo;
	}
	
}
