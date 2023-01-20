package com.example.referalservice.entities.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class DateTimeUtil {
    public Date getStartOfDay(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return  calendar.getTime();
    }
    public Date getFirstDayOfMonth(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
         return calendar.getTime();
    }
}