package edu.chdtu.timemanagement.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

    public Timetable(List<DailyTimetable> timetables, Date applyingDate, Date expiringDate) {
        this.timetables = timetables;
        this.applyingDate = applyingDate;
        this.expiringDate = expiringDate;
    }

    public Timetable() {
    }

    public DailyTimetable getSpecificDayTimetable(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY: {
                return timetables.get(0);
            }
            case TUESDAY: {
                return timetables.get(1);
            }
            case WEDNESDAY: {
                return timetables.get(2);
            }
            case THURSDAY: {
                return timetables.get(3);
            }
            case FRIDAY: {
                return timetables.get(4);
            }
            case SATURDAY: {
                return timetables.get(5);
            }
            case SUNDAY: {
                return timetables.get(6);
            }
            default:
                return null;
        }
    }

    public DailyTimetable getSpecificDayTimetable(Calendar calendar) {
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY: {
                return timetables.get(0);
            }
            case Calendar.TUESDAY: {
                return timetables.get(1);
            }
            case Calendar.WEDNESDAY: {
                return timetables.get(2);
            }
            case Calendar.THURSDAY: {
                return timetables.get(3);
            }
            case Calendar.FRIDAY: {
                return timetables.get(4);
            }
            case Calendar.SATURDAY: {
                return timetables.get(5);
            }
            case Calendar.SUNDAY: {
                return timetables.get(6);
            }
            default:
                return null;
        }
    }

    public DailyTimetable getHodiernalTimetable() {
        return getSpecificDayTimetable(new GregorianCalendar());
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
