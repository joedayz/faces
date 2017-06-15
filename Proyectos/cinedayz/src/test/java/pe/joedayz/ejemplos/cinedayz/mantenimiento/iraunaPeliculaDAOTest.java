package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class iraunaPeliculaDAOTest {
	private static ApplicationContext contextoSpring;
    private static Integer actuacionCodigo;
    
	   @BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.out.println("Antes de Spring");
			contextoSpring =
	                new ClassPathXmlApplicationContext(
	                    new String[]{
	                        "WEB-INF/ormContext.xml",
	                        "WEB-INF/daoContext.xml"});
			System.out.println("Despues de Spring");
		}
	   
	   
}
