package test;

import Factories.dataProvider;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.helper;

import java.io.File;
import java.io.FileInputStream;

public class loginorangehrm {
    //WebDriver driver;

    @DataProvider(name="DP")
    public static String[][] readexceldata( ) {
        int rowcount=0;
        String credential[][] = new String[4][2];
        try {
            File src = new File(System.getProperty("user.dir") + "\\Testdata\\exceldata.xlsx");
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb= new XSSFWorkbook(fis);
            XSSFSheet sh=wb.getSheet("hrm");
            rowcount=sh.getPhysicalNumberOfRows();
            int r=0,c=0;
            for(int i=0;i<rowcount;i++)
            {
                XSSFRow r1=sh.getRow(i);
                XSSFCell c1=r1.getCell(0);
                String username=c1.toString();
                credential[i][0]=username;
                String password=r1.getCell(1).toString();
                System.out.println("username is "+username+" password is "+password);
                credential[i][1]=password;

            }


            for(int i=0;i<credential.length;i++)
            {
                for(int j=0;j<credential[i].length;j++)
                {
                    System.out.println(credential[i][j]);
                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return credential;
    }


@Test(dataProvider = "DP")
    public void login(String username, String password)
    {

        WebDriver driver= helper.LaunchBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver=helper.waitAndEnter(driver,By.xpath("//input[@name='username']"),username);

        driver=helper.waitAndEnter(driver,By.xpath("//input[@name='password']"),password);
        helper.screenshot(driver) ;
        driver=helper.waitAndClick(driver,driver.findElement(By.xpath("//button[text()=' Login ']")));
       Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");


       driver.quit();
    }

}
