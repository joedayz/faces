package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AjaxStatusBean {
	private String text;

	public void upperCase() {
		try {
			Thread.sleep(3000);
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
