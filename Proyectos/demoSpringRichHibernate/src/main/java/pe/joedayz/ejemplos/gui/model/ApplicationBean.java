package pe.joedayz.ejemplos.gui.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component
public class ApplicationBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -8603773638140988924L;

	public String getAppname(){
	 	String[] strings = getRequest().getRequestURI().split("/");
		return strings[1];
	}

}