package com.blueprint.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class LocalDateTimeUtils {

    /**
     * java.util.Date 转换为 java.time.LocalDateTime
     * @param date java.util.Date
     * @return  java.time.LocalDateTime
     */
    public static LocalDateTime convertDateToLocalDateTime(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * java.time.LocalDateTime 转换为 java.util.Date
     * @param time java.time.LocalDateTime
     * @return java.util.Date
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime time){
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     *  获取指定时间的 毫秒
     * @param time java.time.LocalDateTime
     * @return java.lang.Long
     */
    public Long getMilliByTime(LocalDateTime time){
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 时间格式化 转化成指定格式的字符串
     * @param time java.time.LocalDateTime
     * @param pattern 时间格式 例：YYYY-MM-dd HH:mm:ss
     * @return java.lang.String
     */
    public static String formatLocalDateTimeToString(LocalDateTime time,String pattern){
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将当前时间转化为指定格式的字符串
     * @param pattern 时间格式 例：YYYY-MM-dd HH:mm:ss
     * @return java.lang.String
     */
    public static String formatCurrentTime(String pattern){
        return formatLocalDateTimeToString(LocalDateTime.now(),pattern);
    }

    /**
     * 时间加上一个数，field 参数不同，加的值不同
     * @param time java.time.LocalDateTime
     * @param number 加数
     * @param field {@link java.time.temporal.ChronoUnit}
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field){
        return time.plus(number,field);
    }

    /**
     * 时间减去一个数，field 参数不同，减的值不同
     * @param time java.time.LocalDateTime
     * @param number 减数
     * @param field {@link java.time.temporal.ChronoUnit}
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime minus(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 计算时间差，field 参数不同，获取到的值不同
     * @param startTime java.time.LocalDateTime 开始时间
     * @param endTime java.time.LocalDateTime 结束时间
     * @param field java.time.temporal.ChronoUnit
     * @return long 时间差
     */
    public static long betweenTwoTimes(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field){
        Period period = Period.between(LocalDate.from(startTime),LocalDate.from(endTime));
        if(field == ChronoUnit.YEARS){
            return period.getYears();
        }
        if(field == ChronoUnit.MONTHS){
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime,endTime);
    }

    /**
     * 获取指定天的开始时间
     * @param time java.time.LocalDateTime
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getDayStart(LocalDateTime time){
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    /**
     * 获取指定天的结束时间
     * @param time java.time.LocalDateTime
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getDayEnd(LocalDateTime time){
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

}
