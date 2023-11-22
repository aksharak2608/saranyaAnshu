package Factories;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.helper;

public class Baseclass {
public static  ExtentReports reports;
public static ExtentTest logger;

public static WebDriver driver;

@BeforeSuite
    public void statusReport()
{
    System.out.println("suite started");
    ExtentSparkReporter spark= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+ helper.dateformate()+"learning.html");
    reports= new ExtentReports();
    reports.attachReporter(spark);

}
@BeforeMethod
public void startTest()
{
    System.out.println("start test");
}
@AfterMethod
    public void resultResponse(ITestResult result)
{
    System.out.println("complete test");
    int status=result.getStatus();
    if(status==ITestResult.SUCCESS)
    {
        logger.log(Status.PASS,"Test Passed");
    }
    else if(status==ITestResult.FAILURE)
    {
        logger.log(Status.FAIL,"Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(helper.screenshot(driver)).build());

    }
    else if(status==ITestResult.SKIP)
    {
        logger.log(Status.SKIP,"Test Skip");
    }
    reports.flush();

}
    @BeforeClass
    public void startSession()
    {
        System.out.println("browser launched");
        String browser=dataProvider.readConfigFile("browser").toString();
        String url=dataProvider.readConfigFile("url").toString();
        System.out.println("launching "+browser+" browser");

        driver=BrowserFactory.startBrowser(browser, url);
    }

    @AfterClass
    public void endSession()
    {
        BrowserFactory.closeBrowser(driver);
    }






   //
}
