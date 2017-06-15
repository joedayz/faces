package pe.joedayz.ejemplos.cinedayz.cartelera;

import java.util.Date;
import java.util.List;

import pe.joedayz.ejemplos.cinedayz.dominio.Actuacion;
import pe.joedayz.ejemplos.cinedayz.dominio.DetCartelera;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;

public class CarteleraListaMB {
    private Pelicula selectedPelicula;
	PeliculaService peliculaService;	
	CarteleraService carteleraService;
	String selectedCodigoPelicula;
	
	private Pelicula peliculaSeleccionada;
	String tituloPelicula;
	String comentarioPelicula;
	String clienteCodigo="asolissoli";
	
	
	
	
	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}

	public String getComentarioPelicula() {
		return comentarioPelicula;
	}

	public void setComentarioPelicula(String comentarioPelicula) {
		this.comentarioPelicula = comentarioPelicula;
	}

	public String getSelectedCodigoPelicula() {
		return selectedCodigoPelicula;
	}

	public void setSelectedCodigoPelicula(String selectedCodigoPelicula) {
		this.selectedCodigoPelicula = selectedCodigoPelicula;
	}

	public void setPeliculaService(PeliculaService peliculaService) {
		this.peliculaService = peliculaService;
	}

	public void setCarteleraService(CarteleraService carteleraService) {
		this.carteleraService = carteleraService;
	}

	String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Date fecha;	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String registrar() {
		System.out.println("Ok...");
		this.nombre = this.nombre + " !!! " + this.getFecha();
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("El oso Yogui");
		try {
			Pelicula resultado = peliculaService.mostrarUnaPeliculaEscritura(pelicula);
			this.nombre = resultado.getCodigo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public List<DetCartelera> getCartelera(){
		//Busqueda busqueda = new Busqueda();
		//busqueda.setHorarios("6");
		
		//List<DetCartelera> detCarteleras = carteleraService.buscarCarteleraxFiltros(busqueda);
		
		List<DetCartelera> detCarteleras = carteleraService.mostrarCarteleraCompleta();
		
		System.out.println("i:"+detCarteleras.size());
		for (DetCartelera d : detCarteleras)
			System.out.println("h:"+d.getHorario());
		return detCarteleras;
				
	}

	public Pelicula getPeliculaSeleccionada() {
		return peliculaSeleccionada;
	}

	public void setPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
		this.peliculaSeleccionada = peliculaSeleccionada;
	}

    
    
    
	public Pelicula getSelectedPelicula() {
		return selectedPelicula;
	}

	public void setSelectedPelicula(Pelicula selectedPelicula) {
		this.selectedPelicula = selectedPelicula;
	}

	
	public List<Pelicula> getListadePeliculas()
	{
		List<Pelicula> peliculas = peliculaService.listarPelicula();
		return peliculas;
	}
	

	
	public List<Actuacion> getListaPeliculaActores()
	{
		
		List<Actuacion> actuacion = null;
		if (peliculaSeleccionada != null) {
			System.out.println("peliculaSeleccionada = "+peliculaSeleccionada.getTitulo());
			actuacion = peliculaService.peliculaActores(peliculaSeleccionada);
		}
		return actuacion;
	}
	
	public void convierteStringaPelicula(){
		 peliculaSeleccionada = peliculaService.convierteaPelicula(selectedCodigoPelicula);
		//return peliculaSeleccionada;
		System.out.println("selectedCodigoPelicula-->Titulo ="+peliculaSeleccionada.getTitulo());
	} 
	
	
	public Pelicula getUnaPeliculaDetalle() {
		
		convierteStringaPelicula();		
		System.out.println("selectedCodigoPelicula---- "+selectedCodigoPelicula);
	      Pelicula unaPelicula= peliculaService.iraunaPelicula(selectedCodigoPelicula);
		
		return unaPelicula;
	}

	public Pelicula getUnaPeliculaDetalledelTitulo() {
		
		peliculaSeleccionada = peliculaService.convierteTituloaPelicula(tituloPelicula);		
		System.out.println("selectedCodigoPelicula---- "+tituloPelicula);
	    Pelicula unaPelicula= peliculaService.iraunaPelicula(peliculaSeleccionada.getCodigo());
		
		return unaPelicula;
	}

	
	public List<Actuacion> getUnaPeliculaDetalleActuacion(){
		convierteStringaPelicula();
		List<Actuacion> unaPelicula=peliculaService.iraunaPeliculaActuacion(selectedCodigoPelicula);
		return unaPelicula;
	}
	
	public String guardarComentarioPelicula(){
		System.out.println("llege");
		peliculaService.guardarComentario(selectedCodigoPelicula, clienteCodigo, comentarioPelicula); 
	
		
		return "";
	}
	
	
}