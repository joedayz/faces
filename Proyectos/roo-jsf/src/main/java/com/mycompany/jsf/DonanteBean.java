package com.mycompany.jsf;

import com.mycompany.domain.Donante;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Donante.class, beanName = "donanteBean")
public class DonanteBean {
}
