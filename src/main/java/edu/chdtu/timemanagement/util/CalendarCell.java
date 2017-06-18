package edu.chdtu.timemanagement.util;

/**
 * Created by Metr_yumora on 18.06.2017.
 */
public class CalendarCell {
    private int day;
    private String status;

    public CalendarCell(int day, String status) {
        this.day = day;
        this.status = status;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
