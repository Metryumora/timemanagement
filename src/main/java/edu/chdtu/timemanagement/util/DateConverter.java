package edu.chdtu.timemanagement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Metr_yumora on 29.05.2017.
 */
public class DateConverter {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private static final DateFormat timeFormat = new SimpleDateFormat("HH-mm");

    public static Integer getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getDayOfWeek(calendar);
    }


    public static Integer getDayOfWeek(Calendar calendar) {
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY: {
                return 0;
            }
            case Calendar.TUESDAY: {
                return 1;
            }
            case Calendar.WEDNESDAY: {
                return 2;
            }
            case Calendar.THURSDAY: {
                return 3;
            }
            case Calendar.FRIDAY: {
                return 4;
            }
            case Calendar.SATURDAY: {
                return 5;
            }
            case Calendar.SUNDAY: {
                return 6;
            }
            default:
                return null;
        }
    }

    public static Integer getDayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY: {
                return 0;
            }
            case TUESDAY: {
                return 1;
            }
            case WEDNESDAY: {
                return 2;
            }
            case THURSDAY: {
                return 3;
            }
            case FRIDAY: {
                return 4;
            }
            case SATURDAY: {
                return 5;
            }
            case SUNDAY: {
                return 6;
            }
            default:
                return null;
        }
    }

    public static Date mergeDateAndTime(Date date, Date time) {
        Date result = new Date();
        result.setTime(time.getTime());
        result.setYear(date.getYear());
        result.setMonth(date.getMonth());
        result.setDate(date.getDay());
        return result;
    }

    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    public static Date parseDate(String rawDate, String pattern) {
        DateFormat customDateFormat = new SimpleDateFormat(pattern);
        try {
            return customDateFormat.parse(rawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
