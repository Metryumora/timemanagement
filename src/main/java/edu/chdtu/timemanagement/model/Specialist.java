package edu.chdtu.timemanagement.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Metr_yumora on 22.03.2017.
 */
@Entity
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = User.class)
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
