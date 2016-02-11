/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.poisample;

import com.healthycorporation.utils.DateUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author wewezhu
 */
public class TestPoiGenerator {
    public static void main(String[] args) throws IOException, FileNotFoundException, InvalidFormatException{
        Date startDate = Date.valueOf("2016-01-30");
        ApplicationContext factory = new FileSystemXmlApplicationContext( "src/main/java/com/healthycorporation/config/spring-*.xml"); 
        PoiGenerator poiGen = new PoiGenerator(DateUtils.getStartDate(startDate),DateUtils.getEndDate(startDate));
        poiGen.setFactory(factory);
        poiGen.generateReport();
    }
}
