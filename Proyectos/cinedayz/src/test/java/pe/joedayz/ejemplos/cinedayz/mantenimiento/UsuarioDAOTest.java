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
import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.Usuario;

public class UsuarioDAOTest {

	   private static ApplicationContext contextoSpring;
	    private static String usuarioCodigo;
	    
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
		
		// 3. Programamos el m�todo de prueba para CREAR una reserva. La validaci�n ser� que el objeto creado no sea nulo.
		@Test
		public void testCrear() {
			System.out.println("Antes de crear");
			// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y "tutorDAO" que Spring ya carg� en memoria al inicializarse
	        UsuarioDAO usuarioDAO = (UsuarioDAO)contextoSpring.getBean("usuarioDAO");
	        // En estas sentencias instanciamos un nuevo objeto Reserva con sus propiedades
	        Usuario nuevoUsuario = new Usuario();	        
	        nuevoUsuario.setCodigo("u4127282015");
	        nuevoUsuario.setClave("u4127282015");
	        nuevoUsuario.setNombre("cmeade");
	        nuevoUsuario.setApellido1("cmeade");
	        nuevoUsuario.setApellido2("connie");
	        nuevoUsuario.setEmail("rmejia@upc.edu.pe");
	        nuevoUsuario.setTipoUsuario("I");
	        nuevoUsuario.setStatus("B"); 
	        nuevoUsuario.setTipodoc("DNI");
	        nuevoUsuario.setDocidentity("09684275");
	        nuevoUsuario.setUnidad("Ventas");
	        nuevoUsuario.setPosition("Cashier");
	        nuevoUsuario.setTelefono("6672987");
	        nuevoUsuario.setDireccion("4th Avenue 4058");
	        nuevoUsuario.setIntentos(0);
	        Usuario usuarioCreado = usuarioDAO.crear(nuevoUsuario);
	        
	        usuarioCodigo = usuarioCreado.getCodigo();	        
	        assertNotNull(usuarioCreado);	        
	        System.out.println("> Reserva creada con c�digo: "+ usuarioCodigo);
		}
		
		@Test
		public void testObtener() {
	    	
	        UsuarioDAO usuarioDAO = (UsuarioDAO)contextoSpring.getBean("usuarioDAO");	        
	        Usuario usuarioExistente = usuarioDAO.obtener("u4127282015");	        
	        assertNotNull(usuarioExistente);	        
	        System.out.println("> Usuario obtenido: "+usuarioExistente.getCodigo());
		}

		@Test
		public void testModificar() {

			UsuarioDAO usuarioDAO = (UsuarioDAO)contextoSpring.getBean("usuarioDAO");
			Usuario usuarioExistente = usuarioDAO.obtener("u4127282015");
			usuarioExistente.setNombre("@" + usuarioExistente.getNombre());
			usuarioExistente.setApellido1("@" + usuarioExistente.getApellido1());
			usuarioExistente.setApellido2("@" + usuarioExistente.getApellido2());
			usuarioExistente.setEmail("@" + usuarioExistente.getEmail());
			usuarioExistente.setStatus("A");
			usuarioExistente.setIntentos(usuarioExistente.getIntentos()+1);
			usuarioExistente.setDireccion("@"+usuarioExistente.getDireccion());
			usuarioExistente.setUnidad("@"+usuarioExistente.getUnidad());
			usuarioExistente.setPosition("@"+usuarioExistente.getPosition());
			usuarioExistente.setTelefono(usuarioExistente.getTelefono());		
			usuarioExistente.setTipodoc("*"+usuarioExistente.getTipodoc());
			usuarioExistente.setDocidentity("*"+usuarioExistente.getDocidentity());
		
			Usuario usuarioModificado = usuarioDAO.modificar(usuarioExistente);
			assertNotNull(usuarioModificado);
			System.out.println("> Usuario modificado: "+ usuarioModificado.getCodigo());
		}
		
		@Test
		public void testEliminar() {
			UsuarioDAO usuarioDAO = (UsuarioDAO) contextoSpring.getBean("usuarioDAO");
			Usuario usuarioExistente = usuarioDAO.obtener(usuarioCodigo);
			usuarioDAO.eliminar(usuarioExistente);
			Usuario usuarioEliminado = usuarioDAO.obtener(usuarioCodigo);
			assertNull(usuarioEliminado);
			System.out.println("> Usuario eliminado: "	+ usuarioExistente.getCodigo());
		}

		@Test
		public void testObtenerLista() {
			UsuarioDAO usuarioDAO = (UsuarioDAO) contextoSpring.getBean("usuarioDAO");
		    Busqueda busqueda = Busqueda.forClass(Usuario.class); 
			busqueda.add(Expression.like("codigo", "u4%"));
			busqueda.add(Expression.like("nombre", "r%"));
			List<Usuario> usuarioLista = usuarioDAO.obtenerLista(busqueda);
			
			assertNotNull(usuarioLista);
			
			for (Cliente usuario : usuarioLista) {
				System.out.println("> Usuario listado: " + usuario.getCodigo() + "|"
						+ usuario.getNombre() + "|" + usuario.getApellido1());
			}
		}		
		
}
