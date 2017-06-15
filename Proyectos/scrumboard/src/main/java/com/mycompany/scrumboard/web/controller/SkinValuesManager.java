package com.mycompany.scrumboard.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "skinValuesManager")
@ApplicationScoped
public class SkinValuesManager implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> values;

	private String defaultSkin = "blue";

	@PostConstruct
	public void construct() {
		values = new LinkedHashMap<String, String>();
		values.put("yellow", "appYellowSkin.css");
		values.put("orange", "appOrangeSkin.css");
		values.put("red", "appRedSkin.css");
		values.put(defaultSkin, "appBlueSkin.css");
	}

	@PreDestroy
	public void destroy() {
		if (null != values) {
			values.clear();
			values = null;
		}
	}

	protected String getSkinCss(String skin) {
		if (!values.containsKey(skin))
			return getDefaultSkinCss();
		return values.get(skin);
	}

	protected String getDefaultSkinCss() {
		return values.get(defaultSkin);
	}

	public List<String> getNames() {
		return new ArrayList<String>(values == null ? null : values.keySet());
	}

	public int getSize() {
		return values.keySet().size();
	}

}
