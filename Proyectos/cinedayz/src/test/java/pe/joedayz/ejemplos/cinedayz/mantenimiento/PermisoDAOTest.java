package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Permiso;

public class PermisoDAOTest {
	 private static ApplicationContext contextoSpring;
	 private static String permisoCodigo;
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
	        PermisoDAO permisoDAO = (PermisoDAO)contextoSpring.getBean("permisoDAO");
	        // En estas sentencias instanciamos un nuevo objeto Reserva con sus propiedades
	        Permiso nuevoPermiso = new Permiso();
	        nuevoPermiso.setCodigo("41222");
	        nuevoPermiso.setAcceso("1");
	        nuevoPermiso.setUsuario("whitehorse");
	        nuevoPermiso.setFechaBaja(new Date());
	        nuevoPermiso.setFechaInicio(new Date());
	        Permiso permisoCreado = permisoDAO.crear(nuevoPermiso);
	        permisoCodigo = permisoCreado.getCodigo();
	        // Realizamos la validaci�n de prueba
	        assertNotNull(permisoCreado);
	        // Escribimos en consola el c�digo del alumno insertado en la BD
	        System.out.println("> Permiso creada con c�digo: "+ permisoCodigo);
		}
		
		
	 
}
