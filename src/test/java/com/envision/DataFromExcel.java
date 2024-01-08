package com.envision;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataFromExcel {
    @Test
    public void getDataFromBook2() throws IOException {
        //File input arrgument
        ArrayList<String> a = new ArrayList<String>();

        //FileInputStream fis=new FileInputStream("/Users/jhumamakal/Documents/envision leaning/Java/practicals/demo_test/testdata/Book1.xlsx");
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/testdata/Book2.xlsx");

        XSSFWorkbook workbook= new XSSFWorkbook(fis);

        int sheets=workbook.getNumberOfSheets();

        for(int i=0;i<sheets;i++){
            //System.out.println(workbook.getSheetName(i));
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {

                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows=sheet.iterator();
                Row firstrow=rows.next();
                Iterator<Cell> cell=firstrow.cellIterator();
                int k=0;
                int column=0;

                while (cell.hasNext()){
                    Cell value=cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
                        //desire colonm
                        column=k;
                    }
                    k++;

                }


                while(rows.hasNext()){
                    Row r=rows.next();
                    //purchase=testcaseName
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Login")){
                        Iterator<Cell> cv=r.cellIterator();
                        while (cv.hasNext()){

                            System.out.println(cv.next().getStringCellValue());
                        }
                    }
                }



            }


        }


    }


}


