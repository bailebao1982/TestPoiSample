/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.poisample;

import com.healthycorporation.dao.RegisterClassDAO;
import com.healthycorporation.dao.SalesRecordDAO;
import com.healthycorporation.entity.SalesRecord;
import com.healthycorporation.dao.NameMapDAO;
import com.healthycorporation.entity.ClassSummaryBO;
import com.healthycorporation.entity.NameKeyValue;
import com.healthycorporation.utils.DateUtils;
import com.healthycorporation.utils.PoiUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author wewezhu
 */
public class PoiGenerator {

    private java.sql.Date startDate;

    private java.sql.Date endDate;

    private String reportName;

    private ApplicationContext factory;

    public HashMap<String, Integer> columnsMap = new HashMap<String, Integer>();

    public HashMap<String, Integer> rowsMap = new HashMap<String, Integer>();

    public HashMap<String, String> nameMap = new HashMap<String, String>();

    public ApplicationContext getFactory() {
        return factory;
    }

    public void setFactory(ApplicationContext factory) {
        this.factory = factory;
    }

    public PoiGenerator(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

      private void loadSheetHeader(Sheet sheet) {

        // in this place, read excel sheet.
        Row row = sheet.getRow(0);
        int processColumnNumber = 1;

        boolean columnShowStopFlag = true;
        do {
            Cell cell = row.getCell(processColumnNumber);
            if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                columnShowStopFlag = false;
            } else {
                String cellValue = getCellValueAsString(cell);
                columnsMap.put(cellValue, processColumnNumber);
                processColumnNumber++;
            }
        } while (columnShowStopFlag);

    }
    private static void generateRegisterSummaryTemplate(String coacher,Sheet sheet,java.sql.Date startDate, java.sql.Date endDate){
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("客户名称");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(1);
        cell.setCellValue("上课地点");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(2);
        cell.setCellValue("上课类型");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(3);
        cell.setCellValue("上课次数");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(4);
        cell.setCellValue("单次课时费");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
    }
    
    private static void generateSalesStaticTemplate(String coacher,Sheet sheet,java.sql.Date startDate,java.sql.Date endDate){
        Row row = sheet.createRow(0);
        
         Cell cell = row.createCell(0);
        cell.setCellValue("客户名称");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(1);
        cell.setCellValue("上课类型");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(2);
        cell.setCellValue("销售课程");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        cell = row.createCell(3);
        cell.setCellValue("付款方式");
        cell = row.createCell(4);
        cell.setCellValue("本月付款课程");
        cell = row.createCell(5);
        cell.setCellValue("课程单价");
        cell = row.createCell(6);
        cell.setCellValue("销售提成");
        
        
    }
    
    private static void generateClassStaticTemplate(String coacher,Sheet sheet,java.sql.Date startDate,java.sql.Date endDate) {
        //Create head row
        Row row = sheet.createRow(0);
        int column = 17;
        int startHour = 8;
      
         
        Cell cell = row.createCell(0);
        cell.setCellValue("日期/时间");
        cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        SimpleDateFormat  parseTime = new SimpleDateFormat("HH:mm");
        for(int i=1;i<column;i++){
           cell = row.createCell(i);
           //cell.setCellValue(endDate);
           StringBuffer sb =new StringBuffer();
           
           sb.append(startHour+++":00:00");
           cell.setCellValue(parseTime.format(Time.valueOf(sb.toString())));
           cell.setCellStyle(PoiUtils.getTemplateHeaderStyle(sheet.getWorkbook()));
        }
        
        //Create column
        int startRow = 1;
        
        SimpleDateFormat  parseDate = new SimpleDateFormat("YYYY/MM/dd");
        
        long dateDiff = DateUtils.dateDiff(startDate,endDate);
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(startDate);
        java.util.Date date = startDate;
        long day = 3600 * 1000 * 24;
          
        for(int j=0;j<=dateDiff;j++){
            row = sheet.createRow(startRow);
            Cell newCell = row.createCell(0);
            newCell.setCellValue(parseDate.format(date));
            date = new java.util.Date(date.getTime()+day);
            startRow++;
            newCell.setCellStyle(PoiUtils.getTemplateFirstRowStyle(sheet.getWorkbook()));
        }
        
    }

    private boolean removeFile(String filename) {
        File file = new File(filename);
        if(file.exists()){
            file.delete();
        }
        return true;
    }

