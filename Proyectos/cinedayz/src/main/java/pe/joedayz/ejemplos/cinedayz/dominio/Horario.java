package pe.joedayz.ejemplos.cinedayz.dominio;

public class Horario {
	
	String horarioCodigo;
	String horarioDescripcion;
	
	
	public Horario(String horarioCodigo, String horarioDescripcion) {
		super();
		this.horarioCodigo = horarioCodigo;
		this.horarioDescripcion = horarioDescripcion;
	}
	public String getHorarioCodigo() {
		return horarioCodigo;
	}
	public void setHorarioCodigo(String horarioCodigo) {
		this.horarioCodigo = horarioCodigo;
	}
	public String getHorarioDescripcion() {
		return horarioDescripcion;
	}
	public void setHorarioDescripcion(String horarioDescripcion) {
		this.horarioDescripcion = horarioDescripcion;
	}
	
}
