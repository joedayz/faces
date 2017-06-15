package pe.joedayz.ejemplos.cinedayz.cartelera;

import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Expression;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Actuacion;
import pe.joedayz.ejemplos.cinedayz.dominio.Cartelera;
import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.Comentario;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ActuacionDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.CarteleraDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ClienteDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ComentarioDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.PeliculaDAO;

public class PeliculaService {
	PeliculaDAO peliculaDAO;
	ClienteDAO clienteDAO;
	CarteleraDAO carteleraDAO;
	ComentarioDAO comentarioDAO;
	ActuacionDAO actuacionDAO;
	
	
	
	
	


	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public void setActuacionDAO(ActuacionDAO actuacionDAO) {
		this.actuacionDAO = actuacionDAO;
	}

	public void setComentarioDAO(ComentarioDAO comentarioDAO) {
		this.comentarioDAO = comentarioDAO;
	}

	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}

	public void setCarteleraDAO(CarteleraDAO carteleraDAO) {
		this.carteleraDAO = carteleraDAO;
	}

	public void listarPeliculasVigentes()throws Exception
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Pelicula.class);
		List<Pelicula> peliculaLista = peliculaDAO.obtenerLista(busqueda);
		
		for (Pelicula pelicula : peliculaLista) {
			 String pelcodigo = pelicula.getCodigo();
			 
			 Busqueda filtro = Busqueda.forClass(Cartelera.class);
			 filtro.add(Expression.eq("codpelicula", pelcodigo));
			 filtro.add(Expression.eq("status", "V"));
			 	
		 	
			 Iterator<Cartelera> carteleras = carteleraDAO.obtenerLista(filtro).iterator();
				
			 	while(carteleras.hasNext()) {
			 		Cartelera cartelera = carteleras.next();	
			 		if (cartelera.getCodpelicula().equalsIgnoreCase(pelcodigo)){
			 			pelcodigo=null;
			 			peliculaInformacionBasica(pelicula);
			 	
			 		}	    
			 	}
			 	
		}
	}
	
	public List<Pelicula> listarPelicula() 
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Pelicula.class);
		List<Pelicula> peliculaLista = peliculaDAO.obtenerLista(busqueda);
		return peliculaLista;
	}
	
	

	
	public void listarPeliculasNoVigentes()throws Exception
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Pelicula.class);
		List<Pelicula> peliculaLista = peliculaDAO.obtenerLista(busqueda);
		
		for (Pelicula pelicula : peliculaLista) {
			 String pelcodigo = pelicula.getCodigo();
			 
			 Busqueda filtro = Busqueda.forClass(Cartelera.class);
			 filtro.add(Expression.eq("codpelicula", pelcodigo));
			 filtro.add(Expression.eq("status", "V"));
			 	
			 List<Cartelera> carteleras = carteleraDAO.obtenerLista(filtro);
			 if (carteleras.size()==0){
				 System.out.println("pelicula no Vigente "+ pelicula.getPoster());
			 }
			 
			 	
		}
	}
	
	
	public Pelicula mostrarUnaPeliculaEscritura(Pelicula pelicula)throws Exception{
    //mandatory search for codigo de pelicula en tabla pelicula 
		Busqueda filtro1 = Busqueda.forClass(Pelicula.class);
		filtro1.add(Expression.eq("titulo", pelicula.getTitulo()));

		List<Pelicula> peliculas= peliculaDAO.obtenerLista(filtro1);
		if (peliculas.size()>0){
			Pelicula element = peliculas.get(0);
			
			Busqueda filtro = Busqueda.forClass(Cartelera.class);
			filtro.add(Expression.eq("pelicula", element));
			filtro.add(Expression.eq("status", "V"));
			
			List<Cartelera> carteleras = carteleraDAO.obtenerLista(filtro);
			if (carteleras.size()>0){
				Pelicula peliculaEncontrado= peliculaDAO.obtener(element.getCodigo());
				peliculaInformacionBasica(peliculaEncontrado);
				
				return(peliculaEncontrado);		
			}else{
	
				throw new Exception ("Pelicula no esta en cartelera: " + element.getPoster() );		
			}			
		}else{
			
		 throw new Exception ("Pelicula no existe... " );
		
		}
			
	}	
	
	void mostrarInfoBasicaUnaPeliculaActiva(){}
	
	public void mostrarInfoCompletaPeliculaActiva(Pelicula pelicula){
		System.out.println("Pelicula informacion completa: " + pelicula.getTitulo()+" | "+
				pelicula.getGenero()+" | "+
	    			pelicula.getPaisOrigen()+" | "+pelicula.getTipoEmision()+" | "+pelicula.getDescripcion());

	}
	
	
	public void peliculaInformacionBasica( Pelicula pelicula)
	{
		
		
		System.out.println("Pelicula en cartelera activa: " + pelicula.getCodigo()+" | "+
 	    			pelicula.getTitulo()+" | "+pelicula.getPublObjetivo());
	
	}
	
	public void mostrarInfoPeliculaNoActiva(Pelicula pelicula)
	{
		System.out.println("Pelicula no en cartelera : " + pelicula.getPoster());

	}
	
	public List<Actuacion> peliculaActores(Pelicula peliculaBuscada){
		Busqueda filtro = Busqueda.forClass(Actuacion.class);
		
		filtro.createCriteria("pelicula")	
		.add(Expression.eq("codigo", peliculaBuscada.getCodigo()));
				
		List<Actuacion> actuacion = actuacionDAO.obtenerLista(filtro);
				
		for (Actuacion peliculaActor : actuacion) {				
			System.out.println("Actor nombre  : "+ peliculaActor.getActor().getNombre());
			System.out.println("Actor apellido: "+ peliculaActor.getActor().getApellido());
			System.out.println("Actor url: "     + peliculaActor.getActor().getUrl());
		}
		return actuacion;
	}
	
	public  List<Actuacion> peliculaTrailerAbstract(Pelicula peliculaBuscada){
		Busqueda filtro = Busqueda.forClass(Actuacion.class);
		filtro.getFirstResult();
		filtro.createCriteria("pelicula")	
		.add(Expression.eq("codigo", peliculaBuscada.getCodigo()));
				
		List<Actuacion> actuacion = actuacionDAO.obtenerLista(filtro);
				
		for (Actuacion peliculaTrailer : actuacion) {
				
			System.out.println("Titulo  : "+ peliculaTrailer.getPelicula().getTitulo());
			System.out.println("Genero  : "+ peliculaTrailer.getPelicula().getGenero() );
		    System.out.println("Abstract: "+ peliculaTrailer.getPelicula().getDescripcion() );
			System.out.println("Pais    : "+ peliculaTrailer.getPelicula().getPaisOrigen());
		}
		return actuacion;
	}
	

	public Pelicula convierteaPelicula(String codigoPelicula){
	    //mandatory search for codigo de pelicula en tabla pelicula 
			Busqueda filtro1 = Busqueda.forClass(Pelicula.class);
			filtro1.add(Expression.eq("codigo", codigoPelicula));
			filtro1.getFirstResult();
			List<Pelicula> peliculas= peliculaDAO.obtenerLista(filtro1);
		
			Pelicula element = peliculas.get(0);
			return(element);			
						
		}	

	public Pelicula convierteTituloaPelicula(String tituloPelicula){
	    //mandatory search for codigo de pelicula en tabla pelicula 
			Busqueda filtro1 = Busqueda.forClass(Pelicula.class);
			filtro1.add(Expression.like("titulo", tituloPelicula));
			filtro1.getFirstResult();
			List<Pelicula> peliculas= peliculaDAO.obtenerLista(filtro1);
		
			Pelicula element = peliculas.get(0);
			return(element);			
						
		}	

	
	public List<Actuacion>iraunaPeliculaActuacion(String codigoPelicula)
	{
		List <Actuacion> actuacion = mostrarUnaPeliculaActuacion(codigoPelicula);
		
		for (Actuacion peliculaTrailer : actuacion) {
			
		    System.out.println(peliculaTrailer.getPelicula().getTitulo());
		    System.out.println(peliculaTrailer.getPelicula().getPaisOrigen());
		    System.out.println(peliculaTrailer.getActor().getNombre());
		    System.out.println(peliculaTrailer.getActor().getApellido());
		    }
		
		return actuacion;
	}
	
	public Pelicula iraunaPelicula(String codigoPelicula)
	{	    	
	    Pelicula pelicula = mostrarUnaPelicula(codigoPelicula);		
	    
//	    for (Pelicula peliculaTrailer : pelicula) {
	
	//    System.out.println(peliculaTrailer.getTitulo());
	  //  System.out.println(peliculaTrailer.getPaisOrigen());
	//    }
	    return pelicula;
	    
	    //return pelis;
	}
	
	public void devuelveComentarioPelicula(Pelicula peliculaBuscada)
	{	
		Busqueda filtro = Busqueda.forClass(Comentario.class);
		
		filtro.createCriteria("pelicula")	
		.add(Expression.eq("codigo", peliculaBuscada.getCodigo()));
		
		List<Comentario> comentario = comentarioDAO.obtenerLista(filtro);
		for (Comentario comentarios : comentario) {
			System.out.println(comentarios.getCliente().getNombre()+": "+ comentarios.getDetalleComentario());
			
		}
		
	}
	
	public Pelicula mostrarUnaPelicula(String codigoPelicula){
	    //mandatory search for codigo de pelicula en tabla pelicula 
//			Busqueda filtro1 = Busqueda.forClass(Pelicula.class);
	//		filtro1.add(Expression.eq("codigo", codigoPelicula));
		//	filtro1.getFirstResult();
			//List<Pelicula> peliculas= peliculaDAO.obtenerLista(filtro1);
			
			Pelicula pelicula= peliculaDAO.obtener(codigoPelicula);
			//if (peliculas.size()>0){
			//	Pelicula element = peliculas.get(0);
			//	return(element);
				return pelicula;
							
			//}else{
				
			// throw new Exception ("Pelicula no existe... " );
			
		//	}
				
		}	

	
	public List<Actuacion> mostrarUnaPeliculaActuacion(String codigoPelicula){
	    //mandatory search for codigo de pelicula en tabla pelicula 
			Busqueda filtro1 = Busqueda.forClass(Actuacion.class);
			filtro1.add(Expression.eq("codigo", codigoPelicula));
			filtro1.getFirstResult();
			List<Actuacion> actuacion = actuacionDAO.obtenerLista(filtro1);
			
				Actuacion element = actuacion.get(0);
			
				return actuacion;
							
			
				
		}	
	
	public void guardarComentario(String codigoPelicula, String  codigoCliente, String comentariotext)
	{
		Pelicula pelicula = peliculaDAO.obtener(codigoPelicula);
		Cliente cliente = clienteDAO.obtener(codigoCliente);
		Comentario comentario = new Comentario(); 
	comentario.setCliente(cliente);
	comentario.setPelicula(pelicula);
	comentario.setDetalleComentario(comentariotext);
			comentarioDAO.crear(comentario);
	}

	
}
