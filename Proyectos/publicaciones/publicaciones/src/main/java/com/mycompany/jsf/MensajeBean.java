package com.mycompany.jsf;

import com.mycompany.domain.Mensaje;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Mensaje.class, beanName = "mensajeBean")
public class MensajeBean {
}
