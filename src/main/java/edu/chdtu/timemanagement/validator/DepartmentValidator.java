package edu.chdtu.timemanagement.validator;

import edu.chdtu.timemanagement.model.Department;
import edu.chdtu.timemanagement.model.Organisation;
import edu.chdtu.timemanagement.service.DepartmentService;
import edu.chdtu.timemanagement.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Metr_yumora on 29.05.2017.
 */
public class DepartmentValidator implements Validator {

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Organisation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Department department = (Department) o;
        Organisation org = department.getOrganisation();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (departmentService.getByName(org.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
