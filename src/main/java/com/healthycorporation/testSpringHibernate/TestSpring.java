/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.testSpringHibernate;

import com.healthycorporation.dao.CoacherDAO;
import com.healthycorporation.dao.CustomerDAO;
import com.healthycorporation.dao.RegisterClassDAO;
import com.healthycorporation.dao.SalesRecordDAO;
import com.healthycorporation.entity.Customer;
import com.healthycorporation.entity.SalesRecord;
import com.healthycorporation.dao.NameMapDAO;
import com.healthycorporation.poisample.RegisterClass;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author wewezhu
 */
public class TestSpring {
    
    public static void main(String[] args){
        //ApplicationContext factory = new ClassPathXmlApplicationContext( "spring-common.xml"); 
        ApplicationContext factory = new FileSystemXmlApplicationContext( "src/main/java/com/healthycorporation/config/spring-*.xml"); 
        //SalesRecordDAO salesRec = (SalesRecordDAO)factory.getBean("salesRecordDAO");
        
        RegisterClassDAO registerRec = (RegisterClassDAO)factory.getBean("registerClassDAO");
         //NameMapDAO namesDao = (NameMapDAO) factory.getBean("nameMapDAO");
        //SalesRecord customer = salesRec.findSalesRecordByCustomer("Shi.Yi.Ting");
        //List<String> names = registerRec.getCoacherNameList();
        //System.out.println(namesDao.getNames());
        Date startDate = Date.valueOf("2015-11-26");
        Date endDate = Date.valueOf("2015-12-25");
        
        //List<com.healthycorporation.entity.RegisterClass> regClasses = registerRec.getRegisterClassesByDateRange(startDate, endDate);
        
        //for(com.healthycorporation.entity.RegisterClass cls:regClasses){
        //   System.out.println(cls.getCoacher()+":"+cls.getCustomer()+":"+cls.getClassTime());
         //}
    }
}
