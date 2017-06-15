package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Cartelera;

public class CarteleraDAOTest {
	 private static ApplicationContext contextoSpring;
	 private static Integer carteleraCodigo;
	    
	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 
	contextoSpring =  new ClassPathXmlApplicationContext(
	                  new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});			
		}
	 
		@Test
		public void testCrear() {
			System.out.println("Antes de crear");
			// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y "tutorDAO" que Spring ya carg� en memoria al inicializarse
	        CarteleraDAO carteleraDAO = (CarteleraDAO)contextoSpring.getBean("carteleraDAO");      
	        
	        Cartelera nuevoCartelera = new Cartelera();	
	        nuevoCartelera.setCodpelicula("1901");
	        nuevoCartelera.setFechaIni(new Date());
	        nuevoCartelera.setFechaFin( new Date());
	        nuevoCartelera.setStatus("V");
	        Cartelera carteleraCreado = carteleraDAO.crear(nuevoCartelera);
	        carteleraCodigo = carteleraCreado.getCarteleraCodigo();
	       
	        assertNotNull(carteleraCreado);	       
	        System.out.println("> Cartelera creada con c�digo: "+ carteleraCodigo.toString());
		} 
	 
		@Test
		public void testObtener() {

			CarteleraDAO carteleraDAO = (CarteleraDAO) contextoSpring.getBean("carteleraDAO");

			Cartelera carteleraExistente = carteleraDAO.obtener(1);

			assertNotNull(carteleraExistente);
			System.out.println("> Cartelera obtenida: "+ carteleraExistente.getCarteleraCodigo());
		}

		@Test
		public void testModificar() {
			CarteleraDAO carteleraDAO = (CarteleraDAO) contextoSpring.getBean("carteleraDAO");
			Cartelera carteleraExistente = carteleraDAO.obtener(1);
			carteleraExistente.setCodpelicula( carteleraExistente.getCodpelicula());
			
			carteleraExistente.setFechaIni( new Date());
			carteleraExistente.setFechaFin( new Date());
			carteleraExistente.setStatus(carteleraExistente.getStatus());
			
			Cartelera carteleraModificado = carteleraDAO.modificar(carteleraExistente);
			assertNotNull(carteleraModificado);
			System.out.println("> Cartelera modificado: "+ carteleraModificado.getCarteleraCodigo());
		}
		
		@Test
		public void testEliminar() {
			CarteleraDAO carteleraDAO = (CarteleraDAO) contextoSpring.getBean("carteleraDAO");
			Cartelera carteleraExistente = carteleraDAO.obtener(carteleraCodigo);
			carteleraDAO.eliminar(carteleraExistente);
			Cartelera carteleraEliminado = carteleraDAO.obtener(carteleraCodigo);
			assertNull(carteleraEliminado);
			System.out.println("> Cartelera eliminado: "	+ carteleraExistente.getCodpelicula());
		}
		
		@Test
		public void testObtenerLista() {
			CarteleraDAO carteleraDAO = (CarteleraDAO) contextoSpring.getBean("carteleraDAO");
		    Busqueda busqueda = Busqueda.forClass(Cartelera.class); 
		//	busqueda.add(Expression.like("status", "V"));			
			List<Cartelera> carteleraLista = carteleraDAO.obtenerLista(busqueda);
			
			assertNotNull(carteleraLista);
			
			for (Cartelera cartelera : carteleraLista) {
				System.out.println("> Cartelera listado: " + cartelera.getCodpelicula() + "|"
						+ cartelera.getCarteleraCodigo() + "|" + cartelera.getStatus());
			}
		}
	
		
		
		
}
