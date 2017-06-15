/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.antczak.api.sessionbeans;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.antczak.api.entities.Paczki;

/**
 *
 * @author Paweł
 */
@Stateless
public class PaczkiFacade implements PaczkiFacadeLocal {

    @PersistenceContext(unitName = "GdzieJestFacesPU")
    private EntityManager em;
    private Paczki entityClass;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void create(Paczki entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Paczki entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Paczki entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public List<Paczki> findAll(String numerPaczki) {
        Query query = em.createQuery("SELECT o FROM Paczki AS o where o.numer like :numer");
        query.setParameter("numer", numerPaczki);
        return query.getResultList();

    }

    @Override
    public boolean count() {
        return getEntityManager().isOpen();
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Integer> getPieCouriers() {
         Query query = em.createQuery("SELECT o FROM Paczki AS o where o.numer like :numer");
//select firma,count(*) from (SELECT DISTINCT NUMER,firma FROM paczki) a group by firma order by count(*) desc
        query.getResultList();
        return null;
    }
    
    
}
