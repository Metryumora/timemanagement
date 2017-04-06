package edu.chdtu.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Metr_yumora on 22.03.2017.
 */
@Entity
public class UnregisteredAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    @NotEmpty
    private String clientsFullName;

    @NotEmpty
    @ManyToOne(targetEntity = Specialist.class)
    private Specialist specialist;

    @Column
    @NotEmpty
    private Time startTime;

    @Column
    @NotEmpty
    private Time endTime;

    @Column
    @NotEmpty
    private Date date;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getClientsFullName() {
        return clientsFullName;
    }

    public void setClientsFullName(String clientsFullName) {
        this.clientsFullName = clientsFullName;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UnregisteredAppointment() {
    }

    public UnregisteredAppointment(String clientsFullName, Specialist specialist, Time startTime, Time endTime, Date date) {
        this.clientsFullName = clientsFullName;
        this.specialist = specialist;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }
}