    private void generateClassStaticReport(Sheet sheet,String coacher) throws FileNotFoundException, IOException, InvalidFormatException {
        RegisterClassDAO registerRec = (RegisterClassDAO) factory.getBean("registerClassDAO");

        //reportName = filename + "的私教工作记录" + startDate + "-" + endDate;
        //InputStream ins = new FileInputStream(new File(reportName));

        //Workbook wb = WorkbookFactory.create(ins);
        loadSheetFirsColumn(sheet);
        loadSheetHeader(sheet);
        loadNameMap();
        generateRegisterClassSheet(registerRec.getRegisterClassesByDateRange(startDate, endDate,coacher), sheet);
             //generateRegisterStaticSheet(registerRec.getRegisterClassesByDateRange(startDate, endDate),wb.getSheetAt(0));
        //wb.getSheetAt(0);

    }
    
    
    private void generateClassSummaryReport(Sheet sheet,String coacher){
        RegisterClassDAO registerRec = (RegisterClassDAO) factory.getBean("registerClassDAO");
        SalesRecordDAO salesDAO = (SalesRecordDAO)factory.getBean("salesRecordDAO");
        
        List<ClassSummaryBO> classSummaryBO = registerRec.getSummaryRegisterClassByDateRange(startDate, endDate, coacher);
        
        for(ClassSummaryBO summaryBO : classSummaryBO){
            System.out.println("SalesRecord:"+summaryBO.getCustomer());
            SalesRecord sr = salesDAO.findSalesRecordByCustomer(summaryBO.getCustomer(),endDate,summaryBO.getClassType());
            
            summaryBO.setClassPrice(sr.getUnitPrice());
        }
        
        generateRegisterSummarySheet(classSummaryBO,sheet);
        
    }
    
    private void generateClassSalesReport(Sheet sheet,String coacher){
        SalesRecordDAO salesDAO = (SalesRecordDAO)factory.getBean("salesRecordDAO");
        
        List<SalesRecord> recs = salesDAO.getSalesRecordByCoacherAndDateRange(coacher, startDate, endDate);
        
        generateSalesSummarySheet(recs,sheet);
        
    }

    private void loadNameMap() {
        NameMapDAO namesDao = (NameMapDAO) factory.getBean("nameMapDAO");
        List<NameKeyValue> recs = namesDao.getNames();
        for (NameKeyValue rec : recs) {
            this.nameMap.put(rec.getCustomer_id(), rec.getName());
        }
    }

    private void generateRegisterClassSheet(List<com.healthycorporation.entity.RegisterClass> classes, Sheet sheet) {
        SimpleDateFormat parseTime = new SimpleDateFormat("HH:00");
        SimpleDateFormat parseYearMonth = new SimpleDateFormat("YYYY/MM/dd");
        for (com.healthycorporation.entity.RegisterClass cls : classes) {
            String date = parseYearMonth.format(cls.getClassTime());
            String time = parseTime.format(cls.getTime());
            System.out.println("date:"+date);
            System.out.println("classType:"+cls.getClassType());
            System.out.println("place:"+cls.getPlace());
            System.out.println("time:"+time);
            System.out.println("cls:"+cls.getCoacher()+":"+cls.getCustomer()+":"+cls.getPlace()+":"+cls.getSignature());
            System.out.println(rowsMap.get(date));
            System.out.println(columnsMap.get(time));
            System.out.println(nameMap.get(cls.getCustomer()));
            
            setCellValue(rowsMap.get(date), columnsMap.get(time), nameMap.get(cls.getCustomer()),cls.getClassType(),cls.getPlace(), sheet);
        }

    }

    private void generateRegisterSummarySheet(List<com.healthycorporation.entity.ClassSummaryBO> classes, Sheet sheet) {
        int rowNum = 1;
        
        for(ClassSummaryBO summaryBO:classes){
            Row row = sheet.getRow(rowNum);
            if(row == null){
                row = sheet.createRow(rowNum);
            }
            Cell cell = row.getCell(0);
            if(cell == null){
                cell = row.createCell(0);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(this.nameMap.get(summaryBO.getCustomer()));
            }
            
            Cell cell1 = row.getCell(1);
            if(cell1 == null){
                cell1 = row.createCell(1);
                cell1.setCellType(Cell.CELL_TYPE_STRING);
                cell1.setCellValue(summaryBO.getPlace());
            }
            
            Cell cell2 = row.getCell(2);
            if(cell2 == null){
                cell2 = row.createCell(2);
                cell2.setCellType(Cell.CELL_TYPE_STRING);
                if(summaryBO.getClassType().equals("OO")){
                   cell2.setCellValue("私教一对一");
                }else if(summaryBO.getClassType().equals("OM")){
                    cell2.setCellValue("私教一对多");
                }
            }
            
            Cell cell3 = row.getCell(3);
            if(cell3 == null){
                cell3 = row.createCell(3);
                cell3.setCellType(Cell.CELL_TYPE_STRING);
                cell3.setCellValue(summaryBO.getClassCount());
            }
            
            Cell cell4 = row.getCell(4);
            if(cell4 == null){
                cell4 = row.createCell(4);
                cell4.setCellType(Cell.CELL_TYPE_STRING);
                cell4.setCellValue(summaryBO.getClassPrice());
            }
            
            rowNum++;
        }
    }
    
