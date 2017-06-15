package com.upc.deportivo.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * JSF utilities.
 */
public class FacesUtils {

   /**
    * Get servlet context.
    *
    * @return the servlet context
    */
   public static ServletContext getServletContext() {
      return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
   }

   public static ExternalContext getExternalContext() {
      FacesContext fc = FacesContext.getCurrentInstance();
      return fc.getExternalContext();
   }

   public static HttpSession getHttpSession(boolean create) {
      return (HttpSession) FacesContext.getCurrentInstance().
              getExternalContext().getSession(create);
   }

   /**
    * Get managed bean based on the bean name.
    *
    * @param beanName the bean name
    * @return the managed bean associated with the bean name
    */
   @SuppressWarnings("unchecked")
   public static <T> T getManagedBean(String beanName, Class type) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
      StringBuffer sb = new StringBuffer("#{");
      sb.append(beanName).append("}");
      ValueExpression valueExpression =  expressionFactory.createValueExpression(
              facesContext.getELContext(), sb.toString(), type);
      return (T)valueExpression.getValue(facesContext.getELContext());
      //return getValueBinding(getJsfEl(beanName)).getValue(FacesContext.getCurrentInstance());
   }

   /**
    * Remove the managed bean based on the bean name.
    *
    * @param beanName the bean name of the managed bean to be removed
    */
   public static void resetManagedBean(String beanName,Class type) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      ExpressionFactory expressionFactory =
         facesContext.getApplication().getExpressionFactory();
      StringBuffer sb = new StringBuffer("#{");
      sb.append(beanName).append("}");
      ValueExpression valueExpression =  expressionFactory.createValueExpression(
              facesContext.getELContext(), sb.toString(), type);
      valueExpression.setValue(facesContext.getELContext(), null);
//      getValueBinding(getJsfEl(beanName)).setValue(FacesContext.getCurrentInstance(), null);
   }

   /**
    * Store the managed bean inside the session scope.
    *
    * @param beanName    the name of the managed bean to be stored
    * @param managedBean the managed bean to be stored
    */
   public static void setManagedBeanInSession(String beanName, Object managedBean) {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
   }

    public static void removeManagedBeanInSession(String beanName) {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(beanName);
   }


  

   /**
    * Get parameter value from request scope.
    *
    * @param name the name of the parameter
    * @return the parameter value
    */
   public static String getRequestParameter(String name) {
      return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
   }

   /**
    * Add information message.
    *
    * @param msg the information message
    */
   public static void addInfoMessage(String msg) {
      addInfoMessage(null, msg);
   }

  


   /**
    * Add information message to a specific client.
    *
    * @param clientId the client id
    * @param msg      the information message
    */
   public static void addInfoMessage(String clientId, String msg) {
      FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
   }

   /**
    * Add information message from the specific resource.
    *
    * @param clientId the client id
    * @param msg      the information message
    */
   public static void addInfoMessage(String key, Object params[]) {
      String message = getMessageResourceString(key, params);
      addInfoMessage(message);
   }

   /**
    * Add error message.
    *
    * @param msg the error message
    */
   public static void addErrorMessage(String msg) {
      addErrorMessage(null, msg);
   }

   public static HttpServletRequest getServletRequest() {
      return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
   }

    public static HttpServletResponse getServletResponse() {
      return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
   }



   /**
    * Add error message to a specific client.
    *
    * @param clientId the client id
    * @param msg      the error message
    */
   public static void addErrorMessage(String clientId, String msg) {
      FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
   }

   /**
    * Add error message from the default resource.
    *
    * @param clientId the client id
    * @param msg      the error message
    */
   public static void addErrorMessageFromResource(String key, Object params[]) {
      String message = getMessageResourceString(key, params);
      addErrorMessage(message);
   }

   private static Application getApplication() {
      ApplicationFactory appFactory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
      return appFactory.getApplication();
   }

//   private static ValueBinding getValueBinding(String el) {
//      return getApplication().createValueBinding(el);
//   }

//    private static Object getElValue(String el) {
//        return getValueBinding(el).getValue(FacesContext.getCurrentInstance());
//    }
   private static String getJsfEl(String value) {
      return "#{" + value + "}";
   }

   private static ClassLoader getCurrentClassLoader(Object defaultObject) {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      if (loader == null) {
         loader = defaultObject.getClass().getClassLoader();
      }
      return loader;
   }

   public static String getMessageResourceString(
           String key) {
      return getMessageResourceString(key, null);
   }

   public static String getMessageResourceString(
           String key,
           Object params[]) {
      Locale locale = Locale.getDefault();
      String text = null;
      String bundleName =
              FacesContext.getCurrentInstance().getApplication().getMessageBundle();
      ResourceBundle bundle = null;
      if (params == null) {
         bundle = ResourceBundle.getBundle(bundleName, locale);
      } else {
         bundle = ResourceBundle.getBundle(bundleName, locale,
                 getCurrentClassLoader(params));
      }

      try {
         text = bundle.getString(key);
      } catch (MissingResourceException e) {
         text = "?? key " + key + " not found ??";
      }

      if (params != null) {
         MessageFormat mf = new MessageFormat(text, locale);
         text = mf.format(params, new StringBuffer(), null).toString();
      }

      return text;
   }
}
