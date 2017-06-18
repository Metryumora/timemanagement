package edu.chdtu.timemanagement.validator;

import edu.chdtu.timemanagement.model.Organisation;
import edu.chdtu.timemanagement.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Metr_yumora on 29.05.2017.
 */
@Component
public class OrganisationValidator implements Validator {

    @Autowired
    private OrganisationService organisationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Organisation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Organisation org = (Organisation) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (organisationService.getByName(org.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
