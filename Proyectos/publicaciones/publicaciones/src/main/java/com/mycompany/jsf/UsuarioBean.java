package com.mycompany.jsf;

import com.mycompany.domain.Usuario;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Usuario.class, beanName = "usuarioBean")
public class UsuarioBean {
}
