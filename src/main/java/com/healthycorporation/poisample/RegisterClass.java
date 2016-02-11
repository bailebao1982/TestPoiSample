/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.poisample;


import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author wewezhu
 */

public class RegisterClass {
   
    private String id;
     
    private String Coacher;

    private String Customer;

    private String place;

    private Date classTime;

    private Time time;
    
     private String Signature;

     private boolean deleteFlag;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public  RegisterClass(){
        
    }
    
    public RegisterClass(String coacher,String Customer,String place,Date classTime,Time time,String Signature){
        this.Coacher = coacher;
        this.Customer= Customer;
        this.place = place;
        this.classTime = classTime;
        this.Signature = Signature;
        this.time = time;
    }
     
    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }    
     
    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }
     
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoacher() {
        return Coacher;
    }

    public void setCoacher(String Coacher) {
        this.Coacher = Coacher;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
     
     
     
}
