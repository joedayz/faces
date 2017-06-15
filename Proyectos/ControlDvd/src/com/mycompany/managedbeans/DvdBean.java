package com.mycompany.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.mycompany.entities.DVD;
import com.mycompany.entities.Genero;
import com.mycompany.repository.DvdRepository;
import com.mycompany.repository.GeneroRepository;


@ManagedBean
public class DvdBean {

	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;

	private DVD dvd = new DVD();
	private List<DVD> dvds;
	private Long generoID;

	public void save() {
		GeneroRepository generoRepository = new GeneroRepository(
				this.entityManager);
		Genero genero = generoRepository.search(generoID);
		this.dvd.setGenero(genero);

		DvdRepository dvdRepository = new DvdRepository(this.entityManager);
		dvdRepository.save(this.dvd);

		this.dvd = new DVD();
		this.dvds = null;
	}

	public void remove(DVD dvd) {
		DvdRepository repository = new DvdRepository(this.entityManager);
		repository.remove(dvd);

		this.dvds = null;
	}

	public List<DVD> getDvds() {
		if (this.dvds == null) {
			DvdRepository repository = new DvdRepository(this.entityManager);
			this.dvds = repository.getDVDs();
		}

		return this.dvds;
	}

	public Long getCount() {
		DvdRepository repository = new DvdRepository(this.entityManager);

		return repository.getCountDVDs();
	}

	public DVD getDvd() {
		return dvd;
	}

	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	public Long getGeneroID() {
		return generoID;
	}

	public void setGeneroID(Long generoID) {
		this.generoID = generoID;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute(" EntityManager ");
	}
	
	

}
