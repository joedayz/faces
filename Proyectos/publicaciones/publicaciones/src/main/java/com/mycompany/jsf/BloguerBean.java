package com.mycompany.jsf;

import com.mycompany.domain.Bloguer;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Bloguer.class, beanName = "bloguerBean")
public class BloguerBean {
}
