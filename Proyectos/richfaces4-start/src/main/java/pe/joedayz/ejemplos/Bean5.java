package pe.joedayz.ejemplos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@RequestScoped
public class Bean5 {

	private String selection;
	private List<String> renderComponents;

	@PostConstruct
	public void init() {
		renderComponents = new ArrayList<String>();
	}

	public void selectComponents(AjaxBehaviorEvent event) {
		renderComponents.add(selection);
	}

	public List<String> getRenderComponents() {
		return renderComponents;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public Date getClock1() {
		return new Date();
	}

	public Date getClock2() {
		return new Date();
	}

	public Date getClock3() {
		return new Date();
	}

}
