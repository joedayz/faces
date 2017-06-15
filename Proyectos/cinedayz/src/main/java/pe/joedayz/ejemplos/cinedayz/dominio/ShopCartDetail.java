package pe.joedayz.ejemplos.cinedayz.dominio;

public class ShopCartDetail {
	Integer cartNumeroSequencial;
	String  cartFacturaNumero;
	Integer cartLinea;
	Integer codigoCartelera;
	Integer cartCantidad;
	String merchandizeCodigo;
	Double merchandizePrecio;
	Merchandize merchandize;
	ShopCart shopcart;
	
	
	public ShopCartDetail() {
		
	}
	
	



	public ShopCart getShopcart() {
		return shopcart;
	}





	public void setShopcart(ShopCart shopcart) {
		this.shopcart = shopcart;
	}





	public Merchandize getMerchandize() {
		return merchandize;
	}










	public void setMerchandize(Merchandize merchandize) {
		this.merchandize = merchandize;
	}











	public Double getMerchandizePrecio() {
		return merchandizePrecio;
	}

	public void setMerchandizePrecio(Double merchandizePrecio) {
		this.merchandizePrecio = merchandizePrecio;
	}

	public Integer getCartNumeroSequencial() {
		return cartNumeroSequencial;
	}
	public void setCartNumeroSequencial(Integer cartNumeroSequencial) {
		this.cartNumeroSequencial = cartNumeroSequencial;
	}
	public String getCartFacturaNumero() {
		return cartFacturaNumero;
	}
	public void setCartFacturaNumero(String cartFacturaNumero) {
		this.cartFacturaNumero = cartFacturaNumero;
	}
	public Integer getCartLinea() {
		return cartLinea;
	}
	public void setCartLinea(Integer cartLinea) {
		this.cartLinea = cartLinea;
	}
	public Integer getCodigoCartelera() {
		return codigoCartelera;
	}
	public void setCodigoCartelera(Integer codigoCartelera) {
		this.codigoCartelera = codigoCartelera;
	}
	public Integer getCartCantidad() {
		return cartCantidad;
	}
	public void setCartCantidad(Integer cartCantidad) {
		this.cartCantidad = cartCantidad;
	}
	public String getMerchandizeCodigo() {
		return merchandizeCodigo;
	}
	public void setMerchandizeCodigo(String merchandizeCodigo) {
		this.merchandizeCodigo = merchandizeCodigo;
	}
	
	
}
