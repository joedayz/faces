package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Asiento;
import pe.joedayz.ejemplos.cinedayz.venta.MerchandizeService;

public class CarritoServiceTest {
	private static ApplicationContext contextoSpring;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	contextoSpring = new ClassPathXmlApplicationContext(new String[] {
				"WEB-INF/ormContext.xml", "WEB-INF/daoContext.xml","WEB-INF/serviceContext.xml" });	
	}
	/*
	@Test
	public void TestListarAsientos()
	{
		MerchandizeService carrito = (MerchandizeService)contextoSpring.getBean("merchandizeService");
		String sala="00001";
		
		Cartelera cartelera =new Cartelera();
		cartelera.setCarteleraCodigo(1);
		
		DetCartelera detCartelera = new DetCartelera();
		detCartelera.setCartelera(cartelera);
		detCartelera.setCarteleraCodigo(1);
		detCartelera.setDetalleCarteleraCodigo(1);
		detCartelera.setHorario("6:00-8:00");
		List<Asiento> asiento = carrito.ubicarAsiento(sala, detCartelera);
		for (Asiento asientol : asiento) {
			System.out.println("> Comentario listado: " 
					+ asientol.getAsiento_status() + " | " + asientol.getAsiento_numero());
		}
		
	}
	*/
	
	@Test
	public void testVendeAsiento()
	{
		MerchandizeService carrito = (MerchandizeService)contextoSpring.getBean("merchandizeService");
		Asiento asiento = new Asiento();
		asiento.setAsiento_codigo(1);
		asiento.setAsiento_numero("S01-01");
		asiento.setAsiento_status("available");
		//asiento=carrito.vendeAsientos(asiento);
		
		List<Asiento> asientos = carrito.vendeAsientos(asiento);
		for (Asiento asientol : asientos) {
			System.out.println("> Comentario listado: " 
					+ asientol.getAsiento_status() + " | " + asientol.getAsiento_numero() 
					  );
		}
		
		
		
		//System.out.println(asiento.getAsiento_status());
	}
	
//	@Test
//	public void TestVendeMerchandize(){
//		MerchandizeService carrito = (MerchandizeService)contextoSpring.getBean("carritoVendeMerchandizing");
		
		//CompraMerchandize compraMerchandize = new CompraMerchandize();
		
		//compraMerchandize.setCodigoMerchandize("00001");
		//compraMerchandize.setCodigoPelicula("1900");
		//compraMerchandize.setCantidad(2);
		
		
//		Merchandize merchandize = new Merchandize();
//		String codigoMerchandise="00001";
//		merchandize.setMerchandizeCodigo(codigoMerchandise);
		
//		String codigoUsuario="pthompson";
//		Cliente cliente =new Cliente();
//		cliente.setCodigo(codigoUsuario);
		
//		Integer cantidad=2;
		
//		try {
//			carrito.vendeMerchandize(cliente, merchandize, cantidad);
//		}catch(Exception e) {
//			System.out.println (e.getMessage());
//		}
//	}
	
}
