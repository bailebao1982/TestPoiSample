/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao;

import com.healthycorporation.entity.SalesRecord;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface SalesRecordDAO {
    SalesRecord findSalesRecordByCustomer(String customer,Date startTime,String classType);
    
    List<SalesRecord> getAllSalesRecod();
    
    List<SalesRecord> getSalesRecordByCoacherAndDateRange(String cocaher,Date startTime,Date endTime);
}
