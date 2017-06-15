package com.mycompany.jsf;

import com.mycompany.domain.Aviso;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Aviso.class, beanName = "avisoBean")
public class AvisoBean {
}
