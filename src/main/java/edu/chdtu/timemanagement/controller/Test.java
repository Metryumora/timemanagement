package edu.chdtu.timemanagement.controller;

import edu.chdtu.timemanagement.model.*;
import edu.chdtu.timemanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Controller
@EnableAutoConfiguration
public class Test {

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


    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public ModelAndView test(ModelMap modelMap) {
        User admin = new User("metryumora@gmail.com", "password", "Валентин Тулуб", "+380671841877");
        userService.add(admin);
        User newUser = new User("spec@gmail.com", "pass", "Доктор Айболит", "322223");
        userService.add(newUser);
        Organisation org = new Organisation("Test Facility", "Address", admin);
        organisationService.add(org);
        Department dep = new Department("Department 1", org);
        departmentService.add(dep);
        List<DailyTimetable> timetableSet = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            DailyTimetable dailyTimetable = new DailyTimetable(
                    new Time(8, 0, 0),
                    new Time(17, 0, 0),
                    new Time(13, 0, 0),
                    new Time(14, 0, 0),
                    new Time(0, 30, 0),
                    "Room #10",
                    "Note");
            dailyTimetableService.add(dailyTimetable);
            timetableSet.add(dailyTimetable);
        }
        for (DailyTimetable dailyTimetable :
                timetableSet) {
            dailyTimetableService.add(dailyTimetable);
        }
        Timetable timetable = new Timetable(
                timetableSet,
                new Date(2017 - 1900, 1 - 1, 1),
                new Date(2017 - 1900, 12 - 1, 31));
        timetableService.add(timetable);
        Specialist specialist = new Specialist(newUser, "Top specialist", dep, timetable);
        specialistService.add(specialist);
        Appointment appointment = new Appointment(userService.get(1), specialist, Calendar.getInstance().getTime());
        appointmentService.add(appointment);

        return new ModelAndView("index");
    }

}
