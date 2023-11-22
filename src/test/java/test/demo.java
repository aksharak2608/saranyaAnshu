package test;

import Factories.dataProvider;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class demo {

    @Test

    public void readexceldata( ) {
        try {
            File src = new File(System.getProperty("user.dir") + "\\Testdata\\exceldata.xlsx");
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb= new XSSFWorkbook(fis);
            XSSFSheet sh=wb.getSheet("crm");
            XSSFRow r1=sh.getRow(0);
            XSSFCell c1=r1.getCell(0);
            System.out.println(c1);
        //   double a=c1.getNumericCellValue();
         //   System.out.println((int)a);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
@Test
    public void readdata( )
    {
       String a= dataProvider.readExcel("hrm",0,0).toString();
        String b= dataProvider.readExcel("hrm",0,1).toString();
       //int b=Integer.parseInt(dataProvider.readConfigFile("version").toString());

        System.out.println(a);
       System.out.println(b);
    }
}
