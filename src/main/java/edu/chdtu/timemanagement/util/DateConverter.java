package edu.chdtu.timemanagement.util;

import java.time.DayOfWeek;
import java.util.Calendar;

/**
 * Created by Metr_yumora on 29.05.2017.
 */
public class DateConverter {

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

}
