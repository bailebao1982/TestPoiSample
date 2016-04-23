/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.dao;

import com.healthycorporation.entity.CustomerStatisica;
import java.util.List;

/**
 *
 * @author wewezhu
 */
public interface CustomerStatisicaDAO {
    
    public void generateCustomerStatic();
    
    public List<CustomerStatisica> getCustomerStatiscia(String coacher);
}
