package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.*;
import edu.chdtu.timemanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TimetableController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DailyTimetableService dailyTimetableService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RearrangeRequestService rearrangeRequestService;

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private OrganisationService organisationService;

    public ArrayList<Appointment> getAppointmentsSchema(Specialist specialist, Date date) {
        ArrayList<Appointment> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DailyTimetable todaysTimetable = specialist.getTodaysTimetable();
        Date workEnds = (Date) date.clone();
        Date appointmentDateAndTime = (Date) date.clone();
        Date breakStarts = (Date) date.clone();
        breakStarts.setHours(todaysTimetable.getBreakStarts().getHours());
        breakStarts.setMinutes(todaysTimetable.getBreakStarts().getMinutes() - 1);
        Date breakEnds = (Date) date.clone();
        breakEnds.setHours(todaysTimetable.getBreakEnds().getHours());
        breakEnds.setMinutes(todaysTimetable.getBreakEnds().getMinutes() - 1);

        workEnds.setHours(todaysTimetable.getWorkEnds().getHours());
        workEnds.setMinutes(todaysTimetable.getWorkEnds().getMinutes());


        appointmentDateAndTime.setHours(todaysTimetable.getWorkStarts().getHours());
        appointmentDateAndTime.setMinutes(todaysTimetable.getWorkStarts().getMinutes());

        while (appointmentDateAndTime.before(workEnds)) {
            if (appointmentDateAndTime.after(breakStarts) && appointmentDateAndTime.before(breakEnds)) {
                appointmentDateAndTime.setTime(appointmentDateAndTime.getTime() + todaysTimetable.getTimeForAppointment().getMinutes() * 60000);
                continue;
            }
            result.add(new Appointment(null, specialist, (Date) appointmentDateAndTime.clone()));
            appointmentDateAndTime.setTime(appointmentDateAndTime.getTime() + todaysTimetable.getTimeForAppointment().getMinutes() * 60000);
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
        ArrayList<Appointment> appointmentsSchema = getAppointmentsSchema(specialist, new Date());
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
