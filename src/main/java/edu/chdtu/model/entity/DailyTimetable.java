package edu.chdtu.model.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Entity
public class DailyTimetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private Time startsWorking;

    @Column
    private Time endsWorking;

    //Allows different intervals between appointments each day
    @Column
    private short minutesForAppointment;

    //The place of appointment like an address
    @Column
    private String place;

    //Notes from specialist about this day's appointment
    @Column
    private String notes;

    public DailyTimetable() {
    }

    public DailyTimetable(Time startsWorking, Time endsWorking, short minutesForAppointment, String place, String notes) {
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

    public Time getStartsWorking() {
        return startsWorking;
    }

    public void setStartsWorking(Time startsWorking) {
        this.startsWorking = startsWorking;
    }

    public Time getEndsWorking() {
        return endsWorking;
    }

    public void setEndsWorking(Time endsWorking) {
        this.endsWorking = endsWorking;
    }

    public short getMinutesForAppointment() {
        return minutesForAppointment;
    }

    public void setMinutesForAppointment(short minutesForAppointment) {
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
