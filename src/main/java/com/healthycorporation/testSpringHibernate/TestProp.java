/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.testSpringHibernate;

import com.healthycorporation.utils.AddressStyle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author wewezhu
 */
public class TestProp {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("prop.properties");
        
        prop.load(fis);
        
        System.out.println(prop.get("message"));
        System.out.println(AddressStyle.CustomerPlace);
        System.out.println(AddressStyle.Office);
        
    }
}
