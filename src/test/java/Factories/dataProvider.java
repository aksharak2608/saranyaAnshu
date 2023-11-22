package Factories;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class dataProvider {

    public static Object readConfigFile(String input)
    {
        try{
            Properties pro= new Properties();
            pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Testdata\\browserdetails.properties")));
           return  pro.get(input);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static String readExcel(String sheet, int row, int col)
    {
        try{
                File src = new File(System.getProperty("user.dir") + "\\Testdata\\exceldata.xlsx");
                FileInputStream fis = new FileInputStream(src);
                XSSFWorkbook wb= new XSSFWorkbook(fis);
               return wb.getSheet(sheet).getRow(row).getCell(col).toString();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
