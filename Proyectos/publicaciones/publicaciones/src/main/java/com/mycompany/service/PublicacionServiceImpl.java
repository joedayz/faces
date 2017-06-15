package com.mycompany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.domain.Publicacion;

@Service
public class PublicacionServiceImpl implements PublicacionService {

	public long countAllPublicacions() {
        return Publicacion.countPublicacions();
    }

	public void deletePublicacion(Publicacion publicacion) {
        publicacion.remove();
    }

	public Publicacion findPublicacion(Integer id) {
        return Publicacion.findPublicacion(id);
    }

	public List<Publicacion> findAllPublicacions() {
        return Publicacion.findAllPublicacions();
    }

	public List<Publicacion> findPublicacionEntries(int firstResult, int maxResults) {
        return Publicacion.findPublicacionEntries(firstResult, maxResults);
    }

	public void savePublicacion(Publicacion publicacion) {
        publicacion.persist();
    }

	public Publicacion updatePublicacion(Publicacion publicacion) {
        return publicacion.merge();
    }

	@Override
	public List<Publicacion> listarPublicacionPorTituloODescripcion(
			String cadena) {
		return Publicacion.listarPublicacionPorTituloODescripcion(cadena);
	}

	

}
