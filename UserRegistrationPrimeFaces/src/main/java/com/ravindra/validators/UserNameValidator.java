package com.ravindra.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.ravindra.dao.UserRegistrationDao;
import com.ravindra.daoimpl.UserRegistrationDaoImpl;

@FacesValidator("userNameValidator")
public class UserNameValidator implements Validator {

	@Override
	public void validate(FacesContext fContext, UIComponent comp, Object obj) throws ValidatorException {
		UserRegistrationDao regDao = new UserRegistrationDaoImpl();
		String userName = obj.toString();
		UIInput uiInputConfirmPassword = (UIInput)comp.getAttributes().get("confirmUserName");
		String confirmUserName = uiInputConfirmPassword.getSubmittedValue().toString();
		if(userName==null || userName.isEmpty() || confirmUserName==null ||confirmUserName.isEmpty()) {
			return;
		}

		if(!userName.equals(confirmUserName)) {
			uiInputConfirmPassword.setValid(false);
			throw new ValidatorException(new FacesMessage("User Name must match Confirm User Name."));
		}
		
		//Exisitng user check
		if(regDao.existingUserCheck(userName) && regDao.existingUserCheck(confirmUserName)) {
			throw new ValidatorException(new FacesMessage("This User Name is already existing with us... create another User Name"));
		}
	}
}