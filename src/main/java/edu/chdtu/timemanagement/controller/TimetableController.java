package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.Department;
import edu.chdtu.timemanagement.model.Organisation;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Metr_yumora on 15.05.2017.
 */

@Controller
@EnableAutoConfiguration
public class TimetableController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private SecurityService securityService;

    private ModelAndView getModelAndViewForCurrentUser(String pageName, ModelMap modelMap) {
        modelMap.addAttribute("currentUser", securityService.findLoggedInUser());
        return new ModelAndView(pageName, modelMap);
    }

    private void getAndAddOrganisations(ModelMap modelMap) {
        List<Organisation> organisations = organisationService.getAll();
        modelMap.addAttribute("organisations", organisations);
    }

    private void getAndAddDepartments(ModelMap modelMap, int organisationId) {
        Set<Department> departments = organisationService.get(organisationId).getDepartments();
        modelMap.addAttribute("departments", departments);
    }

    @RequestMapping(value = "/organisations", method = {RequestMethod.GET})
    public ModelAndView loadOrganisations(ModelMap modelMap) {
        getAndAddOrganisations(modelMap);
        return getModelAndViewForCurrentUser("timetable", modelMap);
    }

    @RequestMapping(value = "/departments", method = {RequestMethod.POST})
    public ModelAndView loadDepartments(ModelMap modelMap,
                                        @RequestParam("selectedOrganisation") Integer selectedOrganisationId) {
        getAndAddOrganisations(modelMap);
        getAndAddDepartments(modelMap, selectedOrganisationId);
        modelMap.addAttribute("selectedOrganisation", selectedOrganisationId);
        return getModelAndViewForCurrentUser("timetable", modelMap);
    }

    @RequestMapping(value = "/specialists", method = {RequestMethod.POST})
    public ModelAndView loadSpecialists(ModelMap modelMap,
                                        @RequestParam("selectedOrganisation") Integer selectedOrganisationId,
                                        @RequestParam("selectedDepartment") Integer selectedDepartmentId) {
        getAndAddOrganisations(modelMap);
        getAndAddDepartments(modelMap, selectedOrganisationId);
        Set<Specialist> specialists = departmentService.get(selectedDepartmentId).getSpecialists();
        modelMap.addAttribute("selectedOrganisation", selectedOrganisationId);
        modelMap.addAttribute("selectedDepartment", selectedDepartmentId);
        modelMap.addAttribute("specialists", specialists);

        return getModelAndViewForCurrentUser("timetable", modelMap);
    }

    @RequestMapping(value = "/appointments", method = {RequestMethod.POST})
    public ModelAndView showAppointments(ModelMap modelMap,
                                         @RequestParam("selectedOrganisation") Integer selectedOrganisationId,
                                         @RequestParam("selectedDepartment") Integer selectedDepartmentId,
                                         @RequestParam("selectedSpecialist") Integer selectedSpecialistId) {
        getAndAddOrganisations(modelMap);
        getAndAddDepartments(modelMap, selectedOrganisationId);
        Set<Specialist> specialists = departmentService.get(selectedDepartmentId).getSpecialists();
        modelMap.addAttribute("specialists", specialists);

        Specialist specialist = specialistService.get(selectedSpecialistId);
        ArrayList<Appointment> appointmentsSchema = specialist.getDailyAppointmentsSchema(new Date());
        ArrayList<Appointment> appointments = (ArrayList<Appointment>) appointmentService.get(new Date(), specialist);
        int lastIndex = 0;
        for (Appointment appointment :
                appointments) {
            for (int i = lastIndex; i < appointmentsSchema.size(); i++) {
                if (appointment.getDateAndTime().getHours() == appointmentsSchema.get(i).getDateAndTime().getHours()
                        && appointment.getDateAndTime().getMinutes() == appointmentsSchema.get(i).getDateAndTime().getMinutes()) {
                    appointmentsSchema.remove(i);
                    appointmentsSchema.add(i, appointment);
                    lastIndex = i;
                    break;
                }
            }
        }
        modelMap.addAttribute("selectedOrganisation", selectedOrganisationId);
        modelMap.addAttribute("selectedDepartment", selectedDepartmentId);
        modelMap.addAttribute("selectedSpecialist", selectedSpecialistId);
        modelMap.addAttribute("appointments", appointmentsSchema);
        return getModelAndViewForCurrentUser("timetable", modelMap);
    }


}
