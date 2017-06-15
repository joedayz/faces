package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.venta.MerchandizeService;

public class MerchandizeServiceTest {
	
	private static ApplicationContext contextoSpring;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	contextoSpring = new ClassPathXmlApplicationContext(new String[] {
				"WEB-INF/ormContext.xml", "WEB-INF/daoContext.xml","WEB-INF/serviceContext.xml" });	
	}
	
	@Test
	public void TestListarMerchandize(){
		MerchandizeService merchandizeService = (MerchandizeService)contextoSpring.getBean("merchandizeService");
		
		try{
			merchandizeService.listarMerchandize();
		}
		catch (Exception e) 
		{
			System.out.println (e.getMessage());	
		}
	}

}
