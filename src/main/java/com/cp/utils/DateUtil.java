/**
 * DateUtil.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2015-11-20 下午6:22:10
 */
package com.cp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具 Description:
 */
public class DateUtil
{
    /**
     * 获取当前时间对应的毫秒数
     * @return
     */
    public static Long nowLong()
    {
    	return System.currentTimeMillis();
    }

    /**
     * 当前时间是否在指定时间之间
     * @param beginDate 起始时间
     * @param endDate 结束时间
     * @return
     */
    public static boolean nowIn(Date beginDate, Date endDate)
    {
        return dateIn(new Date(), beginDate, endDate);
    }

    /**
     * 当前时间是否在指定时间之间
     * @param beginDate 起始时间 格式为: "yyyy-MM-dd hh:mm:ss"
     * @param endDate 结束时间 格式为: "yyyy-MM-dd hh:mm:ss"
     * @return
     */
    public static boolean nowIn(String beginDate, String endDate)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateIn(new Date(),sdf.parse(beginDate),sdf.parse(endDate));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 当前时间是否不在指定时间之间
     * @param beginDate 起始时间
     * @param endDate 结束时间
     * @return
     */
    public static boolean nowNotIn(Date beginDate, Date endDate)
    {
        return dateNotIn(new Date(), beginDate, endDate);
    }

    /**
     * 指定时间是否在指定时间之间
     * @param date 需要判断的指定时间
     * @param beginDate 起始时间
     * @param endDate 结束时间
     * @return
     */
    public static boolean dateIn(Date date, Date beginDate, Date endDate)
    {
        return date.getTime() >= beginDate.getTime()
            && date.getTime() <= endDate.getTime();
    }

    /**
     * 指定时间是否在指定时间之间，日期格式为: "yyyy-MM-dd hh:mm:ss"
     * @param date 需要判断的指定时间
     * @param beginDate 起始时间
     * @param endDate 结束时间
     * @return
     */
    public static boolean dateIn(String date, String beginDate, String endDate)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateIn(sdf.parse(date),sdf.parse(beginDate),sdf.parse(endDate));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 当前时间是否不在指定时间之间
     * @param date
     * @param beginDate
     * @param endDate
     * @return
     */
    public static boolean dateNotIn(Date date, Date beginDate, Date endDate)
    {
        return date.after(endDate) || date.before(beginDate);
    }
    /**
     * 获得指定时间的时间，即000-2400
     * @param datetime 指定时间
     * @return
     */
    public static Date getTime(Date datetime)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);
        cal.set(Calendar.YEAR, 0);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 0);
