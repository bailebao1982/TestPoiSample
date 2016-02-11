/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao;

import com.healthycorporation.entity.Customer;

/**
 *
 * @author wewezhu
 */
public interface CustomerDAO {

    Customer addCustomer(Customer customer);

    Customer findCustomerById(String customerId);

    Customer findCustomerByName(String name);

    boolean removeCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
    
}
