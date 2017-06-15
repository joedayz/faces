package pe.joedayz.ejemplos;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class CalendarBean {
	
	private Date today;

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}
	
	
}
