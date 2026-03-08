package utilities;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getTestData(String sheetName){

        Object[][] data = null;

        try{

            FileInputStream file =
                    new FileInputStream("testdata/TestData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(file);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows-1][cols];

            for(int i=1;i<rows;i++){

                for(int j=0;j<cols;j++){

                    XSSFCell cell = sheet.getRow(i).getCell(j);

                    if(cell==null){

                        data[i-1][j] = "";

                    }

                    else{

                        data[i-1][j] = cell.toString();

                    }

                }

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return data;

    }

}