package pe.joedayz.ejemplos.cinedayz.dominio;

import java.text.DateFormat;
import java.util.Date;


public class Cartelera {
	Integer carteleraCodigo;
	String codpelicula;   
    Date fechaIni;
    Date fechaFin;
    String status; //Vigente, Futura, PAsada
    Pelicula pelicula;
    
	
public Cartelera() {
	
	}


public Pelicula getPelicula() {
	return pelicula;
}


public void setPelicula(Pelicula pelicula) {
	this.pelicula = pelicula;
}


public Cartelera(String codpelicula,  Date fechaIni, Date fechaFin, Integer carteleraCodigo, 
		String cartTipo) {
		
		this.codpelicula = codpelicula;				
		this.fechaIni=fechaIni;
		this.fechaFin=fechaFin;
		this.carteleraCodigo=carteleraCodigo;
		this.status=cartTipo;
		
	}


	
	//public static Cartelera creaCartelera(String codpelicula,  String strhorario,String fecIni,String fecFin,String cartCodigo, String cartTipo, String carPrecioDet,Integer precio) {
		
	//	return new Cartelera(cartCodigo,codpelicula, strhorario, fecIni,fecFin,cartTipo, carPrecioDet, precio);
//	}
    
	public Integer getCarteleraCodigo() {
	return carteleraCodigo;
}

public void setCarteleraCodigo(Integer carteleraCodigo) {
	this.carteleraCodigo = carteleraCodigo;
}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Date getFechaIni() {
				
		 return fechaIni;

	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
		
		
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	public String getCodpelicula() {
		return codpelicula;
	}
	public void setCodpelicula(String codpelicula) {
		this.codpelicula = codpelicula;
	}
	

	
}
