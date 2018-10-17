package com.apt.truyenmvc.utils;

import java.time.*;
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

    public static String betweenTwoDays(Date createDate) {
        LocalDateTime startDate = createDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDate startLocalDate = createDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime endDate = getCurrentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDate endLocalDate = getCurrentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long differentInSeconds = Duration.between(startDate, endDate).getSeconds();
        long differentInMinutes = Duration.between(startDate, endDate).toMinutes();
        long differentInHours = Duration.between(startDate, endDate).toHours();
        long differentInDays = Period.between(startLocalDate, endLocalDate).getDays();
        long differentInMonths = Period.between(startLocalDate, endLocalDate).getMonths();
        long differentInYears = Period.between(startLocalDate, endLocalDate).getYears();
        if (differentInYears > 0)
            return differentInYears + " năm";
        if (differentInMonths > 0)
            return differentInMonths + " tháng";
        if (differentInDays > 0)
            return differentInDays + " ngày";
        if (differentInHours > 0)
            return differentInHours + " giờ";
        if (differentInMinutes > 0)
            return differentInMinutes + " phút";
        return differentInSeconds + " giây";
    }
}
