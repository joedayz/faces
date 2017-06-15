package com.mycompany.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.entities.DVD;


public class DvdRepository {
	private EntityManager entityManager;

	public DvdRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(DVD dvd) {
		this.entityManager.persist(dvd);
		this.entityManager.flush();
	}

	public void remove(DVD dvd) {
		this.entityManager.remove(dvd);
	}

	@SuppressWarnings("unchecked")
	public List<DVD> getDVDs() {
		return this.entityManager.createNamedQuery("DVD.findAll")
				.getResultList();
	}

	public Long getCountDVDs() {
		return (Long) this.entityManager.createNamedQuery("DVD.count")
				.getSingleResult();
	}

}
