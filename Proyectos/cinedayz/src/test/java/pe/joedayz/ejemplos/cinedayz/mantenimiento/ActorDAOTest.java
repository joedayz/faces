package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.criterion.Expression;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Actor;

public class ActorDAOTest {
    private static ApplicationContext contextoSpring;
    private static String actorCodigo;
    
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
        ActorDAO actorDAO = (ActorDAO)contextoSpring.getBean("actorDAO");
        // En estas sentencias instanciamos un nuevo objeto Reserva con sus propiedades
        Actor nuevoActor = new Actor();
        
        nuevoActor.setCodigoActor("412733");
        nuevoActor.setNombre("Tom");
        nuevoActor.setApellido("Cavanagh");
        nuevoActor.setUrl("http://www.imdb.com/name/nm0146915/");
        Actor actorCreado = actorDAO.crear(nuevoActor);
        actorCodigo = actorCreado.getCodigoActor();
        // Realizamos la validaci�n de prueba
        assertNotNull(actorCreado);
        // Escribimos en consola el c�digo del alumno insertado en la BD
        System.out.println("> Actor creada con c�digo: "+ actorCodigo);
	}

	@Test
	public void testObtener() {

		ActorDAO actorDAO = (ActorDAO)contextoSpring.getBean("actorDAO");
        
		Actor actorExistente = actorDAO.obtener("412730");

		assertNotNull(actorExistente);
		System.out.println("> Actor obtenido: "	+ actorExistente.getCodigoActor());
	}
/*	
	@Test
	public void testModificar() {

		ActorDAO actorDAO = (ActorDAO)contextoSpring.getBean("actorDAO");
        Actor actorExistente = actorDAO.obtener("412229");
		actorExistente.setNombre("*" + actorExistente.getNombre());
		actorExistente.setApellido("*" + actorExistente.getApellido());
		actorExistente.setUrl(actorExistente.getUrl());
		Actor actorModificado = actorDAO.modificar(actorExistente);
		assertNotNull(actorModificado);
		System.out.println("> Actor modificado: "	+ actorModificado.getCodigoActor());
	}
	/*
	@Test
	public void testEliminar() {
		ActorDAO actorDAO = (ActorDAO)contextoSpring.getBean("actorDAO");
		Actor actorExistente = actorDAO.obtener(actorCodigo);
		actorDAO.eliminar(actorExistente);
		Actor actorEliminado = actorDAO.obtener(actorCodigo);
		assertNull(actorEliminado);
		System.out.println("> Actor eliminado: "+ actorExistente.getCodigoActor());
	}
	*/
	
	@Test
	public void testObtenerLista() {
		ActorDAO actorDAO = (ActorDAO)contextoSpring.getBean("actorDAO");
	    Busqueda busqueda = Busqueda.forClass(Actor.class); 
		busqueda.add(Expression.like("codigoActor", "4%"));
		busqueda.add(Expression.like("nombre", "T%"));
		List<Actor> actorLista = actorDAO.obtenerLista(busqueda);
		
		assertNotNull(actorLista);
		
		for (Actor actor : actorLista) {
			System.out.println("> Cliente listado: " + actor.getCodigoActor() + "|"
					+ actor.getNombre() + "|" + actor.getApellido());
		}
	}



}
