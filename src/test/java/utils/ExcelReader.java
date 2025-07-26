package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public static List<Map<String, String>> read(String path, String sheetName) throws IOException {
        // to bring the data from file into the java program
        List<Map<String, String>> excelData = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            // there can be many sheets we are getting the sheet1 from Excel
            Sheet sheet = xssfWorkbook.getSheet(sheetName);
            // getting the number of actual rows that contains the data
            int noOfAcutualRowsWithData = sheet.getPhysicalNumberOfRows();
            // getting the row number 0 as we will be using this for all the maps as header
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i < noOfAcutualRowsWithData; i++) {
                // getting each row one by one from the map
                Row currentRow = sheet.getRow(i);
                // a new map for every row
                Map<String, String> rowMap = new LinkedHashMap<>();
                // the actual no of cells that contains the data in each row
                int noOfActualCellsWithData= currentRow.getPhysicalNumberOfCells();
                // a loop to go through all the cells
                for (int j = 0; j < noOfActualCellsWithData; j++) {
                    // from Header , we get the keys
                    String key = headerRow.getCell(j).toString();
                    // from current row we get the values
                    String value = currentRow.getCell(j).toString();
                    // store these keys and values in the map
                    rowMap.put(key, value);
                }
                // store each map in the list
                excelData.add(rowMap);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return excelData;


    }

    public static List<Map<String,String>> read (String sheetName) throws IOException {

        return read(Constants.EXCEL_FILE_PATH, sheetName);
    }
    public static List<Map<String, String>> read() throws IOException {
        return read(Constants.EXCEL_FILE_PATH, "Sheet1");
    }
}

