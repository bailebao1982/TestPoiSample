/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.service.impl;

import com.healthycorporation.dao.CoacherDAO;
import com.healthycorporation.dao.CustomerDAO;
import com.healthycorporation.dao.CustomerGroupDAO;
import com.healthycorporation.dao.NameMapDAO;
import com.healthycorporation.dao.RegisterClassDAO;
import com.healthycorporation.dao.SalesRecordDAO;
import com.healthycorporation.dao.SignDAO;
import com.healthycorporation.dao.TrainingClassDAO;
import com.healthycorporation.entity.ClassSummaryBO;
import com.healthycorporation.entity.Coacher;
import com.healthycorporation.entity.Customer;
import com.healthycorporation.entity.RegisterClass;
import com.healthycorporation.entity.SalesRecord;
import com.healthycorporation.entity.TrainingClass;
import com.healthycorporation.service.ClassService;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


/**
 *
 * @author wewezhu
 */
public class ClassServiceImpl implements ClassService {
    
    private CoacherDAO coachDAO;
    
    private CustomerDAO customerDAO;
    
    private SignDAO signDAO;
    
    private TrainingClassDAO trainingClassDAO;
    
    private RegisterClassDAO registerClassDAO;
    
    private SalesRecordDAO  salesRecordDAO;
    
    private NameMapDAO nameMapDAO;
    
    private CustomerGroupDAO customerGroupDAO;

    public CustomerGroupDAO getCustomerGroupDAO() {
        return customerGroupDAO;
    }

    public void setCustomerGroupDAO(CustomerGroupDAO customerGroupDAO) {
        this.customerGroupDAO = customerGroupDAO;
    }

    public SalesRecordDAO getSalesRecordDAO() {
        return salesRecordDAO;
    }

    public void setSalesRecordDAO(SalesRecordDAO salesRecordDAO) {
        this.salesRecordDAO = salesRecordDAO;
    }

    
    
    public CoacherDAO getCoachDAO() {
        return coachDAO;
    }

