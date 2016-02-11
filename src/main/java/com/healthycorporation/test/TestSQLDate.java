/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.test;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author wewezhu
 */
public class TestSQLDate {
    public static void main(String[] args){
        Date date=new Date(System.currentTimeMillis());
        //System.out.println(date);
        //java.sql.Time time = new Time(System.currentTimeMillis());
        //SimpleDateFormat  parseTime = new SimpleDateFormat("HH:mm");
        // SimpleDateFormat  parseDate = new SimpleDateFormat("MM月dd日");
        //System.out.println(parseTime.format(time));
       
        //Time time =new Time();
        //System.out.println(parseDate.format(Date.valueOf("2015-12-4")));
        //System.out.println(parseTime.format(Time.valueOf("19:00:00")));
        
        //java.sql.Time time = new Time(System.currentTimeMillis());
         //date = new Date(System.currentTimeMillis());
        //System.out.println(date);
        //System.out.println(time);
        //System.out.println(new java.util.Date(1358323200000L));
        //System.out.println(getStartDate(Date.valueOf("2015-10-25")));
        //System.out.println(getEndDate(Date.valueOf("2015-10-25")));
        //System.out.println(getStartDate(Date.valueOf("2015-10-26")));
        //System.out.println(getEndDate(Date.valueOf("2015-10-26")));
        //System.out.println(getStartDate(Date.valueOf("2015-11-2")));
        //System.out.println(getEndDate(Date.valueOf("2015-11-2")));
        Date date1 = Date.valueOf("2015-12-07");
        Date date2 = Date.valueOf("2015-12-08");
        Time time = Time.valueOf("10:47:52");
        SimpleDateFormat parseYearMonth = new SimpleDateFormat("YYYY-MM-dd");
         SimpleDateFormat parseTime = new SimpleDateFormat("H:00");
           String timeStr = parseTime.format(time);
        String dateStr = parseYearMonth.format(date1);
        System.out.println(date2.getTime()-date1.getTime());
        
        
    }
    
    
     private static java.util.Date getStartDate(java.util.Date currentDate){
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
        
        return calendar.getTime();
    }
    
    private static java.util.Date getEndDate(java.util.Date currentDate){
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
        return calendar.getTime();
    }
}
