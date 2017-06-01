package edu.chdtu.timemanagement.validator;

import edu.chdtu.timemanagement.model.Department;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Metr_yumora on 29.05.2017.
 */
public class SpecialistValidator implements Validator {

    @Autowired
    private SpecialistService specialistService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Specialist.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Specialist specialist = (Specialist) o;
        Department department = specialist.getDepartment();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organisation", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specialization", "Required");

        if (specialistService.getAll().contains(specialist.getUser())) {
            errors.rejectValue("user", "Used");
        }

        if (department.getSpecialists().contains(specialist)) {
            errors.rejectValue("user", "Duplicate");
        }
    }
}
