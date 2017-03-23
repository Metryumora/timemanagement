package org.chdtu.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Entity
public class Timetable {

    @Id
    @GeneratedValue
    private int Id;

    //Contains set of timetables for each day
    @OneToMany(targetEntity = DailyTimetable.class)
    Set<DailyTimetable> timetables = new HashSet<>(7);

    //At this day timetable will be allowed to work with
    @Column
    private Date applyingDate;

    //After this day timetable will expire
    @Column
    private Date expiringDate;

    //Indicates whether it is possible to visit specialist without previous appointment
    @Column
    private boolean allowUnregistered;

    public Timetable(Set<DailyTimetable> timetables, Date applyingDate, Date expiringDate) {
        this.timetables = timetables;
        this.applyingDate = applyingDate;
        this.expiringDate = expiringDate;
    }

    public Timetable() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Set<DailyTimetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<DailyTimetable> timetables) {
        this.timetables = timetables;
    }

    public Date getApplyingDate() {
        return applyingDate;
    }

    public void setApplyingDate(Date applyingDate) {
        this.applyingDate = applyingDate;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }
}
