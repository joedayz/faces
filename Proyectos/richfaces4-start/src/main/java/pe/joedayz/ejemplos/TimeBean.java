package pe.joedayz.ejemplos;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TimeBean {

	private Date time1;
	private Date time2;
	private Date time3;
	private Date time4;
	private Date time5;
	
	public Date getTime1() {
		return new Date();
	}
	
	public Date getTime2() {
		return new Date();
	}
	
	public Date getTime3() {
		return new Date();
	}
	
	public Date getTime4() {
		return new Date();
	}
	
	public Date getTime5() {
		return new Date();
	}
	
	
	
}
