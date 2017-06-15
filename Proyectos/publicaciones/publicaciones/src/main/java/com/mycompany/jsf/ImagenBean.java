package com.mycompany.jsf;

import com.mycompany.domain.Imagen;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Imagen.class, beanName = "imagenBean")
public class ImagenBean {
}
