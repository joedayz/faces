/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.antczak.api.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import org.antczak.api.entities.Paczki;
import org.antczak.api.sessionbeans.PaczkiFacadeLocal;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Paweł
 */
public class Index {

    /**
     * Creates a new instance of Index
     */
    @EJB
    protected PaczkiFacadeLocal pfl;
    
    private String Imie = "Pawel";
    private int count;
    private List<Paczki> paczki;
    
    public Index() {
                createPieModel();  
    }

    /**
     * @return the Imie
     */
    public String getImie() {
        return Imie;
    }

    /**
     * @param Imie the Imie to set
     */
    public void setImie(String Imie) {
        this.Imie = Imie;
    }
    
  /*   public List<Paczki> szukaj(String login){
    return pfl.findRange(int[]{10, 20});
  }*/

    /**
     * @return the count
     */
    public int getCount() {
        return (pfl.count()) ? 5 : -5;
    }

    /**
     * @return the paczkiDataModel
     */
    public List<Paczki> getPaczki() {
        return pfl.findAll("50663145989");
    }

    /**
     * @return the paczki
     */

    private PieChartModel pieModel;  
  

  
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();  

        pieModel.set("Brand 1", 540);  
        pieModel.set("Brand 2", 325);  
        pieModel.set("Brand 3", 702);  
        pieModel.set("Brand 4", 421);  
    }  
    
}
