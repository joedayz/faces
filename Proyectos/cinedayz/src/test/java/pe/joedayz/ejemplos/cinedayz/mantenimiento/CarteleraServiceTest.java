package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.cartelera.CarteleraService;
import pe.joedayz.ejemplos.cinedayz.dominio.Busqueda;

public class CarteleraServiceTest {
	private static ApplicationContext contextoSpring;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	contextoSpring = new ClassPathXmlApplicationContext(new String[] {
				"WEB-INF/ormContext.xml", "WEB-INF/daoContext.xml","WEB-INF/serviceContext.xml" });	
	}
	
	@Test
	public void TestMostrarCartelera(){
		CarteleraService carteleraService = (CarteleraService)contextoSpring.getBean("carteleraService");
		try{
			carteleraService.mostrarCarteleraCompleta();
		}
		catch (Exception e) 
		{
			System.out.println (e.getMessage());	
		}
	}
	
	@Test
	public void TestConsulta(){
		 
		CarteleraService detcarteleraService = (CarteleraService)contextoSpring.getBean("carteleraService");
		String cine="00001";
		String horario = "8:00pm";
		Integer precio = 15;
		String tipoTarifa="Adulto";
		Integer capacidadSala = 150;
		
		Busqueda busquedaCriterio = new Busqueda();
		busquedaCriterio.setCine(cine);
		busquedaCriterio.setHorarios(horario);
		busquedaCriterio.setPrecio(precio);
		busquedaCriterio.setTipoTarifa(tipoTarifa);
		busquedaCriterio.setCapacidadSala(capacidadSala);
		
		detcarteleraService.buscarCarteleraxFiltros( busquedaCriterio);	
	}
	
}