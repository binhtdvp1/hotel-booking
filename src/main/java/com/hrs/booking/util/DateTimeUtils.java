package com.hrs.booking.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    public static long dateDiff(Date fromDate, Date toDate) {
        long diffInMillis = Math.abs(toDate.getTime() - fromDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    public static Date clearTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
