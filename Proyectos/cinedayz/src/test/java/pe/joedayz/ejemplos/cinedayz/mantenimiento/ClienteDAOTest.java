package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Expression;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;

public class ClienteDAOTest {

	private static ApplicationContext contextoSpring;
	private static String clienteCodigo;

	// 2. Programamos el m�todo setUpClass() que debe ejecutarse antes de los
	// m�todos de prueba. Debe:
	// - Inicializar el contexto Spring para poner en memoria los objetos de
	// persistencia ya definidos en los *Context.xml
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Esta sentencia inicializa el contexto Spring utilizando un arreglo de
		// rutas del classpath que apuntan a los XML de configuraci�n
		System.out.println("Antes de Spring");
		contextoSpring = new ClassPathXmlApplicationContext(new String[] {
				"WEB-INF/ormContext.xml", "WEB-INF/daoContext.xml" });
		System.out.println("Despues de Spring");
	}

	// 3. Programamos el m�todo de prueba para CREAR una reserva. La validaci�n
	// ser� que el objeto creado no sea nulo.
	@Test
	public void testCrear() {
		System.out.println("Antes de crear");
		// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y
		// "tutorDAO" que Spring ya carg� en memoria al inicializarse
		ClienteDAO clienteDAO = (ClienteDAO) contextoSpring
				.getBean("clienteDAO");
		// En estas sentencias instanciamos un nuevo objeto Reserva con sus
		// propiedades
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setCodigo("u20102018");
		nuevoCliente.setNombre("tcsihsai");
		nuevoCliente.setApellido1("tcsihsai");
		nuevoCliente.setApellido2("tcsihsai");
		nuevoCliente.setEmail("hsaira@upc.edu.pe");
		nuevoCliente.setTipoUsuario("E");
		nuevoCliente.setStatus("B");
		nuevoCliente.setIntentos(0);
		nuevoCliente.setFechaRegistro(new Date());
		Cliente clienteCreado = clienteDAO.crear(nuevoCliente);
		clienteCodigo = clienteCreado.getCodigo();
		// Realizamos la validaci�n de prueba
		assertNotNull(clienteCreado);
		// Escribimos en consola el c�digo del alumno insertado en la BD
		System.out.println("> Cliente creado con c�digo: " + clienteCodigo);
	}

	@Test
	public void testObtener() {

		ClienteDAO clienteDAO = (ClienteDAO) contextoSpring
				.getBean("clienteDAO");

		Cliente clienteExistente = clienteDAO.obtener(clienteCodigo);

		assertNotNull(clienteExistente);

		System.out.println("> Cliente obtenido: "
				+ clienteExistente.getCodigo());
	}

	@Test
	public void testModificar() {

		ClienteDAO clienteDAO = (ClienteDAO) contextoSpring
				.getBean("clienteDAO");
		Cliente clienteExistente = clienteDAO.obtener("u20102017");
		clienteExistente.setNombre("*" + clienteExistente.getNombre());
		clienteExistente.setApellido1("*" + clienteExistente.getApellido1());
		clienteExistente.setEmail("sandy.angels@gmail.com");
		Cliente clienteModificado = clienteDAO.modificar(clienteExistente);
		assertNotNull(clienteModificado);
		System.out.println("> Cliente modificado: "
				+ clienteModificado.getCodigo());
	}

	@Test
	public void testEliminar() {
		ClienteDAO clienteDAO = (ClienteDAO) contextoSpring
				.getBean("clienteDAO");
		Cliente clienteExistente = clienteDAO.obtener(clienteCodigo);
		clienteDAO.eliminar(clienteExistente);
		Cliente clienteEliminado = clienteDAO.obtener(clienteCodigo);
		assertNull(clienteEliminado);
		System.out.println("> Clietne eliminado: "
				+ clienteExistente.getCodigo());
	}

	@Test
	public void testObtenerLista() {
		ClienteDAO clienteDAO = (ClienteDAO) contextoSpring.getBean("clienteDAO");
	    Busqueda busqueda = Busqueda.forClass(Cliente.class); 
		busqueda.add(Expression.like("codigo", "u2010%"));
		busqueda.add(Expression.like("nombre", "tc%"));
		List<Cliente> clienteLista = clienteDAO.obtenerLista(busqueda);
		
		assertNotNull(clienteLista);
		
		for (Cliente cliente : clienteLista) {
			System.out.println("> Cliente listado: " + cliente.getCodigo() + "|"
					+ cliente.getNombre() + "|" + cliente.getApellido1());
		}
	}

}