    private void generateSalesSummarySheet(List<com.healthycorporation.entity.SalesRecord> salesRecs, Sheet sheet){
         int rowNum = 1;
         
         for(SalesRecord rec:salesRecs){
             Row row = sheet.getRow(rowNum);
            if(row == null){
                row = sheet.createRow(rowNum);
            }
            
             Cell cell = row.getCell(0);
            if(cell == null){
                cell = row.createCell(0);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(this.nameMap.get(rec.getCustomer()));
            }
            
            Cell cell1 = row.getCell(1);
            if(cell1 == null){
                cell1 = row.createCell(1);
                cell1.setCellType(Cell.CELL_TYPE_STRING);
                if(rec.getClassType().equals("OO")){
                    cell1.setCellValue("私教一对一");
                }else if(rec.getClassType().equals("OM")){
                    cell1.setCellValue("私教一对多");
                }
            }
            
            Cell cell2 = row.getCell(2);
            if(cell2 == null){
                cell2 = row.createCell(2);
                cell2.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell2.setCellValue(rec.getClassNum());
            }
            
             Cell cell3 = row.getCell(5);
            if(cell3 == null){
                cell2 = row.createCell(5);
                cell2.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell2.setCellValue(rec.getUnitPrice());
            }
             
            rowNum++;
         }
        
    }

    private void setCellValue(int rowNum, int columnNum, String value,String classType,String place,Sheet sheet) {
        Row row = sheet.getRow(rowNum);
        int recColumnNum = columnNum;
        Cell cell = row.getCell(columnNum);
        
        if (cell == null) {
            cell = row.createCell(columnNum);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(value);
        } else {
            String val = cell.getStringCellValue();
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(val+","+value);
            
            
            /**
            do{
                columnNum--;
                cell = row.getCell(columnNum);
                if(cell == null){
                    cell = row.createCell(columnNum);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(value);
                    return;
                }
            }while(columnNum == 1);
            **/
            /**
            cell = row.getCell(recColumnNum);
           HSSFPatriarch patr=(HSSFPatriarch) sheet.createDrawingPatriarch();
            HSSFComment comment = patr.createCellComment(new HSSFClientAnchor(0, 0,0, 0, (short) 0, 0, (short) 3, 3));
            comment.setString(new HSSFRichTextString(value));
            cell.setCellComment(comment);
            **/
            
        }
        cell.setCellStyle(PoiUtils.getRegisterClassCellStyle(sheet.getWorkbook(), classType, place));

    }

    private void loadSheetFirsColumn(Sheet sheet) {
        boolean rowShowStopFlag = true;
        //from secondline to start working, the first line is headline.
        int processLineNumber = 1;
        do {
            // in this place, read excel sheet.
            Row row = sheet.getRow(processLineNumber);
            if (row == null) {
                break;
            }
            Cell cell = row.getCell(0);

            if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                rowShowStopFlag = false;
            } else {
                String cellValue = getCellValueAsString(cell);
                rowsMap.put(cellValue, processLineNumber);

            }

            processLineNumber++;
        } while (rowShowStopFlag);
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return String.valueOf(CellValueEnum.StopFlag);
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    java.util.Date theDate = cell.getDateCellValue();

                    SimpleDateFormat parseTime = new SimpleDateFormat("H");
                    SimpleDateFormat parseYear = new SimpleDateFormat("YYYY");
                    SimpleDateFormat parseYearMonth = new SimpleDateFormat("YYYY/MM/dd");
                    //System.out.println("cell value:"+ parseTime.format(theDate) +": "+parseYear.format(theDate));
                    String year = parseYear.format(theDate);

                    if ("1900".equals(year)) {
                        String time = parseTime.format(theDate);
                        return time;
                    } else {
                        String yearMonth = parseYearMonth.format(theDate);
                        return yearMonth;
                    }

                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            default:
                // System.out.println("Default type");
                return String.valueOf(CellValueEnum.NonSupport);
        }
    }

    public void generateReport() throws IOException, FileNotFoundException, InvalidFormatException {
        RegisterClassDAO registerRec = (RegisterClassDAO) factory.getBean("registerClassDAO");

        List<String> names = registerRec.getCoacherNameList();
        
        SimpleDateFormat parseYearMonth = new SimpleDateFormat("YYYYMMdd");
        for (String name : names) {
            
            reportName = name + "的私教工作记录" + parseYearMonth.format(startDate) + "-" + parseYearMonth.format(endDate)+".xls";
            Workbook wb;
            if (removeFile(reportName)) {
                FileOutputStream fos = new FileOutputStream(reportName);
                wb =  new HSSFWorkbook();
                Sheet sheet = wb.createSheet("上课情况记录");
                generateClassStaticTemplate(name,sheet,startDate,endDate);
                sheet = wb.createSheet("课程统计");
                generateRegisterSummaryTemplate(name,sheet,startDate,endDate);
                sheet = wb.createSheet("销售统计");
                generateSalesStaticTemplate(name,sheet,startDate,endDate);
                wb.write(fos);
                fos.flush();
                fos.close();
            }
            InputStream ins = new FileInputStream(new File(reportName));
            wb = WorkbookFactory.create(ins);
            Sheet sheet = wb.getSheet("上课情况记录");
            generateClassStaticReport(sheet,name);
            Sheet sheet1 = wb.getSheet("课程统计");
            generateClassSummaryReport(sheet1,name);
            Sheet sheet2 = wb.getSheet("销售统计");
            generateClassSalesReport(sheet2, name);
            FileOutputStream fos1 = new FileOutputStream(reportName);
            wb.write(fos1);
            fos1.flush();
            fos1.close();
        }

    }
}
