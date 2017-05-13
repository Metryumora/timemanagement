package edu.chdtu.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    private User client;

    @ManyToOne(targetEntity = Specialist.class)
    private Specialist specialist;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTime;

    public Appointment() {
    }

    public Appointment(User client, Specialist specialist, Date dateAndTime) {
        this.client = client;
        this.specialist = specialist;
        this.dateAndTime = dateAndTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
