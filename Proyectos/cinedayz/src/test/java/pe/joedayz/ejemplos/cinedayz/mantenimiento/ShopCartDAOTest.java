package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Expression;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.ShopCart;

public class ShopCartDAOTest {
	 private static ApplicationContext contextoSpring;
	 private static String shopFactura;
	    
	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	 
	contextoSpring =  new ClassPathXmlApplicationContext(
	                  new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});			
	 }
	 
		/**
		 * 
		 */
		@Test
		public void testCrear() {
			System.out.println("Antes de crear");
			// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y "tutorDAO" que Spring ya carg� en memoria al inicializarse
	        ShopCartDAO shopCartDAO = (ShopCartDAO)contextoSpring.getBean("shopcartDAO");      
	        
	        ShopCart nuevoShopCart = new ShopCart();	
	        //nuevoShopCart.setShopFactura("00007");	        
	        nuevoShopCart.setShopFecha(new Date());
	        
	        Cliente cliente =new Cliente();
	        cliente.setCodigo("ryamashiro");
	        nuevoShopCart.setCliente(cliente);
	        
	        nuevoShopCart.setShopTipoPago("cash");
	        nuevoShopCart.setShopSubtotal(120.1);
	        nuevoShopCart.setShopTax(15.2);
	        nuevoShopCart.setShopTotal(130.2);
	        
	        ShopCart shopCartCreado = shopCartDAO.crear(nuevoShopCart);
	       // shopFactura = shopCartCreado.getShopFactura();
	       
	        assertNotNull(shopCartCreado);	       
	       // System.out.println("> Shop cart factura de numero : "+ shopFactura );
		}

		@Test
		public void testObtener() {
	    	
			ShopCartDAO shopCartDAO = (ShopCartDAO)contextoSpring.getBean("shopcartDAO");	        
	        ShopCart shopCartExistente = shopCartDAO.obtener("00001");	        
	        assertNotNull(shopCartExistente);	        
	        System.out.println("> sHop cart Factura obtenido: "+ shopCartExistente.getShopFactura());
		}

		@Test
		public void testModificar() {

			ShopCartDAO shopCartDAO = (ShopCartDAO)contextoSpring.getBean("shopcartDAO");
			
			ShopCart shopCartExistente = shopCartDAO.obtener("00001");
			shopCartExistente.setShopSubtotal(12.3);
			shopCartExistente.setShopTipoPago("Debito");
			shopCartExistente.setShopTax(12.3);
			shopCartExistente.setShopTotal(34.7);
			
			ShopCart shopCartModificado = shopCartDAO.modificar(shopCartExistente);
			assertNotNull(shopCartModificado);
			System.out.println("> Shop cart modificado: "+ shopCartModificado.getShopFactura());
		}
		/*
		@Test
		public void testEliminar() {
			ShopCartDAO shopCartDAO = (ShopCartDAO)contextoSpring.getBean("shopcartDAO");
			
			ShopCart shopCartExistente = shopCartDAO.obtener("00002");
			shopCartDAO.eliminar(shopCartExistente);
			ShopCart shopCartEliminado = shopCartDAO.obtener("00002");
			assertNull(shopCartEliminado);
			System.out.println("> Shop cart factura eliminado: "	+ shopCartExistente.getShopFactura());
		}
		*/
		
		@Test
		public void testObtenerLista() {
			ShopCartDAO shopCartDAO = (ShopCartDAO) contextoSpring.getBean("shopcartDAO");
		    Busqueda busqueda = Busqueda.forClass(ShopCart.class); 
			busqueda.add(Expression.like("shopFecha", new Date()));
			List<ShopCart> shopCartLista = shopCartDAO.obtenerLista(busqueda);
			
			assertNotNull(shopCartLista);
			
			for (ShopCart shopcart : shopCartLista) {
				System.out.println("> Pelicula listado: " + shopcart.getShopFactura() + "|"
						+ shopcart.getShopTipoPago() + "|" + shopcart.getShopTotal());
			}
		}
	

	 
}
