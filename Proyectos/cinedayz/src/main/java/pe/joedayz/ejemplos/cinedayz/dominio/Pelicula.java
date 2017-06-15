package pe.joedayz.ejemplos.cinedayz.dominio;



public class Pelicula {
	String codigo;	
	String titulo;
	String descripcion;
	String genero;
	String subtitulo;
	String paisOrigen;
	String publObjetivo;
	String tipoEmision;	
	String merchandize;
	String poster;
	
	String peliculaLongitud;
	String peliculaDirector;
	String peliculaEscritor;
	String peliculaIdioma;
	
	public Pelicula(){

	}
	

	public Pelicula(String codigo, String titulo, String descripcion,
		String genero, String subtitulo, String paisOrigen,
		String publObjetivo, String tipoEmision, String merchandize, String poster) {
	
	this.codigo = codigo;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.genero = genero;
	this.subtitulo = subtitulo;
	this.paisOrigen = paisOrigen;
	this.publObjetivo = publObjetivo;
	this.tipoEmision = tipoEmision;
	this.merchandize = merchandize;
	this.poster = poster;
}

	
	public String getPeliculaLongitud() {
		return peliculaLongitud;
	}


	public void setPeliculaLongitud(String peliculaLongitud) {
		this.peliculaLongitud = peliculaLongitud;
	}


	public String getPeliculaDirector() {
		return peliculaDirector;
	}


	public void setPeliculaDirector(String peliculaDirector) {
		this.peliculaDirector = peliculaDirector;
	}


	public String getPeliculaEscritor() {
		return peliculaEscritor;
	}


	public void setPeliculaEscritor(String peliculaEscritor) {
		this.peliculaEscritor = peliculaEscritor;
	}


	public String getPeliculaIdioma() {
		return peliculaIdioma;
	}


	public void setPeliculaIdioma(String peliculaIdioma) {
		this.peliculaIdioma = peliculaIdioma;
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getPublObjetivo() {
		return publObjetivo;
	}

	public void setPublObjetivo(String publObjetivo) {
		this.publObjetivo = publObjetivo;
	}

	public String getTipoEmision() {
		return tipoEmision;
	}

	public void setTipoEmision(String tipoEmision) {
		this.tipoEmision = tipoEmision;
	}

	public String getMerchandize() {
		return merchandize;
	}

	public void setMerchandize(String merchandize) {
		this.merchandize = merchandize;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	
	
	
	
		
}