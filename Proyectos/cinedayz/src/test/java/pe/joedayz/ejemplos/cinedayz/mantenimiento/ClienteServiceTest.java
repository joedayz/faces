package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.Usuario;
import pe.joedayz.ejemplos.cinedayz.registro.ClienteService;

public class ClienteServiceTest {
	private static ApplicationContext contextoSpring;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	contextoSpring = new ClassPathXmlApplicationContext(new String[] {
				"WEB-INF/ormContext.xml", "WEB-INF/daoContext.xml","WEB-INF/serviceContext.xml" });	
	}

	@Test
	public void testRegistrar() {
		Cliente cliente = new Cliente();
		
		//cliente.setCodigo("limalimon");
		cliente.setNombre("raul");
		cliente.setApellido1("yamashiro");
		cliente.setApellido2("masami");
		cliente.setEmail("hsaira@upc.edu.pe");
		
		ClienteService clienteService = (ClienteService)contextoSpring.getBean("clienteService");
		try {
			clienteService.registrar(cliente);
		} catch (Exception e) {
		
			System.out.println (e.getMessage());
			
			//fail("Registro de clientefallido");
		
		}
		ClienteDAO clienteDAO = (ClienteDAO)contextoSpring.getBean("clienteDAO"); 
		
		Cliente clienteCreado = clienteDAO.obtener(cliente.getCodigo());
		assertNotNull(clienteCreado);
	}
	/*
	@Test
	public void testAutenticar() {
		Cliente cliente = new Cliente();
		
		cliente.setCodigo("whitehorse");
		cliente.setClave("whitehorse1");
		
		ClienteService clienteService = (ClienteService)contextoSpring.getBean("clienteService");
		try {
			clienteService.autenticar(cliente);
		}catch(Exception e)	{
			System.out.println (e.getMessage());
		}
	}*/
	@Test
	public void testAutenticar(){
		ClienteService clienteService = (ClienteService)contextoSpring.getBean("clienteService");
		Usuario usuario= clienteService.autenticarAdmin("u4127282010", "u4127282010");
	}
}
