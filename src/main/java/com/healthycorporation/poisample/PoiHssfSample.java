/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.poisample;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 *
 * @author wewezhu
 */
public class PoiHssfSample {
    
    public static void main(String[] args) throws Throwable {
        POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream("s.xlsx"));
        HSSFWorkbook wb = new HSSFWorkbook(fs); 
        
        int numberOfSheet = wb.getNumberOfSheets();
        System.out.println("Number of Sheet:"+ numberOfSheet);
        
        for(int i = 0;i<numberOfSheet;i++){
            HSSFSheet sheet = wb.getSheetAt(i);
            HSSFRow row = sheet.getRow(0);
            
            for(int j = 0;j<10;i++){
               HSSFCell cell = row.getCell(j);
               
               switch(cell.getCellType()){
                   case Cell.CELL_TYPE_BLANK:
                      System.out.println("blank type");
                       break;
                   case Cell.CELL_TYPE_NUMERIC:
                       if(DateUtil.isCellDateFormatted(cell)){
                           Date theDate = cell.getDateCellValue();
                           SimpleDateFormat  parseTime = new SimpleDateFormat("HH");
                           System.out.println("cell value:"+ parseTime.format(theDate));
                       }
                       
                       
                       break;
                   default:
                       System.out.println("Default type");
               }
              
            }
            
        }
        
        
    }
}
