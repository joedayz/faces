package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CityBean {
	private String selectedTab = "sf"; 

	public void sfAction() {
		this.selectedTab = "sf";
	}

	public void laAction() {
		this.selectedTab = "la";
	}

	public void nycAction() {
		this.selectedTab = "nyc";
	}

	public String getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}
	
	
	
}