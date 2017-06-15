package com.mycompany.scrumboard.web.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "skinUrlManager")
public class SkinUrlManager implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String skin;
	
	@ManagedProperty(value = "#{skinManager}")
	private SkinManager skinManager;
	@ManagedProperty(value = "#{skinValuesManager}")
	private SkinValuesManager skinValuesManager;
	
    
    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public void update() {
        if (skin == null ||"".equals(skin))
            return;
        String skinCss = skinValuesManager.getSkinCss(skin.toLowerCase());
        skinManager.setSelectedSkin(skinCss);
    }

    public SkinManager getSkinManager() {
        return skinManager;
    }

    public void setSkinManager(SkinManager skinManager) {
        this.skinManager = skinManager;
    }

    public SkinValuesManager getSkinValuesManager() {
        return skinValuesManager;
    }

    public void setSkinValuesManager(SkinValuesManager skinValuesManager) {
        this.skinValuesManager = skinValuesManager;
    }
	
	
}
