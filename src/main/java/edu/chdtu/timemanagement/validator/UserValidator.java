package edu.chdtu.timemanagement.validator;

import edu.chdtu.timemanagement.model.User;
import edu.chdtu.timemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Metr_yumora on 23.05.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if (userService.getByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "Short.userForm.password");
        }


        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "Required");


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Required");
    }
}
