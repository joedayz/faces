package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="jsFunctionDrinkBean")
@RequestScoped
public class JSFunctionDrinkBean {

	private String drink;

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	
}
