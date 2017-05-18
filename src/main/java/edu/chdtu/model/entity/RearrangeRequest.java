package edu.chdtu.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Metr_yumora on 28.03.2017.
 */
@Entity
public class RearrangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne(targetEntity = User.class)
    private User initiator;

    @ManyToOne(targetEntity = Appointment.class)
    private Appointment appointment;

    //Appointment will be rearranged to this date and time
    private Date newTime;

    //True means accepted, false means rejected, null means pending request
    @Column
    private boolean status;


    public RearrangeRequest(User initiator, Appointment appointment, Date newTime, boolean status) {
        this.initiator = initiator;
        this.appointment = appointment;
        this.newTime = newTime;
        this.status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }

    public User getInitiator() {
        return initiator;
    }

    public void setInitiator(User initiator) {
        this.initiator = initiator;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
