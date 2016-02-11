/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthycorporation.poisample;

import com.healthycorporation.utils.DateUtils;
import com.healthycorporation.utils.PoiUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author wewezhu
 */
public class PoiSxssfSample {

    /**
     * public static void main(String[] args) throws Throwable { SXSSFWorkbook
     * wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows
     * will be flushed to disk Sheet sh = wb.createSheet();
     *
     * for(int rownum = 0; rownum < 1000; rownum++){ Row row =
     * sh.createRow(rownum); for(int cellnum = 0; cellnum < 10; cellnum++){ Cell
     * cell = row.createCell(cellnum); String address = new
     * CellReference(cell).formatAsString(); cell.setCellValue(address); }
     *
     * }
     *
     * // Rows with rownum < 900 are flushed and not accessible for(int rownum
     * = 0; rownum < 900; rownum++){ Assert.assertNull(sh.getRow(rownum)); }
     *
     * // ther last 100 rows are still in memory for(int rownum = 900; rownum <
     * 1000; rownum++){ Assert.assertNotNull(sh.getRow(rownum)); }
     *
     * FileOutputStream out = new FileOutputStream("sxssf.xlsx"); wb.write(out);
     * out.close();
     *
     * // dispose of temporary files backing this workbook on disk
     * wb.dispose(); }*
     */
    public static void main(String[] args) throws Throwable {

        InputStream ins = null;
        Workbook wb = null;
        ins = new FileInputStream(new File("s1.xlsx"));
         FileOutputStream fos = new FileOutputStream("s2.xlsx");

        //wb = WorkbookFactory.create(ins);
        wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("hello");
        
        Date startDate = java.sql.Date.valueOf("2015-11-26");
        Date endDate = java.sql.Date.valueOf("2015-12-25");
       
        generateClassStaticTemplate("何荟",sheet,startDate,endDate);
        // ins.close();

        //int numberOfSheet = wb.getNumberOfSheets();
        //styleMap = TestDataGenerator.getCellStyleMap(wb);
        //System.out.println("Number of Sheet:" + numberOfSheet);
        
        /**
        PoiSxssfSample sample = new PoiSxssfSample();
        sample.loaderSheet(wb.getSheetAt(0));
        
        List<RegisterClass> classes = TestDataGenerator.getRegisterClasses();
        
        SimpleDateFormat parseTime = new SimpleDateFormat("H");
        SimpleDateFormat parseYear = new SimpleDateFormat("YYYY");
        SimpleDateFormat parseYearMonth = new SimpleDateFormat("YYYY-MM-DD");
        for(RegisterClass cls:classes){
            String date = parseYearMonth.format(cls.getClassTime());
            String time = parseTime.format(cls.getTime());
            System.out.println(sample.rowsMap.get(date));
            System.out.println(sample.columnsMap.get(time));
            System.out.println(sample.nameMap.get(cls.getCustomer()));
            sample.setCellValue(sample.rowsMap.get(date), sample.columnsMap.get(time), sample.nameMap.get(cls.getCustomer()),wb.getSheetAt(0));
        }
        * 
        * **/
        //java.sql.Time;
        wb.write(fos);
        fos.flush();
        fos.close();

        //System.out.println(sample.columnsMap);
        //System.out.println(sample.rowsMap);
        //System.out.println("end");
        /**
        for (int i = 0; i < 1; i++) {
            Sheet sheet = wb.getSheetAt(i);
            Row row = sheet.getRow(0);

            for (int j = 0; j < 10; j++) {
                Cell cell = row.getCell(j);

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BLANK:
                        System.out.println("blank type");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date theDate = cell.getDateCellValue();

                            SimpleDateFormat parseTime = new SimpleDateFormat("H");
                            SimpleDateFormat parseYear = new SimpleDateFormat("YYYY-MM");
                            System.out.println("cell value:" + parseTime.format(theDate) + ": " + parseYear.format(theDate));

                        }

                        break;
                    default:
                        System.out.println("Default type");
                }
            }

        } **/

    }

    public HashMap<String, Integer> columnsMap = new HashMap<String, Integer>();

    public HashMap<String, Integer> rowsMap = new HashMap<String, Integer>();

    public HashMap<String,String> nameMap = new HashMap<String,String>();
    
    public HashMap<String,HSSFCellStyle> styleMap = new HashMap<String,HSSFCellStyle>();
    
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
    
    private static void generateClassStaticTemplate(String coacher,Sheet sheet,Date startDate,Date endDate) {
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
        int columnBase = 0;
        
        SimpleDateFormat  parseDate = new SimpleDateFormat("YYYY/MM/dd");
        
        //long dateDiff = DateUtils.dateDiff(startDate,endDate);
        long dateDiff = 0;
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(startDate);
        Date date = startDate;
        long day = 3600 * 1000 * 24;
          
        for(int j=0;j<=dateDiff;j++){
            row = sheet.createRow(startRow);
            Cell newCell = row.createCell(0);
            newCell.setCellValue(parseDate.format(date));
            date = new Date(date.getTime()+day);
            startRow++;
            newCell.setCellStyle(PoiUtils.getTemplateFirstRowStyle(sheet.getWorkbook()));
        }
        
    }
    
   

    private void loadSheetFirsColumn(Sheet sheet) {
        boolean rowShowStopFlag = true;
        //from secondline to start working, the first line is headline.
        int processLineNumber = 1;
        do {
            // in this place, read excel sheet.
            Row row = sheet.getRow(processLineNumber);
            if(row == null)
                break;
            Cell cell = row.getCell(0);
            
            if (cell == null ||cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                rowShowStopFlag = false;
            } else {
                String cellValue = getCellValueAsString(cell);
                rowsMap.put(cellValue, processLineNumber);

            }

            processLineNumber++;
        } while (rowShowStopFlag);
    }
    
   
    

    public void loaderSheet(Sheet sheet) {
        loadSheetHeader(sheet);
        loadSheetFirsColumn(sheet);
        nameMap = TestDataGenerator.getNamMap();
    }

    public void setCellValue(int rowNum, int columnNum, String value,Sheet sheet) {
        Row row = sheet.getRow(rowNum);
        
        Cell cell = row.getCell(columnNum);
        
        if(cell == null){
            cell = row.createCell(columnNum);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(value);
        }else{
            
        }
       
    }

    public String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return String.valueOf(CellValueEnum.StopFlag);
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date theDate = cell.getDateCellValue();

                    SimpleDateFormat parseTime = new SimpleDateFormat("H");
                    SimpleDateFormat parseYear = new SimpleDateFormat("YYYY");
                    SimpleDateFormat parseYearMonth = new SimpleDateFormat("YYYY-MM-DD");
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

    public Row getRowByDate(Date registerClassDate) {

        return null;
    }

    public Cell getCellByValue(Date registerTime) {

        return null;
    }
}
