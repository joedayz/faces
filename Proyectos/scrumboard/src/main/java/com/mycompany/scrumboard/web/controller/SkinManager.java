package com.mycompany.scrumboard.web.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "skinManager")
public class SkinManager {

	
	private String selectedSkin;
	@ManagedProperty(value = "#{skinValuesManager}")
	private SkinValuesManager skinValuesManager;

	@PostConstruct
	public void construct() {
		selectedSkin = skinValuesManager.getDefaultSkinCss();
	}

	public String getSelectedSkin() {
		return selectedSkin;
	}

	public void setSelectedSkin(String selectedSkin) {
		this.selectedSkin = selectedSkin;
	}

	public SkinValuesManager getSkinValuesManager() {
		return skinValuesManager;
	}

	public void setSkinValuesManager(SkinValuesManager skinValuesManager) {
		this.skinValuesManager = skinValuesManager;
	}
}
