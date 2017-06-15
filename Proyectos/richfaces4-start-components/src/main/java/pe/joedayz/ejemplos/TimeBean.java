package pe.joedayz.ejemplos;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TimeBean {

	public Date getNow(){
		return new Date();
	}
}
