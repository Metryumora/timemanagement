package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.Appointment;
import edu.chdtu.timemanagement.model.Department;
import edu.chdtu.timemanagement.model.Organisation;
import edu.chdtu.timemanagement.model.Specialist;
import edu.chdtu.timemanagement.service.*;
import edu.chdtu.timemanagement.util.DateConverter;
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

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView loadOrganisations(ModelMap modelMap) {
        getAndAddOrganisations(modelMap);
        return getModelAndViewForCurrentUser("index", modelMap);
    }

    @RequestMapping(value = "/departments", method = {RequestMethod.POST})
    public ModelAndView loadDepartments(ModelMap modelMap,
                                        @RequestParam("selectedOrganisation") Integer selectedOrganisationId) {
        getAndAddOrganisations(modelMap);
        getAndAddDepartments(modelMap, selectedOrganisationId);
        modelMap.addAttribute("selectedOrganisation", selectedOrganisationId);
        return getModelAndViewForCurrentUser("index", modelMap);
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

        modelMap.addAttribute("fieldName", "appointmentDate");
        modelMap.addAttribute("appointmentDate", DateConverter.formatDate(new Date(), "yyyy-MM-dd"));

        return getModelAndViewForCurrentUser("index", modelMap);
    }

    @RequestMapping(value = "/appointments", method = {RequestMethod.POST})
    public ModelAndView loadAppointments(ModelMap modelMap,
                                         @RequestParam("selectedOrganisation") Integer selectedOrganisationId,
                                         @RequestParam("selectedDepartment") Integer selectedDepartmentId,
                                         @RequestParam("selectedSpecialist") Integer selectedSpecialistId,
                                         @RequestParam("appointmentDate") String rawDate) {
        getAndAddOrganisations(modelMap);
        getAndAddDepartments(modelMap, selectedOrganisationId);
        Set<Specialist> specialists = departmentService.get(selectedDepartmentId).getSpecialists();
        modelMap.addAttribute("specialists", specialists);

        Specialist specialist = specialistService.get(selectedSpecialistId);
        Date date = new Date();
        if (rawDate != null) {
            date = DateConverter.parseDate(rawDate, "yyyy-MM-dd");
        }
        ArrayList<Appointment> appointmentsSchema = specialist.getDailyAppointmentsSchema(date);
        if (appointmentsSchema != null) {
            ArrayList<Appointment> appointments = (ArrayList<Appointment>) appointmentService.get(date, specialist);
            int lastIndex = 0;
            for (Appointment appointment :
                    appointments) {
                for (int i = lastIndex; i < appointmentsSchema.size(); i++) {
                    if (appointment.getDateAndTime().getTime() == appointmentsSchema.get(i).getDateAndTime().getTime()) {
                        appointmentsSchema.remove(i);
                        appointmentsSchema.add(i, appointment);
                        lastIndex = i;
                        break;
                    }
                }
            }
            Date now = new Date();
            for (int i = 0; i < appointmentsSchema.size(); ) {
                if (appointmentsSchema.get(i).getDateAndTime().before(now)) {
                    appointmentsSchema.remove(i);
                    continue;
                }
                i++;
            }
        }
        modelMap.addAttribute("selectedOrganisation", selectedOrganisationId);
        modelMap.addAttribute("selectedDepartment", selectedDepartmentId);
        modelMap.addAttribute("selectedSpecialist", selectedSpecialistId);
        modelMap.addAttribute("specialist", specialist);
        modelMap.addAttribute("appointments", appointmentsSchema);
        modelMap.addAttribute("fieldName", "#");
        modelMap.addAttribute("appointmentsSend", true);
        if (appointmentsSchema != null) {
            modelMap.addAttribute("appointmentPlace",
                    specialist
                            .getTimetable()
                            .getSpecificDayTimetable(date)
                            .getPlace());
        }
        modelMap.addAttribute("appointmentDate", DateConverter.formatDate(date, "yyyy-MM-dd"));
        return getModelAndViewForCurrentUser("index", modelMap);
    }

    @RequestMapping(value = "/arrange", method = {RequestMethod.POST})
    public ModelAndView arrangeAppointment(ModelMap modelMap,
                                           @RequestParam("appointmentDate") String date,
                                           @RequestParam("appointmentTime") String time,
                                           @RequestParam("selectedSpecialist") Integer selectedSpecialistId) {
        appointmentService.add(new Appointment(securityService.findLoggedInUser(),
                specialistService.get(selectedSpecialistId),
                DateConverter.parseDate(date + " " + time, "yyyy-MM-dd HH:mm")
        ));

        return getModelAndViewForCurrentUser("redirect:/appointments", modelMap);
    }


    @RequestMapping(value = "/appointments", method = {RequestMethod.GET})
    public ModelAndView showUsersAppointments(ModelMap modelMap) {
        List<Appointment> appointments = securityService.findLoggedInUser().getUnexpiredAppointments();
        modelMap.addAttribute("appointments", appointments);
        return getModelAndViewForCurrentUser("appointments", modelMap);
    }

    @RequestMapping(value = "/cancel", method = {RequestMethod.POST})
    public String showUsersAppointments(@RequestParam("appointmentId") Integer appointmentId) {
        appointmentService.remove(appointmentService.get(appointmentId));
        return "redirect:/appointments";
    }
}
