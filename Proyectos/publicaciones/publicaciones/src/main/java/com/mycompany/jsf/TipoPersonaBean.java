package com.mycompany.jsf;

import com.mycompany.domain.TipoPersona;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = TipoPersona.class, beanName = "tipoPersonaBean")
public class TipoPersonaBean {
}
