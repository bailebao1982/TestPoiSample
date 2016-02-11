/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.poisample;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author wewezhu
 */
public class TestDataGenerator {
    public static List<RegisterClass> getRegisterClasses(){
        List<RegisterClass> classes = new ArrayList<RegisterClass>();
        
        classes.add(new RegisterClass("何荟","Chen.li.li","工作室",Date.valueOf("2015-12-4"),Time.valueOf("19:32:00"),"ddddd"));
        classes.add(new RegisterClass("何荟","cai.ji.min","工作室",Date.valueOf("2015-12-7"),Time.valueOf("12:32:00"),"ddddd"));
        
        return classes;
    }
    
    public static HashMap<String,String> getNamMap(){
        HashMap<String,String> nameMap = new HashMap<String,String>();
        
       nameMap.put("cai.ji.min","蔡继敏");
       nameMap.put("Chen.li.li","陈莉莉");
       nameMap.put("chen.zhi.qiang","陈志强");
       nameMap.put("ding.xiao.jiao", "丁小皎");
       nameMap.put("gao.jie.jie", "高洁洁");
       
       return nameMap;
    }
    
    public static HashMap<String,HSSFCellStyle> getCellStyleMap(Workbook workbook){
        HashMap<String,HSSFCellStyle> cellStyleMap = new HashMap<String,HSSFCellStyle>();
        
        HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
        style.setFillBackgroundColor(HSSFColor.AQUA.index);
        HSSFCellStyle style1 = (HSSFCellStyle) workbook.createCellStyle();
        style1.setFillBackgroundColor(HSSFColor.BROWN.index);
        
        cellStyleMap.put("工作室", style);
        cellStyleMap.put("会员提供场地", style1);
        
        return cellStyleMap;
        
    }
}
