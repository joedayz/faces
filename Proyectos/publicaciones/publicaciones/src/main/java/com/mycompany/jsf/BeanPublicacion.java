package com.mycompany.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

import com.mycompany.domain.Publicacion;
import com.mycompany.service.PublicacionService;

@Configurable
@ManagedBean(name = "beanPublicacion")
@SessionScoped
@RooSerializable
@RooJsfManagedBean(entity = Publicacion.class, beanName = "beanPublicacion")
public class BeanPublicacion implements Serializable{

	@Autowired
	PublicacionService publicacionService;
	
	private String cadena = "";
	private List<Publicacion> publicaciones;
	
	
	
	

	public String buscarPublicacion() {
		publicaciones = publicacionService
				.listarPublicacionPorTituloODescripcion(cadena);
		return "busqueda.xhtml?faces-redirect=true";

	}


	//getter and setters
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}


	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}


	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	
	

}
