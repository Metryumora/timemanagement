package org.chdtu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class Appointment {

    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private User user;

    @Column
    private Organisation organisation;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTime;

    public Appointment(User user, Organisation organisation, Date dateAndTime) {
        this.user = user;
        this.organisation = organisation;
        this.dateAndTime = dateAndTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
