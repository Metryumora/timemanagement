package edu.chdtu.controller;

import edu.chdtu.model.entity.DailyTimetable;
import edu.chdtu.model.entity.Department;
import edu.chdtu.model.entity.Organisation;
import edu.chdtu.model.entity.Specialist;
import edu.chdtu.service.*;
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
    UserService userService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DailyTimetableService dailyTimetableService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RearrangeRequestService rearrangeRequestService;

    @Autowired
    SpecialistService specialistService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    OrganisationService organisationService;

    @RequestMapping(value = "/organisations", method = {RequestMethod.GET})
    public ModelAndView showOrganisations(ModelMap modelMap) {
        ArrayList<Organisation> organisations = (ArrayList<Organisation>) organisationService.getAll();
        modelMap.addAttribute("organisations", organisations);
        return new ModelAndView("timetable");
    }

    @RequestMapping(value = "/departments", method = {RequestMethod.GET})
    public ModelAndView showDepartments(ModelMap modelMap, @RequestParam("org") Integer organisationId) {
        List<Organisation> organisations = organisationService.getAll();
        Set<Department> departments = organisationService.get(organisationId).getDepartments();
        modelMap.addAttribute("departments", departments);
        modelMap.addAttribute("organisations", organisations);
        return new ModelAndView("timetable");
    }

    @RequestMapping(value = "/specialists", method = {RequestMethod.GET})
    public ModelAndView showSpecialists(ModelMap modelMap, @RequestParam("dep") Integer departmentId) {
        List<Organisation> organisations = organisationService.getAll();
        Set<Specialist> specialists = departmentService.get(departmentId).getSpecialists();
        modelMap.addAttribute("specialists", specialists);
        modelMap.addAttribute("organisations", organisations);
        return new ModelAndView("timetable");
    }

    @RequestMapping(value = "/appointments", method = {RequestMethod.GET})
    public ModelAndView showAppointments(ModelMap modelMap,
                                         @RequestParam("spec") Integer specialistId,
                                         @RequestParam("day") Integer day) {
        List<Organisation> organisations = organisationService.getAll();
        modelMap.addAttribute("organisations", organisations);

        Specialist specialist = specialistService.get(specialistId);
        DailyTimetable dailyTimetable = specialist.getTimetable().getTimetables().get(day);
//        Date maxAppointments = dailyTimetable.getEndsWorking().getHours()+dailyTimetable.getEndsWorking().getMinutes() - dailyTimetable.getStartsWorking();
//                / dailyTimetable.getMinutesForAppointment();

        return new ModelAndView("timetable");
    }
}
