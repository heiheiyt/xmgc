package com.gem.xmgc.util;

/**
 * @author yt
 * @date 2019/11/5 20:59
 */
import java.time.*;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/*
 * @author kingboy
 * @Date 2017/7/22 下午2:12
 * @Description LocalDateTimeUtils is used to Java8中的时间类
 */
public class LocalDateTimeUtil {

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATETIME_FORMATTER =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    //Date转换为LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //LocalDateTime转换为Date
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    //获取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDateTime time,String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    //日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }

        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    //获取一天的开始时间，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    //获取一天的结束时间，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }
    /**
     * 获取当前系统时间
     * @return
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前系统日期
     * @return
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前系统日期时间
     * @return
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前系统时间字符串
     * @return
     */
    public static String getLocalTimeString() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    /**
     * 获取当前系统日期字符串
     * @return
     */
    public static String getLocalDateString() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 获取当前系统日期时间字符串
     * @return
     */
    public static String getLocalDateTimeString() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 字符串转LocalTime
     * @param time
     * @return
     */
    public static LocalTime  string2LocalTime(String time) {
        return LocalTime.parse(time, TIME_FORMATTER);
    }

    /**
     * 字符串转LocalDate
     * @param date
     * @return
     */
    public static LocalDate  string2LocalDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    /**
     * 字符串转LocalDateTime
     * @param dateTime
     * @return
     */
    public static LocalDateTime string2LocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIME_FORMATTER);
    }

    /**
     * Date转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    /**
     * Date转LocalDate
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    /**
     * Date转LocalDate
     * @param date
     * @return
     */
    public static LocalTime date2LocalTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalTime localTime = instant.atZone(zoneId).toLocalTime();
        return localTime;
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        return date;
    }

}