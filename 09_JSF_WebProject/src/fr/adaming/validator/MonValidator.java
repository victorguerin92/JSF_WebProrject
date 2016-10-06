package fr.adaming.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("validatorPers")
public class MonValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent componenet, Object value)
			throws ValidatorException {
		
		String saisie= (String) value;
		try {
		if (!saisie.contains("@")){
			
				throw new Exception("le mail doit contenir un @");}
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
				
			}
		
	}

}
