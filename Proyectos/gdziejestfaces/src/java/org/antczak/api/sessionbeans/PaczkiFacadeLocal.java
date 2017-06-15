/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.antczak.api.sessionbeans;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.antczak.api.entities.Paczki;

/**
 *
 * @author Paweł
 */
@Local
public interface PaczkiFacadeLocal {

    void create(Paczki paczki);

    void edit(Paczki paczki);

    void remove(Paczki paczki);

    List<Paczki> findAll(String numerPaczki);

    boolean count();
    
    Map<String, Integer> getPieCouriers();
    
}
