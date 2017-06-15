package com.mycompany.jsf;

import com.mycompany.domain.Transaccion;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Transaccion.class, beanName = "transaccionBean")
public class TransaccionBean {
}
