package com.mycompany.jsf;

import com.mycompany.domain.TipoDocumento;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = TipoDocumento.class, beanName = "tipoDocumentoBean")
public class TipoDocumentoBean {
}
