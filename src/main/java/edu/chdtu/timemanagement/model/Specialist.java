package edu.chdtu.timemanagement.model;

import edu.chdtu.timemanagement.util.DateConverter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Metr_yumora on 22.03.2017.
 */
@Entity
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = User.class)
    private User user;

    @NotEmpty
    @Column
    private String specialization;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @OneToOne(targetEntity = Timetable.class)
    private Timetable timetable;

    @OneToMany(targetEntity = Appointment.class)
    @JoinColumn(name = "specialist_id")
    private Set<Appointment> appointments = new HashSet<>();

    public Specialist() {
    }

    public Specialist(User user, String specialization, Department department, Timetable timetable) {
        this.user = user;
        this.specialization = specialization;
        this.department = department;
        this.timetable = timetable;
    }

    public ArrayList<Appointment> getDailyAppointments(Date date) {
        if (date == null){
            date = new Date();
        }
        ArrayList<Appointment> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DailyTimetable todaysTimetable = timetable.getSpecificDayTimetable(calendar);
        if (todaysTimetable.getNotes().equalsIgnoreCase("Weekend")) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Appointment app :
                appointments) {
            if (dateFormat.format(app.getDateAndTime()).equals(dateFormat.format(date))) {
                result.add(app);
            }
        }
        return result;
    }

    public ArrayList<Appointment> getWeeklyAppointmentsSchema(Date firstDayDate) {
        ArrayList<Appointment> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayDate);
        calendar.getTime().setDate(calendar.getTime().getDay() - DateConverter.getDayOfWeek(calendar));
        Date dayStart = calendar.getTime();
        calendar.setTime(dayStart);
        for (int i = 0; i < 7; i++) {
            result.addAll(getDailyAppointmentsSchema(calendar.getTime()));
            calendar.getTime().setDate(calendar.getTime().getDay() + 1);
        }
        return result;
    }

    public ArrayList<Appointment> getDailyAppointmentsSchema(Date date) {
        ArrayList<Appointment> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DailyTimetable todaysTimetable = timetable.getSpecificDayTimetable(calendar);
        if (todaysTimetable.getNotes().equalsIgnoreCase("Weekend")) {
            return null;
        }
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
            result.add(new Appointment(null, this, (Date) appointmentDateAndTime.clone()));
            appointmentDateAndTime.setTime(appointmentDateAndTime.getTime() + todaysTimetable.getTimeForAppointment().getMinutes() * 60000);
        }
        return result;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public DailyTimetable getTodaysTimetable() {
        return timetable.getHodiernalTimetable();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
