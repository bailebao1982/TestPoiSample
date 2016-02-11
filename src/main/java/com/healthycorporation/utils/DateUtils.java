/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author wewezhu
 */
public class DateUtils {
     public static java.sql.Date getStartDate(Date currentDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        if(day<26&&day>=1){
            calendar.set(Calendar.DAY_OF_MONTH,26);
            calendar.set(Calendar.MONTH, month-1);
        }else{
            calendar.set(Calendar.DAY_OF_MONTH,26);
            calendar.set(Calendar.MONTH, month);
        }
        
        return new java.sql.Date(calendar.getTime().getTime());
    }
    
    public static java.sql.Date getEndDate(Date currentDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        if(day<26&&day>=1){
            calendar.set(Calendar.DAY_OF_MONTH,25);
            calendar.set(Calendar.MONTH, month);
        }else{
            calendar.set(Calendar.DAY_OF_MONTH,25);
            calendar.set(Calendar.MONTH, month+1);
        }
        
        return new java.sql.Date(calendar.getTime().getTime());
    }
    
     public static long dateDiff(java.sql.Date startDate,java.sql.Date endDate){
        long n1 = startDate.getTime();
        long n2 = endDate.getTime();
        long diff = Math.abs(n1 - n2);
        
        diff /= 3600 * 1000 * 24;
        return diff;
        
    }
}
