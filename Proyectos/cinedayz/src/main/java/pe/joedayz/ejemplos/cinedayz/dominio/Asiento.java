package pe.joedayz.ejemplos.cinedayz.dominio;

public class Asiento {
String asiento_numero;
String sala_codigo;
String asiento_status;
Sala sala;
Integer asiento_codigo;
DetCartelera detCartelera;


public Asiento() {
	
	// TODO Auto-generated constructor stub
}



public String getAsiento_numero() {
	return asiento_numero;
}



public void setAsiento_numero(String asiento_numero) {
	this.asiento_numero = asiento_numero;
}



public DetCartelera getDetCartelera() {
	return detCartelera;
}



public void setDetCartelera(DetCartelera detCartelera) {
	this.detCartelera = detCartelera;
}



public Integer getAsiento_codigo() {
	return asiento_codigo;
}


public void setAsiento_codigo(Integer asiento_codigo) {
	this.asiento_codigo = asiento_codigo;
}


public Sala getSala() {
	return sala;
}

public void setSala(Sala sala) {
	this.sala = sala;
}


public String getSala_codigo() {
	return sala_codigo;
}
public void setSala_codigo(String sala_codigo) {
	this.sala_codigo = sala_codigo;
}
public String getAsiento_status() {
	return asiento_status;
}
public void setAsiento_status(String asiento_status) {
	this.asiento_status = asiento_status;
}
	

}
