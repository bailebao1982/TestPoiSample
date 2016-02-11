/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.entity;

/**
 *
 * @author wewezhu
 */
public class ClassSummaryBO {
    private String customer;
    
    private String place;
    
    private String classType;
    
    private int classCount;
    
    private int classPrice;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }

    public int getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(int classPrice) {
        this.classPrice = classPrice;
    }
    
    
}
