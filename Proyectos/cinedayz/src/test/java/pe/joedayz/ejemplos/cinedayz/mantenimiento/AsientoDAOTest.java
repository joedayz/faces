package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Asiento;
import pe.joedayz.ejemplos.cinedayz.dominio.Sala;

public class AsientoDAOTest {
	   private static ApplicationContext contextoSpring;
	    private static String asientoCodigo;
	    
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.out.println("Antes de Spring");
			contextoSpring =
	                new ClassPathXmlApplicationContext(
	                    new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});
			System.out.println("Despues de Spring");
		}
		
		// 3. Programamos el m�todo de prueba para CREAR una reserva. La validaci�n ser� que el objeto creado no sea nulo.
		@Test
		public void testCrear() {
			System.out.println("Antes de crear");			
	        AsientoDAO asientoDAO = (AsientoDAO)contextoSpring.getBean("asientoDAO");
	        // En estas sentencias instanciamos un nuevo objeto Reserva con sus propiedades
	     
	       for  (Integer i =1; i<31;i++){
	    	  
	        Asiento nuevoAsiento = new Asiento();     
	        nuevoAsiento.setAsiento_status("Available");     
	        Sala nuevoSala = new Sala();
	        nuevoSala.setCodigoSala("00001");
	        nuevoAsiento.setSala(nuevoSala);
	        Asiento asientoCreado = asientoDAO.crear(nuevoAsiento);
	       
	        asientoCodigo = asientoCreado.getAsiento_numero();
	        assertNotNull(asientoCreado);	       
	        System.out.println("> Asient creada con c�digo: "+ asientoCodigo);
	       }	
	    }	
}
