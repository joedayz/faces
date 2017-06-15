package com.mycompany.jsf;

import com.mycompany.domain.Publicacion;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Publicacion.class, beanName = "publicacionBean")
public class PublicacionBean {
}
