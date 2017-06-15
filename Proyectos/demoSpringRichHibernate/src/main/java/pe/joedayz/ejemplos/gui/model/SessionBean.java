package pe.joedayz.ejemplos.gui.model;

import java.io.Serializable;

import pe.joedayz.ejemplos.persistence.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("session")
public class SessionBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -2477891600149910534L;
	private String mandant = "default";
	private User user;


	public SessionBean() { }


	public String getMandant() {
        return mandant;
	}

	public void setMandant(String mandant) {
		this.mandant = mandant;		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}