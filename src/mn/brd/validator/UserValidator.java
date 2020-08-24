package mn.brd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mn.brd.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean)target;
		
		String beanName = errors.getObjectName();
		
		if(beanName.contentEquals("joinUserBean") || beanName.contentEquals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
		}
			
		if(beanName.contentEquals("joinUserBean")) {
			
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
			}
		}
		
	}
	
	
}
