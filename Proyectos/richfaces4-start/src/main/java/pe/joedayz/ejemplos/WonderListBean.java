package pe.joedayz.ejemplos;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.annotation.*;

@ManagedBean
@RequestScoped
public class WonderListBean {

	private ArrayList<Wonder> list;

	public ArrayList<Wonder> getList() {
		return list;
	}

	@PostConstruct
	public void init() {
		list = new ArrayList<Wonder>();
		list.add(new Wonder("Chichen Itza", "Mexico"));
		list.add(new Wonder("Christ the Redeemer", "Brazil"));
		list.add(new Wonder("Colosseum", "Italy"));
		list.add(new Wonder("Great Wall of China", "China"));
		list.add(new Wonder("Machu Picchu", "Peru"));
		list.add(new Wonder("Petra", "Jordan"));
		list.add(new Wonder("Taj Mahal", "India"));
	}

}
