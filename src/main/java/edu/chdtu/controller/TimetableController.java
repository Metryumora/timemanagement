package edu.chdtu.controller;

import edu.chdtu.model.entity.*;
import edu.chdtu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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

    private List<Appointment> getAppointments(Specialist specialist, Date date) {
        List<Appointment> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DailyTimetable dailyTimetable = specialist.getTimetable().getTodaysTimetable();
        Date workEnds = (Date) date.clone();
        Date appointmentDateAndTime = (Date) date.clone();
        Date breakStarts = (Date) date.clone();
        breakStarts.setHours(dailyTimetable.getBreakStarts().getHours());
        breakStarts.setMinutes(dailyTimetable.getBreakStarts().getMinutes() - 1);
        Date breakEnds = (Date) date.clone();
        breakEnds.setHours(dailyTimetable.getBreakEnds().getHours());
        breakEnds.setMinutes(dailyTimetable.getBreakEnds().getMinutes() - 1);

        workEnds.setHours(dailyTimetable.getWorkEnds().getHours());
        workEnds.setMinutes(dailyTimetable.getWorkEnds().getMinutes());


        appointmentDateAndTime.setHours(dailyTimetable.getWorkStarts().getHours());
        appointmentDateAndTime.setMinutes(dailyTimetable.getWorkStarts().getMinutes());

        while (appointmentDateAndTime.before(workEnds)) {
            if (appointmentDateAndTime.after(breakStarts) && appointmentDateAndTime.before(breakEnds)) {
                appointmentDateAndTime.setTime(appointmentDateAndTime.getTime() + dailyTimetable.getTimeForAppointment().getMinutes() * 60000);
                continue;
            }
            result.add(new Appointment(null, specialist, (Date) appointmentDateAndTime.clone()));
            appointmentDateAndTime.setTime(appointmentDateAndTime.getTime() + dailyTimetable.getTimeForAppointment().getMinutes() * 60000);
        }
        return result;
    }

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
                                         @RequestParam("spec") Integer specialistId) {
        List<Organisation> organisations = organisationService.getAll();
        modelMap.addAttribute("organisations", organisations);

        Specialist specialist = specialistService.get(specialistId);
        ArrayList<Appointment> appointmentsSchema = (ArrayList<Appointment>) getAppointments(specialist, new Date());
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
        modelMap.addAttribute("appointments", appointmentsSchema);
        return new ModelAndView("timetable");
    }
}
