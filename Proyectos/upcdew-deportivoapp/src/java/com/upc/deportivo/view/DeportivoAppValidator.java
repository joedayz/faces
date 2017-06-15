/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.view;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.validator.Validator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author jcabrera
 */
public class DeportivoAppValidator implements Validator  {
 private static final String TELEFONO_MASK ="[\\d{2,3}[- ]*]*\\d{6,10}";
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

          FacesMessage message = new FacesMessage();


         if (component.getId().equals("txttelefono")) {
         String telefono = (String) value;
   
         Pattern maskSecuencuia = Pattern.compile(TELEFONO_MASK);
         Matcher matcher = maskSecuencuia.matcher(telefono);

         if (!matcher.matches()) {
            message.setDetail("Numero Invalido");
            message.setSummary("Numero Invalido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
         }
      }
    }

}
