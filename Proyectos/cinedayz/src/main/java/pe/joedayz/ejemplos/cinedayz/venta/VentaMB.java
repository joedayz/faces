package pe.joedayz.ejemplos.cinedayz.venta;

import java.util.List;

import pe.joedayz.ejemplos.cinedayz.dominio.Asiento;
import pe.joedayz.ejemplos.cinedayz.dominio.DetCartelera;
import pe.joedayz.ejemplos.cinedayz.dominio.Local;
import pe.joedayz.ejemplos.cinedayz.dominio.Merchandize;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;
import pe.joedayz.ejemplos.cinedayz.dominio.Sala;
import pe.joedayz.ejemplos.cinedayz.registro.RegistroClienteMB;

public class VentaMB {
		
	//MerchandizeService merchandize;
	MerchandizeService merchandizeService;
	RegistroClienteMB registroClienteMB;
	Merchandize selectedMerchandize;	
	String selectedCodigoLocal;
	String selectedCodigoSala;
	
	String selectedCodigoPelicula;
	
	List<DetCartelera> carteleraDetalleLista;
	List<Asiento> asientoLista;
	List<Asiento> asientoVendidoLista;
		
	private DetCartelera selectedCartelera;
	private Asiento asientoSeleccionado;
	
	String clienteCodigo="asolissoli";	
	
	
	public List<Asiento> getAsientoVendidoLista() {
		return asientoVendidoLista;
	}

	public void setAsientoVendidoLista(List<Asiento> asientoVendidoLista) {
		this.asientoVendidoLista = asientoVendidoLista;
	}

	public Asiento getAsientoSeleccionado() {
		return asientoSeleccionado;
	}

	public void setAsientoSeleccionado(Asiento asientoSeleccionado) {
		this.asientoSeleccionado = asientoSeleccionado;
	}

	public DetCartelera getSelectedCartelera() {
		return selectedCartelera;
	}

	public void setSelectedCartelera(DetCartelera selectedCartelera) {
		this.selectedCartelera = selectedCartelera;
	}

	public List<Asiento> getAsientoLista() {
		return asientoLista;
	}

	public void setAsientoLista(List<Asiento> asientoLista) {
		this.asientoLista = asientoLista;
	}

	

	public String getSelectedCodigoPelicula() {
		return selectedCodigoPelicula;
	}

	public void setSelectedCodigoPelicula(String selectedCodigoPelicula) {
		this.selectedCodigoPelicula = selectedCodigoPelicula;
	}

	public List<DetCartelera> getCarteleraDetalleLista() {
		return carteleraDetalleLista;
	}

	public void setCarteleraDetalleLista(List<DetCartelera> carteleraDetalleLista) {
		this.carteleraDetalleLista = carteleraDetalleLista;
	}

	public String getSelectedCodigoSala() {
		return selectedCodigoSala;
	}

	public void setSelectedCodigoSala(String selectedCodigoSala) {
		this.selectedCodigoSala = selectedCodigoSala;
	}

	public String getSelectedCodigoLocal() {
		return selectedCodigoLocal;
	}

	public void setSelectedCodigoLocal(String selectedCodigoLocal) {
		this.selectedCodigoLocal = selectedCodigoLocal;
	}

	public List<Merchandize> getListaMerchandize()
	{
		List<Merchandize> merchandizeLista=merchandizeService.listarMerchandize(); 
			
		return merchandizeLista;
	}

	public List<Sala> getListaSala()
	{
		List<Sala> salaLista=merchandizeService.listarSalas(); 
			
		return salaLista;
	}

	
	
	public Merchandize getSelectedMerchandize() {
		return selectedMerchandize;
	}



	public void setSelectedMerchandize(Merchandize selectedMerchandize) {
		this.selectedMerchandize = selectedMerchandize;
	}



	public MerchandizeService getMerchandizeService() {
		return merchandizeService;
	}

	public void setMerchandizeService(MerchandizeService merchandizeService) {
		this.merchandizeService = merchandizeService;
	}
	
	public List<Local> getListadeLocal()
	{
		List<Local> locales = merchandizeService.listarLocales();
		return locales;
	}

	public List<Pelicula> getListadePelicula()
	{
		List<Pelicula> peliculaLista = merchandizeService.listarPelicula();
		return peliculaLista;
	}

	
	public String llamarCartelera(){
		 carteleraDetalleLista=merchandizeService.ubicarCartelera( selectedCodigoLocal,selectedCodigoSala,selectedCodigoPelicula );
		 return "";
	}
	
	public String llamarAsientos()
	{
        if (selectedCodigoSala!= null){
		//List<Asiento> asientoLista = merchandizeService.ubicarAsiento(selectedCodigoSala);
        //	return asientoLista;
          asientoLista = merchandizeService.ubicarAsiento(selectedCodigoSala,selectedCartelera);
		
        }
        return "";
	}
	public String venderAsiento(){
		if (asientoSeleccionado!=null){
		    asientoVendidoLista = merchandizeService.vendeAsientos(asientoSeleccionado);
		    //asientoVendidoLista.add(asiento);
		}
		return  "";
	}
	
	public String checkout(){
		
        
		//Cliente clienteEncontrado=registroClienteMB.getClienteEncontrado();		
		merchandizeService.grabaFactura(asientoVendidoLista, selectedCartelera,  clienteCodigo);
		return ""; 
	}
}
