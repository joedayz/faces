package com.mycompany.jsf;

import com.mycompany.domain.Visita;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Visita.class, beanName = "visitaBean")
public class VisitaBean {
}
