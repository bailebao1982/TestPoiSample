/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao.impl;

import com.healthycorporation.dao.CustomerStatisicaDAO;
import com.healthycorporation.entity.CustomerStatisica;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class CustomerStatisicaDAOImpl implements CustomerStatisicaDAO{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public void generateCustomerStatic() {
        this.sessionFactory.openSession().createSQLQuery("{call fillCustomerUserClassStatic}");
        
    }

    @Override
    public List<CustomerStatisica> getCustomerStatiscia(String coacher) {
       String hql = "from CustomerStatisica where Coacher = :coacher"; 
        Query query = sessionFactory.openSession().createQuery(hql);
        
       query.setString("coacher", coacher);
        List<CustomerStatisica> list = query.list();
        
        return list; 
    }
    
}
