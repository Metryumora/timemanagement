package edu.chdtu.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    private Date startsWorking;

    @Column
    @Temporal(TemporalType.TIME)
    private Date endsWorking;

    //Allows different intervals between appointments each day
    @Column
    private Integer minutesForAppointment;

    //The place of appointment like an address
    @Column
    @NotEmpty
    private String place;

    //Notes from specialist about this day's appointment
    @Column
    private String notes;

    public DailyTimetable() {
    }

    public DailyTimetable(Date startsWorking, Date endsWorking, Integer minutesForAppointment, String place, String notes) {
        this.startsWorking = startsWorking;
        this.endsWorking = endsWorking;
        this.minutesForAppointment = minutesForAppointment;
        this.place = place;
        this.notes = notes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getStartsWorking() {
        return startsWorking;
    }

    public void setStartsWorking(Date startsWorking) {
        this.startsWorking = startsWorking;
    }

    public Date getEndsWorking() {
        return endsWorking;
    }

    public void setEndsWorking(Date endsWorking) {
        this.endsWorking = endsWorking;
    }

    public Integer getMinutesForAppointment() {
        return minutesForAppointment;
    }

    public void setMinutesForAppointment(Integer minutesForAppointment) {
        this.minutesForAppointment = minutesForAppointment;
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
}
