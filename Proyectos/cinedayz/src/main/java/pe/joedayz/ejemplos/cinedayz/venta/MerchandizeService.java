package pe.joedayz.ejemplos.cinedayz.venta;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Expression;

import pe.joedayz.ejemplos.cinedayz.core.Busqueda;
import pe.joedayz.ejemplos.cinedayz.dominio.Asiento;
import pe.joedayz.ejemplos.cinedayz.dominio.Cliente;
import pe.joedayz.ejemplos.cinedayz.dominio.DetCartelera;
import pe.joedayz.ejemplos.cinedayz.dominio.Local;
import pe.joedayz.ejemplos.cinedayz.dominio.Merchandize;
import pe.joedayz.ejemplos.cinedayz.dominio.Pelicula;
import pe.joedayz.ejemplos.cinedayz.dominio.Sala;
import pe.joedayz.ejemplos.cinedayz.dominio.ShopCart;
import pe.joedayz.ejemplos.cinedayz.dominio.ShopCartDetail;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.AsientoDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ClienteDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.DetCarteleraDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.LocalDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.MerchandizeDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.PeliculaDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.SalaDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ShopCartDAO;
import pe.joedayz.ejemplos.cinedayz.mantenimiento.ShopCartDetailDAO;

public class MerchandizeService {
	ShopCartDAO shopcartDAO;
	ClienteDAO clienteDAO;
	MerchandizeDAO merchandizeDAO;
	ShopCartDetailDAO shopcartdetailDAO;
	SalaDAO salaDAO;
	LocalDAO localDAO;
	PeliculaDAO peliculaDAO;
	AsientoDAO asientoDAO;
	DetCarteleraDAO detCarteleraDAO;
	
	List<Asiento> asientoocupado;	
	
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public AsientoDAO getAsientoDAO() {
		return asientoDAO;
	}

	public void setAsientoDAO(AsientoDAO asientoDAO) {
		this.asientoDAO = asientoDAO;
	}

	public DetCarteleraDAO getDetCarteleraDAO() {
		return detCarteleraDAO;
	}

	public void setDetCarteleraDAO(DetCarteleraDAO detCarteleraDAO) {
		this.detCarteleraDAO = detCarteleraDAO;
	}

