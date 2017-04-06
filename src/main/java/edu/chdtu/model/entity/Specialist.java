package edu.chdtu.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Metr_yumora on 22.03.2017.
 */
@Entity
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    @ManyToOne(targetEntity = User.class)
    private User user;

    @NotEmpty
    @Column
    private String specialization;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    @OneToOne(targetEntity = Timetable.class)
    private Timetable timetable;

    public Specialist() {
    }

    public Specialist(User user, String specialization, Department department, Timetable timetable) {
        this.user = user;
        this.specialization = specialization;
        this.department = department;
        this.timetable = timetable;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
