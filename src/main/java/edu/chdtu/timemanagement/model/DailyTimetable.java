package edu.chdtu.timemanagement.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Entity
public class DailyTimetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    @Temporal(TemporalType.TIME)
    private Date workStarts;

    @Column
    @Temporal(TemporalType.TIME)
    private Date workEnds;

    @Column
    @Temporal(TemporalType.TIME)
    private Date breakStarts;

    @Column
    @Temporal(TemporalType.TIME)
    private Date breakEnds;

    //Allows different intervals between appointments each day
    @Column
    @Temporal(TemporalType.TIME)
    private Date timeForAppointment;

    //The place of appointment like an address
    @Column
    private String place;

    //Notes from specialist about this day's appointments
    @Column
    private String notes;

    public DailyTimetable() {
    }

    public DailyTimetable(Time workStarts, Time workEnds, Time breakStarts, Time breakEnds, Time timeForAppointment, String place, String notes) {
        this.workStarts = workStarts;
        this.workEnds = workEnds;
        this.breakStarts = breakStarts;
        this.breakEnds = breakEnds;
        this.timeForAppointment = timeForAppointment;
        this.place = place;
        this.notes = notes;
    }

    public Time getWorkingTime() {
        return new Time(workEnds.getTime() - workStarts.getTime());
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getWorkStarts() {
        return workStarts;
    }

    public void setWorkStarts(Date workStarts) {
        this.workStarts = workStarts;
    }

    public Date getWorkEnds() {
        return workEnds;
    }

    public void setWorkEnds(Date workEnds) {
        this.workEnds = workEnds;
    }

    public Date getTimeForAppointment() {
        return timeForAppointment;
    }

    public void setTimeForAppointment(Date timeForAppointment) {
        this.timeForAppointment = timeForAppointment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getBreakStarts() {
        return breakStarts;
    }

    public void setBreakStarts(Date breakStarts) {
        this.breakStarts = breakStarts;
    }

    public Date getBreakEnds() {
        return breakEnds;
    }

    public void setBreakEnds(Date breakEnds) {
        this.breakEnds = breakEnds;
    }
}