    public void setCoachDAO(CoacherDAO coachDAO) {
        this.coachDAO = coachDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public NameMapDAO getNameMapDAO() {
        return nameMapDAO;
    }

    public void setNameMapDAO(NameMapDAO nameMapDAO) {
        this.nameMapDAO = nameMapDAO;
    }

    
    
    public SignDAO getSignDAO() {
        return signDAO;
    }

    public void setSignDAO(SignDAO signDAO) {
        this.signDAO = signDAO;
    }

    public TrainingClassDAO getTrainingClassDAO() {
        return trainingClassDAO;
    }

    public void setTrainingClassDAO(TrainingClassDAO trainingClassDAO) {
        this.trainingClassDAO = trainingClassDAO;
    }

    public RegisterClassDAO getRegisterClassDAO() {
        return registerClassDAO;
    }

    public void setRegisterClassDAO(RegisterClassDAO registerClassDAO) {
        this.registerClassDAO = registerClassDAO;
    }
    
    /**
     * 增加一个会员信息
     * 
     * @param coacherId
     * @param customerId
     * @return 
     */
    @Override
    public boolean newCustomer(String coacherId,String customerId){
        Coacher coacher = coachDAO.findCoaherById(coacherId);
        Customer customer = customerDAO.findCustomerById(customerId);
        
        customer.setCoacherId(coacherId);
        
        return true;
    }
    
    /**
     * 发起一个约课信息信息
     * @param coacherId
     * @param customerId
     * @param time
     * @return 
     */
    @Override
    public boolean newAppointment(String coacherId,String customerId,Date time){
        System.out.println("enter service.newAppointment");
        TrainingClass trainingClass = new TrainingClass();
        //trainingClass.setClassTime(time);
        trainingClass.setCoacher_ID(coacherId);
        trainingClass.setCustomer_ID(customerId);
        
        trainingClassDAO.addTrainingClass(trainingClass);
        
        //MessageService messageService = new MessageService();
        
        //String resMsg = "xxxxx";
        //messageService.sendMessage(resMsg, customerId);
        
        return true;
    }
    
    /**
     * 接受约课信息
     * @param coacherId
     * @param customerId
     * @param time
     * @return 
     */
    @Override
    public boolean acceptAppointment(String coacherId, String customerId,Date time){
        TrainingClass trainingClass = new TrainingClass();
        //trainingClass.setClassTime(time);
        trainingClass.setCoacher_ID(coacherId);
        trainingClass.setCustomer_ID(customerId);
        
        trainingClassDAO.addTrainingClass(trainingClass);
        
        //MessageService messageService = new MessageService();
        
        //String resMsg = "xxxxx";
        //messageService.sendMessage(resMsg, customerId);
        
        return true;
    }
    
    /**
     * 拒绝约课信息，提供拒绝理由
     * @param coacherId
     * @param customerId
     * @param time
     * @param reason
     * @return 
     */
    @Override
    public boolean denyAppointment(Long coacherId, Long customerId, Date time,String reason){
        //MessageService messageService = new MessageService();
        //String resMsg = "xxxxx";
        //messageService.sendMessage(resMsg, customerId);
        
        return true;
    }
    
    /**
     * 重排约课时间
     * @param apponitmentId
     * @param newTime
     * @return 
     */
    @Override
    public boolean resheduleAppointment(Long apponitmentId, Date newTime){
        //TrainingClass trainingClass = trainingClassDAO.findTrainingClassByCoacher(apponitmentId);
        
        
        return false;
    }
    
    /**
     * 教练取消预约课程
     * @param coacherId
     * @param appointmentId
     * @return 
     */
    @Override
    public boolean cancelAppointmentFromCoacher(Long coacherId,Long appointmentId){
        
        return false;
    }
    
    /**
     * 会员取消预约课程
     * @param customerId
     * @param appointmentId
     * @return 
     */
    @Override
    public boolean cancelAppointmentFromCustomer(Long customerId,Long appointmentId){
        return false;
    }
    
    /**
     * 会员签课
     * @param customerId
     * @param coacherId
     * @param appointmentId
     * @return 
     */
    @Override
    public boolean checkinClass(Long customerId, Long coacherId, Long appointmentId){
        return false;
    }

    @Override
    public boolean registerClass(String coacher, String customer, Date time,Time hourTime,String place,String signature) {
       RegisterClass regClass = new RegisterClass();
       regClass.setClassTime(time);
       regClass.setCoacher(coacher);
       regClass.setCustomer(customer);
       regClass.setPlace(place);
       regClass.setTime(hourTime);
       regClass.setSignature(signature);
       regClass.setDeleteFlag(false);
       registerClassDAO.addRegisterClass(regClass);
       
       return true;
    }

    @Override
    public int counterRegisterClassByNameRecentWeek(String coacher, Date currentTime) {
       
        return registerClassDAO.queryRegisterClassWithCurrentWeek(coacher, currentTime);
       
    }

    @Override
    public int counterRegisterClassByNameRecentMonth(String coacher, Date currentTime) {
        //Date weekAgo = new Date(currentTime.getTime()-1000*60*60*24*30);
        return registerClassDAO.queryRegisterClassWithCurrentMonth(coacher, currentTime);
    }

    @Override
    public int counterRegisterClassByNameRecentYear(String coacher, Date currentTime) {
       return registerClassDAO.queryRegisterClassWithCurrentYear(coacher, currentTime);
    }
    
    @Override
    public RegisterClass findRegisterClassBySignature(String signature){
        return registerClassDAO.findRegisterClassBySignature(signature);
    }
    
    @Override
    public void deleteRegisterClassBySignature(String signature){
         registerClassDAO.deleteRegisterClassBySignature(signature);
    }

    @Override
    public int getSalesRecordNumByCustomer(String customer,Date startDate) {
        SalesRecord salesRecord = salesRecordDAO.findSalesRecordByCustomer(customer,startDate,"OO");
        if(salesRecord!=null){
            return salesRecord.getClassNum();
        }else{
            return 0;
        }
    }

    @Override
    public int getCustomerAllRegisterClass(String customer) {
       return registerClassDAO.queryAllRegisterClassByCustomer(customer);
    }
    
    
    @Override
    public String findCustomerGroupNameByCustomerName(String Name) {
        
        return this.customerGroupDAO.findCustomerGroupNameByCustomerName(Name);
     
    }

    @Override
    public String[] findCustomersByCustomerGroupName(String GroupName) {
        
        return this.customerGroupDAO.findCustomersByCustomerGroupName(GroupName);
       
    }
    
    @Override
    public List<ClassSummaryBO> getRegisterClassSummaryByDateRange(Date startTime,Date endTime,String coacher){
        List<ClassSummaryBO> classSummaryBO = this.registerClassDAO.getSummaryRegisterClassByDateRange(startTime, endTime, coacher);
        
        for(ClassSummaryBO summaryBO : classSummaryBO){
            SalesRecord sr = this.getSalesRecordDAO().findSalesRecordByCustomer(summaryBO.getCustomer(),endTime,summaryBO.getClassType());
            summaryBO.setClassPrice(sr.getUnitPrice());
        }
        
        return classSummaryBO;
        
    }
    
}
