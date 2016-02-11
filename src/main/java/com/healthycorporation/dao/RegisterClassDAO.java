/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao;

import com.healthycorporation.entity.ClassSummaryBO;
import com.healthycorporation.entity.RegisterClass;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface RegisterClassDAO {
    RegisterClass addRegisterClass(RegisterClass regClass);
    
    List<RegisterClass> findRegisterClassByCustomer(String customer);
    
    RegisterClass findRegisterClassBySignature(String signature);
    
    void deleteRegisterClassBySignature(String signature);
   
    int queryRegisterClassWithCurrentWeek(String customer, Date startDate);
    
    int queryRegisterClassWithCurrentMonth(String customer, Date startDate);
    
     int queryRegisterClassWithCurrentYear(String customer, Date startDate);
     
     int queryAllRegisterClassByCustomer(String customer);
     
    List<String> getCoacherNameList();
    
    List<RegisterClass> getRegisterClassesByDateRange(Date startTime,Date endTime,String coacher);
    
    public int queryRegisterClassNumberByCustomerAndDateRange(String customer, Date startDate,Date endDate);
    
    public List<String> queryRegisterClassCustomerNames(Date startDate,Date endDate);
    
     public List<ClassSummaryBO> getSummaryRegisterClassByDateRange(Date startTime,Date endTime,String coacher);
}
