/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao.impl;

import com.healthycorporation.dao.SalesRecordDAO;
import com.healthycorporation.entity.Customer;
import com.healthycorporation.entity.SalesRecord;
import java.sql.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class SalesRecordDAOImpl implements SalesRecordDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //this.session = this.sessionFactory.getCurrentSession();
    }

    @Override
    public SalesRecord findSalesRecordByCustomer(String customer,Date startTime,String classType) {
         String hql = "from SalesRecord as salesRecord where salesRecord.Customer = :customer and salesRecord.ClassType = :classType and salesRecord.StartDate<:startTime order by salesRecord.StartDate desc"; 
        Query query = sessionFactory.openSession().createQuery(hql);
        
        query.setString("customer", customer);
        query.setDate("startTime", startTime);
        query.setString("classType", classType);
        List<SalesRecord> list = query.list();
        
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<SalesRecord> getAllSalesRecod() {
        
        
        return null;
    }
    
    @Override
     public List<SalesRecord> getSalesRecordByCoacherAndDateRange(String cocaher,Date startTime,Date endTime){
         
          String hql = "from SalesRecord as salesRecord where salesRecord.Coacher = :coacher and salesRecord.SalesTime between :startTime and :endTime"; 
        Query query = sessionFactory.openSession().createQuery(hql);
        
        query.setString("coacher", cocaher);
        query.setDate("startTime", startTime);
        query.setDate("endTime",endTime);
        List<SalesRecord> list = query.list();
         
        return list;
     }
    
}
