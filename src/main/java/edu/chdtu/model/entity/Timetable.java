package edu.chdtu.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Metr_yumora on 23.03.2017.
 */
@Entity
public class Timetable {

    @Id
    @GeneratedValue
    private int Id;

    //Contains set of timetables for each day
    @NotEmpty
    @OneToMany(targetEntity = DailyTimetable.class)
    private List<DailyTimetable> timetables = new ArrayList<>(7);

    //At this day timetable will be allowed to work with
    @Column
    private Date applyingDate;

    //After this day timetable will expire
    @Column
    private Date expiringDate;

    //Indicates whether it is possible to visit specialist without previous appointment
    @Column
    private boolean allowUnregistered;
    int day;
    public DailyTimetable getTodaysTimetable(){
        switch (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY: {
                day = 0;
                break;
            }
            case Calendar.TUESDAY: {
                day = 1;
                break;
            }
            case Calendar.WEDNESDAY: {
                day = 2;
                break;
            }
            case Calendar.THURSDAY: {
                day = 3;
                break;
            }
            case Calendar.FRIDAY: {
                day = 4;
                break;
            }
            case Calendar.SATURDAY: {
                day = 5;
                break;
            }
            case Calendar.SUNDAY: {
                day = 6;
                break;
            }
        }

        return timetables.get(day);
    }

    public Timetable(List<DailyTimetable> timetables, Date applyingDate, Date expiringDate) {
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

    public List<DailyTimetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<DailyTimetable> timetables) {
        this.timetables = timetables;
    }

    public boolean isAllowUnregistered() {
        return allowUnregistered;
    }

    public void setAllowUnregistered(boolean allowUnregistered) {
        this.allowUnregistered = allowUnregistered;
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