//        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();

    }
    public static Date getNowTime()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 0);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 0);
        return cal.getTime();
    }

    /**
     * 获得指定时间的日期
     * @param datetime 指定时间
     * @return
     */
    public static Date getDate(Date datetime)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();

    }
    /**
     * 获得第二天0时时间
     * @return
     */
    public static Date getNextDateZero()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();    	
    }
    /**
     * 返回当前时间加减天数的时间
     * @param interval 调整的天数，正数为当前日期上增加的天数，负数为减少的天数
     * @return 调整后的日期
     */
    public static Date getAfterDate(int interval)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, interval);
        return cal.getTime();    	
    }
    /**
     * 返回当前时间加减天数后的0时时间
     * @param interval 调整的天数，正数为当前日期上增加的天数，负数为减少的天数
     * @return 调整后的日期
     */
    public static Date getAfterDateZero(int interval)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, interval);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();    	
    }


    /**
     * 获得当天的日期
     * @return
     */
    public static Date getToday()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定日期加减小时
     * @param baseDate 基准日期
     * @param interval 调整的小时，正数为基准日期上增加的小时数，负数为减少的小时数
     * @return 调整后的日期
     */
    public static Date hourAdjust(Date baseDate, int interval)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.add(Calendar.HOUR, interval);
        return cal.getTime();
    }
    /**
     * 指定日期加减分钟数
     * @param baseDate 基准日期
     * @param interval 调整的分钟数，正数为基准日期上增加的分钟数，负数为减少的分钟数
     * @return 调整后的日期
     */
    public static Date minuteAdjust(Date baseDate, int interval)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.add(Calendar.MINUTE, interval);
        return cal.getTime();
    }
    /**
     * 指定日期加减天数
     * @param baseDate 基准日期
     * @param interval 调整的天数，正数为基准日期上增加的天数，负数为减少的天数
     * @return 调整后的日期
     */
    public static Date dateAdjust(Date baseDate, int interval)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.add(Calendar.DATE, interval);
        return cal.getTime();
    }

    /**
     * 指定日期加减月份
     * @param baseDate 基准日期
     * @param interval 调整的月数，正数为基准日期上增加的月数，负数为减少的月数
     * @return
     */
    public static Date monthAdjust(Date baseDate, int interval)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.add(Calendar.MONTH, interval);
        return cal.getTime();
    }

    /**
     * 把当前时间按指定格式转成字串
     * @param date
     * @param pattern 日期格式
     * @return
     */
    public static String nowToString(String pattern)
    {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     * 把日期按指定格式转成字串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern)
    {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 把字符串转换成日期
     * @param dateStr
     * @return
     */
    public static Date StringToDate(String dateStr)
    {
        Date date = null;
        try
        {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 把字符串转成时间
     * @param timeStr
     * @return
     */
    public static Date StringToTime(String timeStr)
    {
        Date date = null;
        try
        {
            date = new SimpleDateFormat("HH:mm:ss").parse(timeStr);
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    	
    }

    /**
     * 指定时间与当前时间的时间差,返回结果最小单位为:分钟
     * @param date
     * @return
     */
    public static int calTime(Date date)
    {
        Date createTime = date;
        Date lastTime = new Date();
        int minuts;
        long temp = lastTime.getTime() - createTime.getTime();
        if (temp > 0)
        {
            minuts = (int) (temp / (60 * 1000));
        }
        else
        {
            minuts = 0;
        }
        return minuts;
    }
    // 
    /**
     * 两个时间之间的分钟数
     * @param HHmm1 如 2358
     * @param HHmm2 如 2210
     * @return 如果为负，则表示HHmm1小于HHmm2
     */
    public static int deltaMinutes(int HHmm1,int HHmm2)
    {
    	int HH1=HHmm1/100;
    	int mm1=HHmm1%100;
    	int HH2=HHmm2/100;
    	int mm2=HHmm2%100;
    	//if(HH1>HH2)//HHmm1<HHmm2
    	int transMinutes=(HH1-HH2)*60;
    	return mm1-mm2+transMinutes;     	
    }

    /**
     * 判断时间是否已经超过有效期
     * @param date
     * @return
     */
    public static boolean isChangeStatus(Date date, int effectiveTime)
    {
        int result = calTime(date);
        if (result > effectiveTime)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static final int ONE_MINUTE = 60 * 1000;
    private static final int ONE_HOUR = 60 * ONE_MINUTE;
    private static final int ONE_DAY = 24 * ONE_HOUR;

    // 时区偏量，单位毫秒，如东八区，为28800000，即8*3600
    private static final int TimeZoneOffset = TimeZone.getDefault()
        .getRawOffset();

    /**
     * 毫秒为单位的两个时间是否在同一天
     * @param d1 the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @param d2 the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return
     */
    private static boolean isSameDate(long d1, long d2)
    {
        // 按时区转成日后比较
        return (d1 + TimeZoneOffset) / ONE_DAY == (d2 + TimeZoneOffset)
            / ONE_DAY;
    }

    /**
     * 两个时间是否同一天
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameDate(Date d1, Date d2)
    {
        return isSameDate(d1.getTime(), d2.getTime());
    }

    /*
     * 指定时间是否今天
     */
    public static boolean isToday(Date date)
    {
        return isSameDate(System.currentTimeMillis(), date.getTime());
    }

    /**
     * 指定时间是否今天，同isToday
     * @param date
     * @return
     */
    public static boolean isThisDate(Date date)
    {
        return isToday(date);
    }

    /**
     * 指定时间是否为昨天
     * @param date
     * @return
     */
    public static boolean isYesterday(Date date)
    {
        return isSameDate(System.currentTimeMillis() - ONE_DAY, date.getTime());
    }

    /**
     * 两个时间是否同一小时
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameHour(Date d1, Date d2)
    {
        return d1.getTime() / ONE_HOUR == d2.getTime() / ONE_HOUR;
    }

    /**
     * 两个时间是否同一天
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameWeek(Date d1, Date d2)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        if (cal.get(Calendar.DAY_OF_WEEK) == 1)// 星期天，国外以星期天为每周的第一天
        {
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            cal.add(Calendar.DATE, -7);
        }
        else
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        Date monday = cal.getTime();
        cal.add(Calendar.DATE, 6);
        return dateIn(d2, monday, cal.getTime());
    }

    /**
     * 指定的两个时间是否在同一个月
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameMonth(Date d1, Date d2)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        int d1Year = cal.get(Calendar.YEAR);
        int d1Month = cal.get(Calendar.MONTH);
        cal.setTime(d2);
        int d2Year = cal.get(Calendar.YEAR);
        int d2Month = cal.get(Calendar.MONTH);
        return (d1Year == d2Year) && (d1Month == d2Month);
    }

    /**
     * 指定时间是否在当前月
     * @param date
     * @return
     */
    public static boolean isThisMonth(Date date)
    {
        return isSameMonth(new Date(), date);
    }

    /**
     * 指定时间是否在同一年
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameYear(Date d1, Date d2)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        int d1Year = cal.get(Calendar.YEAR);
        cal.setTime(d2);
        int d2Year = cal.get(Calendar.YEAR);
        return (d1Year == d2Year);
    }

    /**
     * 指定时间是否在今年
     * @param date
     * @return
     */
    public static boolean isThisYear(Date date)
    {
        return isSameYear(new Date(), date);

    }

    /**
     * 根据日期得到今天是星期几
     * @return
     */
    public static String getWeekOfDate(Date dt)
    {
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**
     * 把时间转换成HHmm整型格式，如2338
     * @param time
     * @return
     */
    public static int geHHmmInt(Date time)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        return hour*100+minute;
    }
    /**
     * 把时间转换成HHmmss整型格式，如233859
     * @param time
     * @return
     */
    public static int getHHmmssInt(Date time)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        return hour*10000+minute*100+second;
    }
    
    /**
     * 把日期转换成YYYYMMDD整型格式，如20181021
     * @param date
     * @return
     */
    public static int getYYYYMMDDInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        return year*10000+month*100+date1;
    }
    /**
     * 把日期转换成YYMMDD整型格式，如181021
     * @param date
     * @return
     */    
    public static int getYYMMDDInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year=cal.get(Calendar.YEAR)%100;
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        return year*10000+month*100+date1;
    }
    /**
     * 把日期转换成YYYYMMDDHH整型格式，如2018102123
     * @param date
     * @return
     * 整型最大值2147 48 36 47
     */
    
    public static int getYYYYMMDDHHInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        int hour=cal.get(Calendar.HOUR);
        return year*1000000+month*10000+date1*100+hour;
    	
    }
    /**
     * 把日期转换成YYMMDDHH整型格式，如18102123
     * @param date
     * @return
     */
    public static int getYYMMDDHHInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year=cal.get(Calendar.YEAR)%100;
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        int hour=cal.get(Calendar.HOUR);
        return year*1000000+month*10000+date1*100+hour;
        //整型最大2147 48 36 47
    	
    }
    /**
     * 把日期转换成YYYYMMDDHHmm整型格式，如2018 10212359
     * @param date
     * @return
     */
    
    public static long getYYYYMMDDHHmmInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        return year*100000000+month*1000000+date1*10000+hour*100+minute;
    	
    }
    /**
     * 把日期转换成YYMMDDHHmm整型格式，如1810212359
     * @param date
     * @return
     */
    
    public static long getYYMMDDHHmmInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long year=cal.get(Calendar.YEAR)%100;
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        return year*100000000+month*1000000+date1*10000+hour*100+minute;
    	
    }
    /**
     * 把日期转换成YYYYMMDDHHmmss整型格式，如20181021235948
     * @param date
     * @return
     * 
     */
    public static long getYYYYMMDDHHmmssInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        return year*10000000000L+month*100000000+date1*1000000+hour*10000+minute*100+second;
    	
    }
    /**
     * 把日期转换成YYMMDDHHmmss整型格式，如181021235948
     * @param date
     * @return
     * 
     */
    public static long getYYMMDDHHmmssInt(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long year=cal.get(Calendar.YEAR)%100;
        int month=cal.get(Calendar.MONTH);
        int date1=cal.get(Calendar.DATE);
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        return year*10000000000L+month*100000000+date1*1000000+hour*10000+minute*100+second;
    	
    }
}
