package pe.joedayz.ejemplos.cinedayz.mantenimiento;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.joedayz.ejemplos.cinedayz.cartelera.PeliculaService;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;


public class PeliculaServiceTest {
	
	private static ApplicationContext contextoSpring;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	contextoSpring = new ClassPathXmlApplicationContext(new String[] {
				"WEB-INF/ormContext.xml", "WEB-INF/daoContext.xml","WEB-INF/serviceContext.xml" });	
	}/*
	@Test
	public void PeliculasNoVigentes(){
		PeliculaService peliculaService = (PeliculaService)contextoSpring.getBean("peliculaService");
		try{
			peliculaService.listarPeliculasNoVigentes();
		}
		catch (Exception e) 
		{
			System.out.println (e.getMessage());	
		}
	}
	
	@Test
	public void PeliculasVigentes(){
		PeliculaService peliculaService = (PeliculaService)contextoSpring.getBean("peliculaService");
		try{
			peliculaService.listarPeliculasVigentes();
		}
		catch (Exception e) 
		{
			System.out.println (e.getMessage());	
		}
	}
	
	@Test
	public void BuscarPeliculaTitulo(){
		Pelicula pelicula =new Pelicula();
		pelicula.setTitulo("Bora"); //*The Green Mille-Black Swam-Bora-El oso Yogui
		String verDetalle="si";
		PeliculaService peliculaService = (PeliculaService)contextoSpring.getBean("peliculaService");
			CarteleraService funcionesService = (CarteleraService)contextoSpring.getBean("carteleraService");
		try{
			 Pelicula peliculaExistente = peliculaService.mostrarUnaPeliculaEscritura(pelicula);			 
			if (peliculaExistente != null && verDetalle.equalsIgnoreCase("si"))
				peliculaService.mostrarInfoCompletaPeliculaActiva(peliculaExistente);
			//    funcionesService.devuelveFunciones(peliculaExistente);
			    peliculaService.devuelveComentarioPelicula(peliculaExistente);
		}
		catch (Exception e) 
		{
			System.out.println (e.getMessage());	
		}
	}*/
	/*
	@Test
	public void MostrarTrailerPeliculaTest(){
		Pelicula peliculaBuscada =new Pelicula();
		peliculaBuscada.setCodigo("1902");
		peliculaBuscada.setTitulo("El oso Yogui");
		
		  
		PeliculaService peliculaService = (PeliculaService)contextoSpring.getBean("peliculaService");
		try{
			
			peliculaService.peliculaTrailerAbstract(peliculaBuscada);
			peliculaService.peliculaActores(peliculaBuscada);
			peliculaService.devuelveComentarioPelicula(peliculaBuscada);
			
		}
		catch (Exception e)
		{
			System.out.println (e.getMessage());
		}
	}
	*/
	@Test 
	public void IrpeliculaTest()
	{   
		PeliculaService peliculaServices = (PeliculaService)contextoSpring.getBean("peliculaService");
		try {
			Pelicula pelicula = peliculaServices.iraunaPelicula("1902");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
