package org.chdtu.model.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Metr_yumora on 20.03.2017.
 */
@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    @ManyToOne(targetEntity = User.class)
    private User admin;

    public Organisation() {
    }

    public Organisation(String name, String address, Time startsWorking, Time endsWorking, short minutesForAppointment, User admin) {
        this.name = name;
        this.address = address;
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

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
