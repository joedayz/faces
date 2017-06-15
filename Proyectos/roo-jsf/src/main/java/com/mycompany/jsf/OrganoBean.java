package com.mycompany.jsf;

import com.mycompany.domain.Organo;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Organo.class, beanName = "organoBean")
public class OrganoBean {
}
