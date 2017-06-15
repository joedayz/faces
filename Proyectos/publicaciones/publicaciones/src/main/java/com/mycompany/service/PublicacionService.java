package com.mycompany.service;

import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.mycompany.domain.Publicacion;

@RooService(domainTypes = { com.mycompany.domain.Publicacion.class })
public interface PublicacionService {
	
	
	public abstract List<Publicacion> listarPublicacionPorTituloODescripcion(String cadena);
}
