package pe.joedayz.ejemplos.cinedayz.cartelera;

import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Expression;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Cartelera;
import pe.joedayz.ejemplos.cinedayz.dominio.DetCartelera;
import pe.joedayz.ejemplos.cinedayz.dominio.Local;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;
import pe.joedayz.ejemplos.cinedayz.dominio.Sala;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.CarteleraDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.DetCarteleraDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.LocalDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.PeliculaDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.SalaDAO;

public class CarteleraService {
	CarteleraDAO carteleraDAO;
	PeliculaDAO peliculaDAO;
	DetCarteleraDAO detCarteleraDAO;
	SalaDAO salaDAO;
	LocalDAO localDAO;

	public void setLocalDAO(LocalDAO localDAO) {
		this.localDAO = localDAO;
	}

	public void setSalaDAO(SalaDAO salaDAO) {
		this.salaDAO = salaDAO;
	}

	public void setCarteleraDAO(CarteleraDAO carteleraDAO) {
		this.carteleraDAO = carteleraDAO;
	}

	public void setDetCarteleraDAO(DetCarteleraDAO detCarteleraDAO) {
		this.detCarteleraDAO = detCarteleraDAO;
	}


	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}

	public void mostrarCartelera2()
	{
		 Busqueda busqueda = Busqueda.forClass(Cartelera.class); 
			busqueda.add(Expression.eq("status", "V"));			
			List<Cartelera> carteleraLista = carteleraDAO.obtenerLista(busqueda);
			
			assertNotNull(carteleraLista);
			
			for (Cartelera cartelera : carteleraLista) {
				Pelicula pelicula = peliculaDAO.obtener(cartelera.getCodpelicula());
				String peliculaTitulo = pelicula.getTitulo();
				Integer cartCodigo = cartelera.getCarteleraCodigo();
				
				Busqueda busquedaDetCartelera = Busqueda.forClass(DetCartelera.class);
				busquedaDetCartelera.add(Expression.eq("carteleraCodigo",cartCodigo));
				
				List<DetCartelera> detcarteleraLista = detCarteleraDAO.obtenerLista(busquedaDetCartelera);
				assertNotNull(detcarteleraLista);	
				
				for (DetCartelera detCartelera : detcarteleraLista)
				{
					String horario = detCartelera.getHorario();
					Double precio = detCartelera.getPrecio();
				
					Sala sala = salaDAO.obtener(detCartelera.getSala().getCodigoSala()); 
					String salaNombre= sala.getNombreSala();
											
					Local local = localDAO.obtener(sala.getLocalCodigo());
					String localNombre= local.getLocalNombre();
					
				    System.out.println("> Cartelera listado: " + localNombre + "|"
						+ salaNombre + " | "+ peliculaTitulo+" | " + horario +" | "+
						DateFormat.getInstance().format(cartelera.getFechaIni())+							 
						 " | "+
						 DateFormat.getInstance().format(cartelera.getFechaFin())+ 
						 " | "+precio);
				}
			}

		
	}
	
	public void devuelveHorariodePelicula(Pelicula pelicula)
	{
	//respectivo horario.
		
	}
	public void informacionDetalladaxPelicula(Pelicula pelicula)
	{
	// mostrar informacion detallada del trailer, artista y otro tema de interes relacionado con la pelicula
			
	}
	
	
	public List<DetCartelera> mostrarCarteleraCompleta()
		{
		//Historia= el usuario registrado o no registrado puede consultar el detalle de una pelicula para ver un abstract
		//trailer, locales que lo dan y el respectivo horario.
		//De la lista desplegada lo enviara a otra pantalla donde se mostrara informacion detallada del trailer, artista y otro tema de interes relacionado con la pelicula
		pe.joedayz.ejemplos.cinedayz.core.Busqueda busqueda = pe.joedayz.ejemplos.cinedayz.core.Busqueda.forClass(DetCartelera.class);
		//Listar peliculas activas.
		busqueda.createCriteria("cartelera")	
		.add(Expression.eq("status", "V"));
		
		List<DetCartelera> detCarteleras = detCarteleraDAO.obtenerLista(busqueda);
		for (DetCartelera detCartelera : detCarteleras) {
			System.out.println("Local: " + detCartelera.getSala().getLocal().getLocalNombre());	
			System.out.println("Sala: " + detCartelera.getSala().getNombreSala());				
			System.out.println("Horario: " + detCartelera.getHorario());				
			System.out.println("Detalle Precio: " + detCartelera.getPrecioDetalle());
			System.out.println("Precio: " + detCartelera.getPrecio());
			System.out.println("Capacidad: " + detCartelera.getSala().getCapacidadSala());
			System.out.println("Pelicula:"+detCartelera.getCartelera().getPelicula().getTitulo());
		}
		return detCarteleras;
	}
	
	public List<DetCartelera> buscarCarteleraxFiltros(pe.joedayz.ejemplos.cinedayz.dominio.Busqueda busquedaCartelera) {
		//Historia= el usuario registrado o no registrado puede ver la Cartelera de modo que sepa las peliculas que estan vigentes.
		pe.joedayz.ejemplos.cinedayz.core.Busqueda busqueda = pe.joedayz.ejemplos.cinedayz.core.Busqueda.forClass(DetCartelera.class);
		busqueda.add(Expression.like("horario", "%"+busquedaCartelera.getHorarios()+"%"));
		if (busquedaCartelera.getPrecio() != null){
			busqueda.add(Expression.eq("precio", busquedaCartelera.getPrecio()));
		}
		if (busquedaCartelera.getTipoTarifa() !=null){
			busqueda.add(Expression.eq("precioDetalle", busquedaCartelera.getTipoTarifa()));
		}
		if (busquedaCartelera.getCine() !=null && busquedaCartelera.getCapacidadSala() !=null){
			busqueda.createCriteria("sala")
			.add(Expression.eq("codigoSala", busquedaCartelera.getCine()))
			.add(Expression.eq("capacidadSala", busquedaCartelera.getCapacidadSala()));
		}	
		
		List<DetCartelera> detCarteleras = detCarteleraDAO.obtenerLista(busqueda);

		for (DetCartelera detCartelera : detCarteleras) {
			System.out.println("Sala: " + detCartelera.getSala().getNombreSala());
			System.out.println("Horario: " + detCartelera.getHorario());
			System.out.println("Local: " + detCartelera.getSala().getLocal().getLocalNombre());
			System.out.println("Precio: " + detCartelera.getPrecio());
			System.out.println("Detalle Precio: " + detCartelera.getPrecioDetalle());
			System.out.println("Capacidad: " + detCartelera.getSala().getCapacidadSala());
		}
		return detCarteleras;
	}
	
	public void devuelveFunciones(Pelicula pelicula) {
		String codigoPelicula = pelicula.getCodigo();

		pe.joedayz.ejemplos.cinedayz.core.Busqueda filtro1 = pe.joedayz.ejemplos.cinedayz.core.Busqueda.forClass(Cartelera.class);
		filtro1.add(Expression.eq("status", "V"));
		filtro1.add(Expression.eq("codpelicula", codigoPelicula));
		List<Cartelera> carteleras = carteleraDAO.obtenerLista(filtro1);
		Integer codCartelera = carteleras.get(0).getCarteleraCodigo();

		DetCartelera lafuncion = detCarteleraDAO.obtener(codCartelera);

		pe.joedayz.ejemplos.cinedayz.core.Busqueda filtro = pe.joedayz.ejemplos.cinedayz.core.Busqueda.forClass(DetCartelera.class);

		filtro.add(Expression.eq("carteleraCodigo",
				lafuncion.getCarteleraCodigo()));

		Iterator<DetCartelera> funciones = detCarteleraDAO.obtenerLista(filtro)
				.iterator();

		while (funciones.hasNext()) {
			DetCartelera funcion = funciones.next();
			System.out.println("funciones = " + funcion.getHorario() + " | "
					+ funcion.getSalaCodigo());
		}

	}
	
}
