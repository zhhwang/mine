package com.botany.mint.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 日期处理类
 */
public class DateUtil {

    public static String YYYYmmddTHHMMSS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String YYYYmmdd = "yyyyMMdd";

    /**
     * 转成对应格式
     *
     * @param time
     *            毫秒数
     * @return
     */
    public static String toYYYYmmddTHHMMSS(long time) {
        return new SimpleDateFormat(YYYYmmddTHHMMSS_FORMAT).format(new Date(time));
    }

    /**
     * 转成对应格式
     *
     * @param time
     *            毫秒数
     * @return
     */
    public static String toYYYYmmdd(long time) {
        return new SimpleDateFormat(YYYYmmdd).format(new Date(time));
    }

    /**
     * 转成毫秒
     *
     * @param date
     * @return
     */
    public static long parseYYYYmmdd(String date) {
        try {
            return new SimpleDateFormat(YYYYmmdd).parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取明天的0的时间对象
     *
     * @return
     */
    public static Date getNextDayBeginTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取今天的0时的时间戳
     *
     * @return 时间戳
     */
    public static long getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    /**
     * 获取某年某月的第一天毫秒数
     *
     * @param year
     * @param month
     * @return
     */
    public static long getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return cal.getTime().getTime();
    }

    /**
     * 获取某年某月的最后一天毫秒数
     *
     * @param year
     * @param month
     * @return
     */
    public static long getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime().getTime();
    }

    /**
     * 获取某年第一天毫秒数
     *
     * @param year
     *            年份
     * @return
     */
    public static long getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime().getTime();
    }

    /**
     * 获取某年最后一天毫秒数
     *
     * @param year
     *            年份
     * @return Date
     */
    public static long getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        return calendar.getTime().getTime();
    }

    /**
     * 获取前一年当天毫秒数
     *
     * @param millis
     *            毫秒数
     * @return
     */
    public static long getYearBefore(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        cal.add(Calendar.YEAR, -1);
        return cal.getTime().getTime();
    }
}
