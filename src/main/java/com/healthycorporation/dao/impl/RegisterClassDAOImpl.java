/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao.impl;

import com.healthycorporation.dao.RegisterClassDAO;
import com.healthycorporation.entity.ClassSummaryBO;
import com.healthycorporation.entity.RegisterClass;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class RegisterClassDAOImpl implements RegisterClassDAO{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //this.session = this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public RegisterClass addRegisterClass(RegisterClass regClass) {
        sessionFactory.openSession().saveOrUpdate(regClass);
        return regClass;
    }

    @Override
    public List<RegisterClass> findRegisterClassByCustomer(String customer) {
       
        return null;
    }

    
    @Override
    public int queryRegisterClassWithCurrentWeek(String customer, Date startDate){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and YEARWEEK(date_format('"+beginDateStr+"','%Y-%m-%d')) = YEARWEEK(classTime) and Customer = '"+customer+"'";
        Object result = sessionFactory.openSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
       
    }
    
    @Override
    public int queryRegisterClassWithCurrentMonth(String customer, Date startDate){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and month(date_format('"+beginDateStr+"','%Y-%m-%d')) = month(classTime) and Customer='"+customer+"'";
        Object result = sessionFactory.openSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
    }
    
    @Override
    public int queryRegisterClassNumberByCustomerAndDateRange(String customer, Date startDate,Date endDate){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        String endDateStr = format.format(endDate);
        
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and Customer'"+customer+"' and startDate <'"+startDate+"' and endDate <'"+endDate+"'";
        Object result = sessionFactory.openSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
        
    }
    
    @Override
    public List<String> queryRegisterClassCustomerNames(Date startDate,Date endDate){
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        String endDateStr = format.format(endDate);
        
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and startDate <'"+startDate+"' and endDate <'"+endDate+"'";
        
        return (List<String>)sessionFactory.openSession().createQuery(hql).list();
        
    }
    
    @Override
    public int queryRegisterClassWithCurrentYear(String customer, Date startDate){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = format.format(startDate);
        
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and year(date_format('"+beginDateStr+"','%Y-%m-%d')) = year(classTime) and Customer='"+customer+"'";
        Object result = sessionFactory.openSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
    }
    
    public RegisterClass findRegisterClassBySignature(String signature){
        String hql = "from RegisterClass where Signature = '"+signature+"'";
        Object result = sessionFactory.openSession().createQuery(hql).uniqueResult();
        return (RegisterClass)result;
    }
    
    public void deleteRegisterClassBySignature(String signature){
        RegisterClass registerClass = findRegisterClassBySignature(signature);
        registerClass.setDeleteFlag(true);
        sessionFactory.openSession().update(registerClass);
        
        
    }

    @Override
    public int queryAllRegisterClassByCustomer(String customer) {
        String hql = "select count(*) from RegisterClass where deleteFlag <> '1' and Customer='"+customer+"' group by Customer";
        Object result = sessionFactory.openSession().createQuery(hql).uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public List<String> getCoacherNameList() {
        
        String hql = "select distinct Coacher from RegisterClass where deleteFlag =0";
        Query query = sessionFactory.openSession().createQuery(hql);
        
        List<String> results = query.list();
        
        return results;
        
 
    }

    @Override
    public List<RegisterClass> getRegisterClassesByDateRange(Date startTime, Date endTime,String coacher) {
        
        String hql = "from RegisterClass registerClass where registerClass.Coacher = :coacher and registerClass.classTime between :startDate and :endDate and registerClass.deleteFlag = 0";
        
        Query query = sessionFactory.openSession().createQuery(hql);
        
        query.setDate("startDate",startTime);
        query.setDate("endDate", endTime);
        query.setString("coacher", coacher);
        
         List<RegisterClass> regClasses = query.list();
        
         return regClasses;
        
        
       
    }
    
    @Override
    public List<ClassSummaryBO> getSummaryRegisterClassByDateRange(Date startTime,Date endTime,String coacher){
        String sql = "select Customer,place,ClassType,count(*) as classCount from T_RegisterClass registerClass where registerClass.Coacher = :coacher and registerClass.classTime between :startDate and :endDate and registerClass.deleteFlag = 0 group by Customer,place,ClassType";
        
         //Query query = sessionFactory.openSession().createSQLQuery(sql).addEntity(ClassSummaryBO.class);
         Query query = sessionFactory.openSession().createSQLQuery(sql);
        
        query.setDate("startDate",startTime);
        query.setDate("endDate", endTime);
        query.setString("coacher", coacher);
        
        //List<ClassSummaryBO> regSummary = query.list();
        
        List<ClassSummaryBO> regSummarys = new ArrayList<ClassSummaryBO>();
        List results = query.list();
        
        for(Object obj:results){
            ClassSummaryBO sbo = new ClassSummaryBO();
            Object[] record = (Object[])obj;
            sbo.setCustomer(String.valueOf(record[0]));
            sbo.setPlace(String.valueOf(record[1]));
            sbo.setClassType(String.valueOf(record[2]));
            sbo.setClassCount(Integer.parseInt(String.valueOf(record[3])));
            regSummarys.add(sbo);
        }
        
        return regSummarys;
        
        
    }
    
}
