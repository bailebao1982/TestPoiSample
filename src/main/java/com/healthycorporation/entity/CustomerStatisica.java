/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wewezhu
 */
@Entity
@Table(name="CustomerStatisica")
public class CustomerStatisica implements Serializable{
    @Column(length=30)
    @Id
    private String Customer;
    @Column(length=30)
    @Id
    private String ClassType;
    @Column(length=30)
    @Id
    private String Coacher;
    
    @Column
    private int Week1;
    
    @Column
    private int Week2;
    
    @Column
    private int Week3;
    
    @Column
    private int Week4;
    
    @Column
    private int Week5;
    
    @Column
    private int Week6;
    @Column
    private int Week7;
    @Column
    private int Week8;
    @Column
    private int Week9;
    @Column
    private int Week10;
    @Column
    private int Week11;
    @Column
    private int Week12;

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public String getClassType() {
        return ClassType;
    }

    public void setClassType(String ClassType) {
        this.ClassType = ClassType;
    }

    public String getCoacher() {
        return Coacher;
    }

    public void setCoacher(String Coacher) {
        this.Coacher = Coacher;
    }

    public int getWeek1() {
        return Week1;
    }

    public void setWeek1(int Week1) {
        this.Week1 = Week1;
    }

    public int getWeek2() {
        return Week2;
    }

    public void setWeek2(int Week2) {
        this.Week2 = Week2;
    }

    public int getWeek3() {
        return Week3;
    }

    public void setWeek3(int Week3) {
        this.Week3 = Week3;
    }

    public int getWeek4() {
        return Week4;
    }

    public void setWeek4(int Week4) {
        this.Week4 = Week4;
    }

    public int getWeek5() {
        return Week5;
    }

    public void setWeek5(int Week5) {
        this.Week5 = Week5;
    }

    public int getWeek6() {
        return Week6;
    }

    public void setWeek6(int Week6) {
        this.Week6 = Week6;
    }

    public int getWeek7() {
        return Week7;
    }

    public void setWeek7(int Week7) {
        this.Week7 = Week7;
    }

    public int getWeek8() {
        return Week8;
    }

    public void setWeek8(int Week8) {
        this.Week8 = Week8;
    }

    public int getWeek9() {
        return Week9;
    }

    public void setWeek9(int Week9) {
        this.Week9 = Week9;
    }

    public int getWeek10() {
        return Week10;
    }

    public void setWeek10(int Week10) {
        this.Week10 = Week10;
    }

    public int getWeek11() {
        return Week11;
    }

    public void setWeek11(int Week11) {
        this.Week11 = Week11;
    }

    public int getWeek12() {
        return Week12;
    }

    public void setWeek12(int Week12) {
        this.Week12 = Week12;
    }
    
    public int getWeekValue(int cellValue){
        if(cellValue == 1){
            return this.getWeek12();
        }else if(cellValue == 2){
            return this.getWeek11();
        }else if(cellValue == 3){
            return this.getWeek10();
        }else if(cellValue == 4){
            return this.getWeek9();
        }else if(cellValue == 5){
            return this.getWeek8();
        }else if(cellValue == 6){
            return this.getWeek7();
        }else if(cellValue == 7){
            return this.getWeek6();
        }else if(cellValue == 8){
            return this.getWeek5();
        }else if(cellValue == 9){
            return this.getWeek4();
        }else if(cellValue == 10){
            return this.getWeek3();
        }else if(cellValue == 11){
            return this.getWeek2();
        }else if(cellValue == 12){
            return this.getWeek1();
        }else{
            return 0;
        }
    }
}
