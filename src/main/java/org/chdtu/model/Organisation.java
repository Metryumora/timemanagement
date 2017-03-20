package org.chdtu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Time;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class Organisation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Time startsWorking;

    @Column
    private Time endsWorking;

    @Column
    private short minutesForAppointment;

    @Column
    private User admin;

    public Organisation(String name, String address, Time startsWorking, Time endsWorking, short minutesForAppointment, User admin) {
        this.name = name;
        this.address = address;
        this.startsWorking = startsWorking;
        this.endsWorking = endsWorking;
        this.minutesForAppointment = minutesForAppointment;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
