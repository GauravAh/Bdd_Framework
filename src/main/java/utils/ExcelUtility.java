package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility {

    private XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    static List<String> headerList;
    static HashMap<String,Object> hashMap;

    public ExcelUtility(String filePath, String sheetName){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            try {
                workbook = new XSSFWorkbook(fileInputStream);
                sheet = workbook.getSheet("sheet1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getHeaders(){
        XSSFRow headerRow = sheet.getRow(0);
        Iterator<Cell> headerCellVal = headerRow.cellIterator();
        headerList = new ArrayList<>();
        while (headerCellVal.hasNext()){
            Cell hCell = headerCellVal.next();
            headerList.add(hCell.getStringCellValue());
        }
        return headerList;
    }

    public static List<HashMap<String, Object>> getTestData(){
        List<HashMap<String, Object>> allData = new ArrayList<>();
        int totalRows = sheet.getPhysicalNumberOfRows();

        List<String> hList = getHeaders();
        for(int i = 1; i<totalRows; i++){
            XSSFRow dataRow = sheet.getRow(i);
            hashMap = new HashMap<>();
            int totaldataCells = dataRow.getPhysicalNumberOfCells();
            for(int j=0; j<totaldataCells; j++){
                String columnVal = hList.get(j);
                XSSFCell dataVal = dataRow.getCell(j);
                CellType getType = dataVal.getCellType();
                switch (getType){
                    case STRING -> dataVal.getStringCellValue();
                    case NUMERIC -> dataVal.getNumericCellValue();
                }
                hashMap.put(columnVal,dataVal);
            }
            allData.add(hashMap);
        }
        return allData;
    }

    public static Object[][] getDataProvider(){
        List<HashMap<String, Object>> hashMaps = getTestData();
        Object[][] ob = new Object[hashMaps.size()][1];
        for(int i=0; i<=hashMaps.size();i++){
            ob[i][0] = hashMaps.get(i);
        }
        return ob;
    }

}
