package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.dominio.Actor;
import pe.joedayz.ejemplos.cinedayz.dominio.Actuacion;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;

public class ActuacionDAOTest {
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
    
	@Test
	public void testCrear() {
		System.out.println("Antes de crear");
		// Obtenemos una referencia a los objetos "reservaDAO", "alumnoDAO" y "tutorDAO" que Spring ya carg� en memoria al inicializarse
        ActuacionDAO actuacionDAO = (ActuacionDAO)contextoSpring.getBean("actuacionDAO");
        // En estas sentencias instanciamos un nuevo objeto Reserva con sus propiedades
        Actuacion nuevoActuacion = new Actuacion();
     //   nuevoActuacion.setCodigoActuacion(4);        
        
        Actor c = new Actor();
        c.setCodigoActor("412732");
        nuevoActuacion.setActor(c);
        
        Pelicula pelicula = new Pelicula();
        pelicula.setCodigo("1902");
        nuevoActuacion.setPelicula(pelicula);
        
        Actuacion actuacionCreado = actuacionDAO.crear(nuevoActuacion);
        actuacionCodigo = actuacionCreado.getCodigoActuacion();
        // Realizamos la validaci�n de prueba
        assertNotNull(actuacionCreado);
        // Escribimos en consola el c�digo del alumno insertado en la BD
        System.out.println("> Actuacion creado con c�digo: "+ actuacionCreado.getCodigoPelicula());
	}
 
}
