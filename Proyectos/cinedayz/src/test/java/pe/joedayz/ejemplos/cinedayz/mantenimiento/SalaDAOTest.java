package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Sala;

public class SalaDAOTest {
	 private static ApplicationContext contextoSpring;
	 private static String salaCodigo;
	    
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
	        SalaDAO salaDAO = (SalaDAO)contextoSpring.getBean("salaDAO");      
	        
	        Sala nuevoSala = new Sala();	
	        nuevoSala.setCodigoSala("00004");	        
	        nuevoSala.setNombreSala("Sala 4");
	        nuevoSala.setCapacidadSala(150);
	        nuevoSala.setLocalCodigo("00001");
	        nuevoSala.setDescripcionSala("Sala especial para eventos");	        
	        Sala salaCreado = salaDAO.crear(nuevoSala);
	        salaCodigo = salaCreado.getCodigoSala();
	       
	        assertNotNull(salaCreado);	       
	        System.out.println("> Sala creada con c�digo: "+ salaCodigo.toString());
		}
		
		@Test
		public void testObtener() {
	    	
			SalaDAO salaDAO = (SalaDAO)contextoSpring.getBean("salaDAO");	        
	        Sala salaExistente = salaDAO.obtener("00002");	        
	        assertNotNull(salaExistente);	        
	        System.out.println("> Sala obtenido: "+ salaExistente.getNombreSala());
		}
	
	 
}
