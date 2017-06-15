package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.criterion.Expression;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Comentario;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;

public class ComentarioDAOTest {
	  private static ApplicationContext contextoSpring;
	    private static Integer comentarioCodigo;
	    
	    // 2. Programamos el m�todo setUpClass() que debe ejecutarse antes de los m�todos de prueba. Debe:
	    //   - Inicializar el contexto Spring para poner en memoria los objetos de persistencia ya definidos en los *Context.xml
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			// Esta sentencia inicializa el contexto Spring utilizando un arreglo de rutas del classpath que apuntan a los XML de configuraci�n
			System.out.println("Antes de Spring");
			contextoSpring =
	                new ClassPathXmlApplicationContext(
	                    new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});
			System.out.println("Despues de Spring");
		}
		
		@Test
		public void testCrear() {
			System.out.println("Antes de crear");
		
	        ComentarioDAO comentarioDAO = (ComentarioDAO)contextoSpring.getBean("comentarioDAO");
	  
	        Comentario nuevoComentario = new Comentario();
	        
	        Pelicula pelicula = new Pelicula();
	        pelicula.setCodigo("1900");
	        nuevoComentario.setPelicula(pelicula);
	        //nuevoComentario.setPeliculaCodigo("1900");
	        nuevoComentario.setDetalleComentario("divide it into three parts: ONE�yes as so many comments have already said");
	        nuevoComentario.setCodigoCliente("whitehorse");
	        Comentario comentarioCreado = comentarioDAO.crear(nuevoComentario);
	        comentarioCodigo = comentarioCreado.getCodigo();
	        // Realizamos la validaci�n de prueba
	        assertNotNull(comentarioCreado);
	        // Escribimos en consola el c�digo del alumno insertado en la BD
	        System.out.println("> Comentario creado con c�digo: "+ comentarioCodigo);
		}
	
		@Test
		public void testObtener() {

			ComentarioDAO comentarioDAO = (ComentarioDAO) contextoSpring.getBean("comentarioDAO");

			Comentario comentarioExistente = comentarioDAO.obtener(1);

			assertNotNull(comentarioExistente);

			System.out.println("> Comentario de Pelicula obtenido: "+ comentarioExistente.getDetalleComentario());
		}
		
		@Test
		public void testModificar() {

			ComentarioDAO comentarioDAO = (ComentarioDAO) contextoSpring.getBean("comentarioDAO");
			Comentario comentarioExistente = comentarioDAO.obtener(1);
			comentarioExistente.setDetalleComentario("*" +comentarioExistente.getDetalleComentario());
			
			Comentario comentarioModificado = comentarioDAO.modificar(comentarioExistente);
			assertNotNull(comentarioModificado);
			System.out.println("> Comentario de Pelicula modificado: "+ comentarioModificado.getCodigo());
		}
	/*
		@Test
		public void testEliminar() {
			ComentarioDAO comentarioDAO = (ComentarioDAO) contextoSpring.getBean("comentarioDAO");
			Comentario comentarioExistente = comentarioDAO.obtener(comentarioCodigo);
			comentarioDAO.eliminar(comentarioExistente);
			Comentario comentarioEliminado = comentarioDAO.obtener(comentarioCodigo);
			assertNull(comentarioEliminado);
			System.out.println("> comentario eliminado: "	+ comentarioExistente.getCodigo());
		}
		*/	
		@Test
		public void testObtenerLista() {
			ComentarioDAO comentarioDAO = (ComentarioDAO) contextoSpring.getBean("comentarioDAO");
		    //Busqueda busqueda = Busqueda.forClass(Comentario.class); 
			
		    pe.joedayz.ejemplos.cinedayz.core.Busqueda busqueda = pe.joedayz.ejemplos.cinedayz.core.Busqueda.forClass(Comentario.class);
			
			busqueda.add(Expression.like("detalleComentario", "%loved%"));
			busqueda.createCriteria("pelicula")	
			.add(Expression.like("codigo", "19%"));
						
			List<Comentario> comentarioLista = comentarioDAO.obtenerLista(busqueda);
			
			assertNotNull(comentarioLista);
			
			for (Comentario comentario : comentarioLista) {
				System.out.println("> Comentario listado: " + comentario.getCodigo() + "|"
						+ comentario.getPelicula().getTitulo() + "|" + comentario.getDetalleComentario());
			}
		}
		
}
