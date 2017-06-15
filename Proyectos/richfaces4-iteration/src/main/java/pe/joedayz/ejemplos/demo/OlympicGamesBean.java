package pe.joedayz.ejemplos.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import pe.joedayz.ejemplos.demo.model.BaseDescriptor;
import pe.joedayz.ejemplos.demo.model.GameDescriptor;

@ManagedBean
@ViewScoped
public class OlympicGamesBean implements Serializable {
	
	@ManagedProperty(value = "#{gamesParser.gamesList}")
	
	private List<GameDescriptor> games = new ArrayList<GameDescriptor>();

	public List<GameDescriptor> getGames() {
		return games;
	}

	public void setGames(List<GameDescriptor> games) {
		this.games = games;
	}
	
	
}