	public PeliculaDAO getPeliculaDAO() {
		return peliculaDAO;
	}

	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}

	public void setLocalDAO(LocalDAO localDAO) {
		this.localDAO = localDAO;
	}

	public void setSalaDAO(SalaDAO salaDAO) {
		this.salaDAO = salaDAO;
	}

	public void setShopcartDAO(ShopCartDAO shopcartDAO) {
		this.shopcartDAO = shopcartDAO;
	}

	
	

	public void setShopcartdetailDAO(ShopCartDetailDAO shopcartdetailDAO) {
		this.shopcartdetailDAO = shopcartdetailDAO;
	}


	public void setMerchandizeDAO(MerchandizeDAO merchandizeDAO) {
		this.merchandizeDAO = merchandizeDAO;
	}
	public Double actualiza_cantidad_merchandize(Merchandize merchandize, Integer cantidad)
	{
		Merchandize m = merchandizeDAO.obtener(merchandize.getMerchandizeCodigo());
		Double precio = m.getMerchandizePrecio();
		Integer cant_actual=m.getMerchandizeCantidad();
		if (cant_actual>=cantidad){
		    m.setMerchandizeCantidad(cant_actual-cantidad);
		    merchandizeDAO.modificar(m);
		    return precio;
		}else{ 
			return 0.0;
		}
	}
	public void vendeMerchandize(Cliente clienteShop, Merchandize merchandize, Integer cantidad) throws Exception{
		  Merchandize m = merchandizeDAO.obtener(merchandize.getMerchandizeCodigo());
		  
		  Double precio = actualiza_cantidad_merchandize( merchandize,cantidad);
		  if (precio > 0.0){
			  Double tax = 0.17;
			  Double subtotal=precio*cantidad;
			  
			  ShopCart nuevoShopCart = new ShopCart();	
		      nuevoShopCart.setShopFactura(8);	        
		      nuevoShopCart.setShopFecha(new Date());
		        
		      nuevoShopCart.setCliente(clienteShop);
		        
		      nuevoShopCart.setShopTipoPago("cash");
		      
		      nuevoShopCart.setShopSubtotal(subtotal);
		      nuevoShopCart.setShopTax(subtotal * tax);
		      
		      nuevoShopCart.setShopTotal(subtotal + (subtotal  * tax));
		        
		      shopcartDAO.crear(nuevoShopCart);
	    	//todo=guardar el detalle	
		      guardaDetalleCarrito(nuevoShopCart,merchandize,cantidad);
		  }
	}
	
	public void guardaDetalleCarrito(ShopCart nuevoShopCart, Merchandize merchandize,Integer cantidad){
		Merchandize m = merchandizeDAO.obtener(merchandize.getMerchandizeCodigo());
		Double precio = m.getMerchandizePrecio();
		  
		int linea=2;
		ShopCartDetail nuevoShopCartDeta = new ShopCartDetail();
		
		nuevoShopCartDeta.setCartCantidad(cantidad);		

		nuevoShopCartDeta.setShopcart(nuevoShopCart);
		nuevoShopCartDeta.setCartLinea(linea);
		nuevoShopCartDeta.setMerchandize(merchandize);

		nuevoShopCartDeta.setMerchandizePrecio(precio);
		
		shopcartdetailDAO.crear(nuevoShopCartDeta);
	}
	
	public List<Merchandize> listarMerchandize() 
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Merchandize.class);
		List<Merchandize> merchandizeLista = merchandizeDAO.obtenerLista(busqueda);
		
		for (Merchandize merchandize : merchandizeLista) {
			 System.out.println("codigo->"+merchandize.getMerchandizeCodigo());
			 System.out.println("detalle->"+merchandize.getMerchandizeDetalle());
		}
		return merchandizeLista;
	}
	
	public List<Sala> listarSalas() 
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Sala.class);
		List<Sala> salaLista = salaDAO.obtenerLista(busqueda);
		return salaLista;
	}
	
	public List<Local> listarLocales() 
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Local.class);
		List<Local> localLista = localDAO.obtenerLista(busqueda);
		return localLista;
	}

	public List<Pelicula> listarPelicula() 
	{ 		   
	   Busqueda busqueda = Busqueda.forClass(Pelicula.class);
		List<Pelicula> peliculaLista = peliculaDAO.obtenerLista(busqueda);
		return peliculaLista;
	}

	
	public List<Asiento> ubicarAsiento(String salaCodigo, DetCartelera detCartelera){
		Busqueda busqueda = Busqueda.forClass(Asiento.class);
		
		Busqueda joinSala = busqueda.createCriteria("sala");
		joinSala.add(Expression.eq("codigoSala", salaCodigo));
		
		Busqueda joinDetCartelera = busqueda.createCriteria("detCartelera");
		joinDetCartelera.add(Expression.eq("detalleCarteleraCodigo", detCartelera.getDetalleCarteleraCodigo()));
		
		return asientoDAO.obtenerLista(busqueda);		
	}
	
	
	public List<DetCartelera> ubicarCartelera(String codigoLocal, String codigoSala,String codigopelicula)
	{
		Busqueda busqueda = Busqueda.forClass(DetCartelera.class);
		//busqueda.add(Expression.eq(sala, value))
		Busqueda joinSala= busqueda.createCriteria("sala");
		joinSala.add(Expression.eq("codigoSala", codigoSala));
		
		Busqueda joinLocal=joinSala.createCriteria("local");
		joinLocal.add(Expression.eq("localCodigo", codigoLocal));
		
		Busqueda joinCartelera=busqueda.createCriteria("cartelera");
		Busqueda joinPelicula=joinCartelera.createCriteria("pelicula"); 
		
		joinPelicula.add(Expression.eq("codigo", codigopelicula));
		
		return detCarteleraDAO.obtenerLista(busqueda);		
		
	}
	
	public List<Asiento> listaAsientosVendidos(Asiento asientoseleccinado, DetCartelera detCartelera){
		Busqueda busqueda = Busqueda.forClass(Asiento.class);
		busqueda.add(Expression.eq("asiento_status", "reservado"));
	//	busqueda.add(Expression.eq("asiento_codigo",asientoseleccinado.getAsiento_codigo()));
		
		Busqueda joinDetCartelera=busqueda.createCriteria("detCartelera");
		joinDetCartelera.add(Expression.eq("detalleCarteleraCodigo", detCartelera.getDetalleCarteleraCodigo()));
		return asientoDAO.obtenerLista(busqueda);
		
	}
    

	public List<Asiento> vendeAsientos(Asiento asiento){
			
			Asiento asientoExistente = asientoDAO.obtener(asiento.getAsiento_codigo());
			if (asientoExistente.getAsiento_status().contentEquals("reservado") || asientoExistente.getAsiento_status().contentEquals("Available")  ){		
				asientoExistente.setAsiento_status("reservado");
				asientoDAO.modificar(asientoExistente);
			
				asientoocupado=listaAsientosVendidos(asientoExistente,asientoExistente.getDetCartelera());
				return asientoocupado;
			}
			return null;
		}
	
	
	public void grabaFactura(List<Asiento> asientosReservados, DetCartelera cartelera, String codigoCliente){
		
		Integer codigoCartelera= cartelera.getCartelera().getCarteleraCodigo();
		Double precio         = cartelera.getPrecio();
		Integer cantidad       = asientosReservados.size();
		Double subTotal = precio*cantidad;
		Double tax			   = subTotal*0.18;
		
		System.out.println("grabaFactura->clienteNombre->"+ codigoCliente);	
		Cliente cliente = clienteDAO.obtener(codigoCliente);
		
		
		 
		ShopCart shopcart = new ShopCart();
		shopcart.setCliente(cliente);
		shopcart.setShopFecha(new Date());
		shopcart.setShopSubtotal(subTotal);
		shopcart.setShopTax(tax);
		shopcart.setShopTipoPago("cash");
		shopcart.setShopTotal(subTotal+tax);
		shopcartDAO.crear(shopcart);
		
		
		
		
		
		ShopCartDetail shopcartdet = new ShopCartDetail();
		shopcartdet.setCartCantidad(cantidad);
		shopcartdet.setShopcart(shopcart);
		shopcartdet.setCartLinea(1);
		shopcartdet.setCodigoCartelera(codigoCartelera);
		shopcartdetailDAO.crear(shopcartdet);
		
			
		
		
		for (Asiento asientol : asientosReservados) {
			 asientol.setAsiento_status("vendido") ;
			 asientoDAO.modificar(asientol);
	   }

		
		
		
		
		
		
		
		
		
		System.out.println("subtotal->"+ subTotal);
	//	System.out.println("codigocar "+ codigoCartelera+" precio= "+precio +"cantidad= "+cantidad+"Cliente "+ cliente.getNombre());
			
		
	}

}
