package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.criterion.Expression;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;

public class PeliculaDAOTest {
	 private static ApplicationContext contextoSpring;
	    private static String peliculaCodigo;
	    
	    // 2. Programamos el m�todo setUpClass() que debe ejecutarse antes de los m�todos de prueba. Debe:
	    //   - Inicializar el contexto Spring para poner en memoria los objetos de persistencia ya definidos en los *Context.xml
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			// Esta sentencia inicializa el contexto Spring utilizando un arreglo de rutas del classpath que apuntan a los XML de configuraci�n
			System.out.println("Antes de Spring");
			contextoSpring = new ClassPathXmlApplicationContext(
	                    new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});
			System.out.println("Despues de Spring");
		}
		
		// 3. Programamos el m�todo de prueba para CREAR una reserva. La validaci�n ser� que el objeto creado no sea nulo.
		@Test
		public void testCrear() {
			System.out.println("Antes de crear");
			// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y "tutorDAO" que Spring ya carg� en memoria al inicializarse
	        PeliculaDAO peliculaDAO = (PeliculaDAO)contextoSpring.getBean("peliculaDAO");
	        
	        // En estas sentencias instanciamos un nuevo objeto Reserva con sus propiedades
	        Pelicula nuevoPelicula = new Pelicula();
	        nuevoPelicula.setCodigo("1901");
	        nuevoPelicula.setTitulo("Bora");
	        nuevoPelicula.setSubtitulo("Bora Bora 1970");
	        nuevoPelicula.setDescripcion("Kazakh TV talking head Borat is dispatched to the United States to report on the greatest country in the world. With a documentary crew in tow, Borat becomes more interested in locating and marrying Pamela Anderson.");
	        nuevoPelicula.setGenero("Romance");	        
	        nuevoPelicula.setPaisOrigen("USA");
	        nuevoPelicula.setPublObjetivo("Adultos");
	        nuevoPelicula.setTipoEmision("2D");
	        nuevoPelicula.setPoster("bora.gif");
	        nuevoPelicula.setMerchandize("T");
	        Pelicula peliculaCreado = peliculaDAO.crear(nuevoPelicula);
	        peliculaCodigo = peliculaCreado.getCodigo();
	        // Realizamos la validaci�n de prueba
	        assertNotNull(peliculaCodigo);
	        // Escribimos en consola el c�digo del alumno insertado en la BD
	        System.out.println("> Pelicula creada con c�digo: "+ peliculaCodigo);
		}
		
		@Test
		public void testObtener() {

			PeliculaDAO peliculaDAO = (PeliculaDAO) contextoSpring.getBean("peliculaDAO");

			Pelicula peliculaExistente = peliculaDAO.obtener("1900");

			assertNotNull(peliculaExistente);

			System.out.println("> Pelicula obtenida: "+ peliculaExistente.getCodigo());
		}
		
		@Test
		public void testModificar() {

			PeliculaDAO peliculaDAO = (PeliculaDAO) contextoSpring.getBean("peliculaDAO");
			Pelicula peliculaExistente = peliculaDAO.obtener("1902");
			peliculaExistente.setTitulo("*" + peliculaExistente.getTitulo());
			peliculaExistente.setSubtitulo("*" + peliculaExistente.getSubtitulo());
			peliculaExistente.setDescripcion("*" + peliculaExistente.getDescripcion());
			peliculaExistente.setGenero("*" + peliculaExistente.getGenero());
			peliculaExistente.setMerchandize("F");
			peliculaExistente.setPaisOrigen("*"+peliculaExistente.getPaisOrigen());
			peliculaExistente.setPoster("*"+peliculaExistente.getPoster());
			peliculaExistente.setPublObjetivo("*"+peliculaExistente.getPublObjetivo());
			peliculaExistente.setTipoEmision("*"+peliculaExistente.getTipoEmision());		
			
			Pelicula peliculaModificado = peliculaDAO.modificar(peliculaExistente);
			assertNotNull(peliculaModificado);
			System.out.println("> Pelicula modificado: "+ peliculaModificado.getCodigo());
		}

		@Test
		public void testEliminar() {
			PeliculaDAO peliculaDAO = (PeliculaDAO) contextoSpring.getBean("peliculaDAO");
			Pelicula peliculaExistente = peliculaDAO.obtener(peliculaCodigo);
			peliculaDAO.eliminar(peliculaExistente);
			Pelicula peliculaEliminado = peliculaDAO.obtener(peliculaCodigo);
			assertNull(peliculaEliminado);
			System.out.println("> Pelicula eliminado: "	+ peliculaExistente.getCodigo());
		}
			
		@Test
		public void testObtenerLista() {
			PeliculaDAO peliculaDAO = (PeliculaDAO) contextoSpring.getBean("peliculaDAO");
		    Busqueda busqueda = Busqueda.forClass(Pelicula.class); 
			busqueda.add(Expression.like("codigo", "19%"));
			busqueda.add(Expression.like("PublObjetivo", "f%"));
			List<Pelicula> peliculaLista = peliculaDAO.obtenerLista(busqueda);
			
			assertNotNull(peliculaLista);
			
			for (Pelicula pelicula : peliculaLista) {
				System.out.println("> Pelicula listado: " + pelicula.getCodigo() + "|"
						+ pelicula.getTitulo() + "|" + pelicula.getDescripcion());
			}
		}
	
}
