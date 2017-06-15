package pe.joedayz.ejemplos.cinedayz.dominio;

import java.util.Date;

public class ShopCart {
Integer shopFactura;
Date shopFecha;
String shopCliente;
String shopTipoPago;
Double shopSubtotal;
Double shopTax;
Double shopTotal;
Cliente cliente;

public ShopCart() {
	
}


public Integer getShopFactura() {
	return shopFactura;
}


public void setShopFactura(Integer shopFactura) {
	this.shopFactura = shopFactura;
}


public Date getShopFecha() {
	return shopFecha;
}

public void setShopFecha(Date shopFecha) {
	this.shopFecha = shopFecha;
}

public String getShopCliente() {
	return shopCliente;
}

public void setShopCliente(String shopCliente) {
	this.shopCliente = shopCliente;
}

public String getShopTipoPago() {
	return shopTipoPago;
}

public void setShopTipoPago(String shopTipoPago) {
	this.shopTipoPago = shopTipoPago;
}

public Double getShopSubtotal() {
	return shopSubtotal;
}

public void setShopSubtotal(Double shopSubtotal) {
	this.shopSubtotal = shopSubtotal;
}

public Double getShopTax() {
	return shopTax;
}

public void setShopTax(Double shopTax) {
	this.shopTax = shopTax;
}

public Double getShopTotal() {
	return shopTotal;
}

public void setShopTotal(Double shopTotal) {
	
	this.shopTotal = this.shopSubtotal+this.shopTax;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


}
