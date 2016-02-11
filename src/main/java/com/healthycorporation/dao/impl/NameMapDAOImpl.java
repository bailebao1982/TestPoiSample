/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao.impl;

import com.healthycorporation.dao.NameMapDAO;
import com.healthycorporation.entity.NameKeyValue;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class NameMapDAOImpl implements NameMapDAO{

     private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        //this.session = this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<NameKeyValue> getNames() {
        String hql = "from NameKeyValue"; 
        Query query = sessionFactory.openSession().createQuery(hql);
        
       
        List<NameKeyValue> list = query.list();
        
        return list; 
    }
    
}
