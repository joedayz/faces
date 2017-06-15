package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean (name="jsFunctionNameBean")
@RequestScoped
public class JSFunctionNameBean {

	private String name; // setter and getter

	public String getGreeting() {
		return "Hello " + this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
