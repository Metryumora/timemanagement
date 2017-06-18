package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.Department;
import edu.chdtu.timemanagement.model.Organisation;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.service.DepartmentService;
import edu.chdtu.timemanagement.service.OrganisationService;
import edu.chdtu.timemanagement.service.SecurityService;
import edu.chdtu.timemanagement.service.SpecialistService;
import edu.chdtu.timemanagement.validator.DepartmentValidator;
import edu.chdtu.timemanagement.validator.OrganisationValidator;
import edu.chdtu.timemanagement.validator.SpecialistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * Created by Metr_yumora on 17.06.2017.
 */
@Controller
@EnableAutoConfiguration
public class AdminController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SpecialistService specialistService;
    @Autowired
    private OrganisationService organisationService;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private OrganisationValidator organisationValidator;
    @Autowired
    private DepartmentValidator departmentValidator;
    @Autowired
    private SpecialistValidator specialistValidator;

    private ModelAndView getModelAndViewForCurrentUser(String pageName, ModelMap modelMap) {
        modelMap.addAttribute("currentUser", securityService.findLoggedInUser());
        return new ModelAndView(pageName, modelMap);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showAdminPage(ModelMap modelMap,
                                      @Param("selectedOrganisationId") Integer selectedOrganisationId,
                                      @Param("selectedDepartmentId") Integer selectedDepartmentId) {
        Set<Organisation> organisations = securityService.findLoggedInUser().getOrganisations();
        modelMap.addAttribute("organisations", organisations);
        if (selectedOrganisationId != null) {
            Set<Department> departments = organisationService.get(selectedOrganisationId).getDepartments();
            modelMap.addAttribute("departments", departments);
            modelMap.addAttribute("selectedOrganisationId");
        }
        if (selectedDepartmentId != null) {
            Set<Specialist> specialists = departmentService.get(selectedDepartmentId).getSpecialists();
            modelMap.addAttribute("specialists", specialists);
            modelMap.addAttribute("selectedDepartmentId");
            modelMap.addAttribute("selectedSpecialistId");
        }
        return getModelAndViewForCurrentUser("admin", modelMap);
    }

    @RequestMapping(value = "/addOrganisation", method = RequestMethod.POST)
    public String addOrganisation(@RequestParam(name = "inputOrganisationName") String orgName,
                                  @RequestParam(name = "inputOrganisationAddress") String orgAddress) {
        Organisation newOrganisation = new Organisation(orgName, orgAddress, securityService.findLoggedInUser());
//        organisationValidator.validate(newOrganisation, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "redirect:/admin";
//        }
        organisationService.add(newOrganisation);
        return "redirect:/admin";
    }
}
