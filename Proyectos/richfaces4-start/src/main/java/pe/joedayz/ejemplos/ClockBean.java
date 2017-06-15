package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ClockBean {

	private boolean enabled; 
	
	public java.util.Date getNow() {
		return new java.util.Date();
	}

	public void stopClock() {
		enabled = false;
	}

	public void startClock() {
		enabled = true;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
