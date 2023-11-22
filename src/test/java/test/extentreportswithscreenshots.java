package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import utility.helper;

public class extentreportswithscreenshots {
    public static void main(String[] args) {
        ExtentSparkReporter spark= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//reprt1.html");
        ExtentReports ext= new ExtentReports();
        ext.attachReporter(spark);
        WebDriver driver= helper.LaunchBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        ExtentTest test1= ext.createTest("this is my basic test");
       test1.log(Status.PASS,"pass");


        ExtentTest test2= ext.createTest("this is my basic test");
        test2.log(Status.FAIL,"fail");
       // test2.addScreenCaptureFromBase64String("C:\\Users\\suhar\\OneDrive\\Desktop\\workspace\\sepFramewrok\\screenshots\\abc09-11-2023-09-44-15.jpeg");



        ext.flush();
    }


}
