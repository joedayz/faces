package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Merchandize;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;


public class MerchandizeDAOTest  {
	 private static ApplicationContext contextoSpring;
	 private static String merchandizeCodigo;
	    
	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 
	contextoSpring =  new ClassPathXmlApplicationContext(
	                  new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});			
	
	 }
	 
	@Test 
	public void testListarMerchandize()
	{
	    MerchandizeDAO merchandizeDAO = (MerchandizeDAO)contextoSpring.getBean("merchandizeDAO");      
	    
	}
	@Test
		public void testCrear() {
			System.out.println("Antes de crear");
			// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y "tutorDAO" que Spring ya carg� en memoria al inicializarse
	        MerchandizeDAO merchandizeDAO = (MerchandizeDAO)contextoSpring.getBean("merchandizeDAO");      
	        
	        Merchandize nuevoMerchandize = new Merchandize();	
	        nuevoMerchandize.setMerchandizeCodigo("00006");	        
	        nuevoMerchandize.setMerchandizeDetalle("Wimpy Kid- The last straw");
	        nuevoMerchandize.setMerchandizeFoto("wimpybook3.jpg");
	        nuevoMerchandize.setMerchandizePrecio(12.2);
	        nuevoMerchandize.setMerchandizeTipoProducto("Libros");
	        
	        Pelicula pelicula =new Pelicula();
	        pelicula.setCodigo("1909");
	        nuevoMerchandize.setPelicula(pelicula);
	        
	        Merchandize merchandizeCreado = merchandizeDAO.crear(nuevoMerchandize);
	        merchandizeCodigo = merchandizeCreado.getMerchandizeCodigo();
	       
	        assertNotNull(merchandizeCreado);	       
	        System.out.println("> Merchandize creada con c�digo: "+ merchandizeCodigo);
		}

}
