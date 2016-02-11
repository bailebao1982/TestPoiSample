package com.healthycorporation.utils;

import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wewezhu
 */
public class PoiUtils {
    public static CellStyle getTemplateHeaderStyle(Workbook wb){
     
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setShrinkToFit(true);
        
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        
        style.setLeftBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setRightBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setTopBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setBottomBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        
        
         Font font= wb.createFont();
         font.setColor(IndexedColors.OLIVE_GREEN.getIndex());
         font.setFontHeightInPoints((short)11);
         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
         
         style.setFont(font);
         return style;
    }
    
    public static CellStyle getRegisterClassFillCellStyle(Workbook wb, AddressStyle style){
        CellStyle cellStyle = wb.createCellStyle();
        Properties prop = new Properties();
        
        return cellStyle;
    }
    
    public static CellStyle getRegisterClassCellStyle(Workbook wb,String classType,String place){
        CellStyle style1 = wb.createCellStyle();
        
        if(place.equals("会员提供场地")){
        style1.setFillForegroundColor(IndexedColors.PLUM.getIndex());
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
          }else if(place.equals("和静工作室")){
              style1.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style1.setFillPattern(CellStyle.SOLID_FOREGROUND); 
             
          }
        
        style1.setShrinkToFit(true);
        
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        
        if(place.equals("会员提供场地")){
            style1.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
            style1.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
            style1.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
            style1.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        }else if(place.equals("和静工作室")){
             style1.setLeftBorderColor(IndexedColors.LIGHT_GREEN.getIndex());
            style1.setRightBorderColor(IndexedColors.LIGHT_GREEN.getIndex());
            style1.setTopBorderColor(IndexedColors.LIGHT_GREEN.getIndex());
            style1.setBottomBorderColor(IndexedColors.LIGHT_GREEN.getIndex());
        }
        
        if(classType.equals("OM")){
         Font font1=wb.createFont();
         font1.setColor(HSSFColor.DARK_RED.index);
         font1.setFontHeightInPoints((short)11);
         font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
         style1.setFont(font1);
        }else if(classType.equals("OO")){
            Font font1=wb.createFont();
         font1.setColor(HSSFColor.BLACK.index);
         font1.setFontHeightInPoints((short)11);
         font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
         style1.setFont(font1);
        }
        return style1;
    }
    
    
    public static CellStyle getTemplateFirstRowStyle(Workbook wb){
        CellStyle style1 = wb.createCellStyle();
        
        style1.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
        
        style1.setShrinkToFit(true);
        
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        
        style1.setLeftBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style1.setRightBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style1.setTopBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style1.setBottomBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        
         Font font1=wb.createFont();
         font1.setColor(HSSFColor.BLACK.index);
         font1.setFontHeightInPoints((short)11);
         font1.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
         style1.setFont(font1);
        
        return style1;
    }
}
