package edu.chdtu.timemangement;

import edu.chdtu.timemanagement.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Metr_yumora on 19.05.2017.
 */
public class TimetableTest {


    @Test
    public void test() {
        User admin = new User("metryumora@gmail.com", "password", "Валентин Тулуб", "+380671841877");
        User newUser = new User("spec@gmail.com", "pass", "Доктор Айболит", "322223");
        Organisation org = new Organisation("Test Facility", "Address", admin);
        Department dep = new Department("Department 1", org);
        List<DailyTimetable> timetables = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            DailyTimetable dailyTimetable = new DailyTimetable(
                    new Time(8, 0, 0),
                    new Time(17, 0, 0),
                    new Time(13, 0, 0),
                    new Time(14, 0, 0),
                    new Time(0, 30, 0),
                    "Room #10",
                    "Note");
            timetables.add(dailyTimetable);
        }
        Timetable timetable = new Timetable(
                timetables,
                new Date(2017 - 1900, 1 - 1, 1),
                new Date(2017 - 1900, 12 - 1, 31));
        Specialist specialist = new Specialist(newUser, "Top specialist", dep, timetable);
        Appointment appointment = new Appointment(admin, specialist, Calendar.getInstance().getTime());

        Assert.assertEquals(timetables.get(0), timetable.getSpecificDayTimetable(DayOfWeek.MONDAY));
        Assert.assertEquals(timetables.get(6), timetable.getSpecificDayTimetable(DayOfWeek.SUNDAY));
        //
        //Assert.assertEquals(timetables.get(6), timetable.getHodiernalTimetable());
    }
}

