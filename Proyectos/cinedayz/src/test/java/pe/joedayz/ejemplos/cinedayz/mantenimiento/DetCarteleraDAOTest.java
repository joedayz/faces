package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.criterion.Expression;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.DetCartelera;

public class DetCarteleraDAOTest {

	private static ApplicationContext contextoSpring;
	 private static Integer detcarteleraCodigo;
	    
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
         DetCarteleraDAO detcarteleraDAO = (DetCarteleraDAO)contextoSpring.getBean("detcarteleraDAO");
        
        
        DetCartelera nuevoDetCartelera = new DetCartelera();	
        nuevoDetCartelera.setCarteleraCodigo(8);
        nuevoDetCartelera.setSalaCodigo("00003");
        nuevoDetCartelera.setHorario("8:00pm-10:00pm");
        nuevoDetCartelera.setPrecio(15.0);
        nuevoDetCartelera.setPrecioDetalle("Adulto");
        
        DetCartelera detcarteleraCreado = detcarteleraDAO.crear(nuevoDetCartelera);
        detcarteleraCodigo = detcarteleraCreado.getDetalleCarteleraCodigo();
       
        assertNotNull(detcarteleraCreado);	       
        System.out.println("> Cartelera Detalle creada con c�digo: "+ detcarteleraCodigo.toString());
	} 
	
	@Test
	public void testObtener() {

		DetCarteleraDAO detcarteleraDAO = (DetCarteleraDAO) contextoSpring.getBean("detcarteleraDAO");

		DetCartelera detcarteleraExistente = detcarteleraDAO.obtener(detcarteleraCodigo);

		assertNotNull(detcarteleraExistente);
		System.out.println("> Cartelera obtenida: "+ detcarteleraExistente.getDetalleCarteleraCodigo());
	}

	@Test
	public void testModificar() {
		DetCarteleraDAO detcarteleraDAO = (DetCarteleraDAO) contextoSpring.getBean("detcarteleraDAO");
		DetCartelera detcarteleraExistente = detcarteleraDAO.obtener(5);
		detcarteleraExistente.setCarteleraCodigo(detcarteleraExistente.getCarteleraCodigo());		
		detcarteleraExistente.setSalaCodigo(detcarteleraExistente.getSalaCodigo());
		detcarteleraExistente.setHorario("*"+detcarteleraExistente.getHorario());
		detcarteleraExistente.setPrecio(detcarteleraExistente.getPrecio()+1);
		detcarteleraExistente.setPrecioDetalle("*"+detcarteleraExistente.getPrecioDetalle());
		
		
		DetCartelera carteleraModificado = detcarteleraDAO.modificar(detcarteleraExistente);
		assertNotNull(carteleraModificado);
		System.out.println("> Detalle Cartelera modificado: "+ carteleraModificado.getDetalleCarteleraCodigo());
	}
 
	/*
	@Test
	public void testEliminar() {
		DetCarteleraDAO detcarteleraDAO = (DetCarteleraDAO) contextoSpring.getBean("detcarteleraDAO");
		DetCartelera detcarteleraExistente = detcarteleraDAO.obtener(detcarteleraCodigo);
		detcarteleraDAO.eliminar(detcarteleraExistente);
		DetCartelera carteleraEliminado = detcarteleraDAO.obtener(detcarteleraCodigo);
		assertNull(carteleraEliminado);
		System.out.println("> Detalle de Cartelera eliminado: "	+ detcarteleraExistente.getDetalleCarteleraCodigo());
	}
*/
	
	@Test
	public void testObtenerLista() {
		DetCarteleraDAO detcarteleraDAO = (DetCarteleraDAO) contextoSpring.getBean("detcarteleraDAO");
	    Busqueda busqueda = Busqueda.forClass(DetCartelera.class); 
		busqueda.add(Expression.like("horario", "6:00pm-8.00pm"));			
		List<DetCartelera> detcarteleraLista = detcarteleraDAO.obtenerLista(busqueda);
		
		assertNotNull(detcarteleraLista);
		
		for (DetCartelera detcartelera : detcarteleraLista) {
			System.out.println("> Detalle Cartelera listado: " + detcartelera.getSalaCodigo()+" | "+detcartelera.getHorario() + "|"
					+ detcartelera.getPrecioDetalle() + "|" + detcartelera.getPrecio());
		}
	}

		
	
}
