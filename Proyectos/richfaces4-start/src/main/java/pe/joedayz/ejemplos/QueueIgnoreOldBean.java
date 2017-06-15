package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@RequestScoped
public class QueueIgnoreOldBean {

	private String text;

	
	public void upperCase(AjaxBehaviorEvent event) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setText(text.toUpperCase());
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	

}
