package com.apt.truyenmvc.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Huy Thang
 */
public class DateUtils {

    public static Date getFirstDayOfWeek() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }
        return java.sql.Timestamp.valueOf(monday.atStartOfDay());
    }

    public static Date getLastDayOfWeek() {
        LocalDate today = LocalDate.now();
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }
        return java.sql.Timestamp.valueOf(sunday.atStartOfDay());
    }

    public static Date getFirstDayOfMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstday = today.withDayOfMonth(1);
        return java.sql.Timestamp.valueOf(firstday.atStartOfDay());
    }

    public static Date getLastDayOfMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastday = today.withDayOfMonth(today.lengthOfMonth());
        return java.sql.Timestamp.valueOf(lastday.atStartOfDay());
    }

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}
