package com.envision;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xdgf.usermodel.XDGFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class DataProviderExcel {
    DataFormatter formatter=new DataFormatter();
    @Test(dataProvider = "driveTest")
    public void TestRunDeta(String greeting, String communication, String id){
        System.out.println(greeting+communication+id);

    }

    @DataProvider(name="driveTest")
    public Object[][] getDetaExcel() throws IOException {

        //Object[][] data={{},{},{}};
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/testdata/Book3.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();

        Object arraydata[][]=new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++){
            row=sheet.getRow(i+1);
            for(int j=0; j<colCount;j++)
            {
                XSSFCell cell=row.getCell(j);

                arraydata[i][j]= formatter.formatCellValue(cell);
            }

        }



        return arraydata;
    }

}
