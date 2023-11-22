package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class helper {
  public static WebDriver LaunchBrowser(String url)
  {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
        WebDriver driver= new ChromeDriver( new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get(url);
        driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
      return driver;
  }

public static  String dateformate()
{
    DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-ss");
    LocalDateTime lt = LocalDateTime.now();
  return (String) dt.format(lt);
}
  public static String screenshot(WebDriver driver)
  {
      try {
          TakesScreenshot ts = ((TakesScreenshot) driver);
          File src = ts.getScreenshotAs(OutputType.FILE);
          File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+dateformate() + ".jpeg");
          FileHandler.copy(src, dest);

      }catch (Exception e)
      {
          System.out.println(e);
      }
      return System.getProperty("user.dir")+"\\screenshots\\"+dateformate() + ".jpeg";
  }

    public static WebDriver waitAndEnter(WebDriver driver, By ele, String input)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(50000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
        driver.findElement(ele).sendKeys(input);
        return driver;
    }
    public static String waitAndGetText(WebDriver driver, By ele)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(50000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
        return driver.findElement(ele).getText();

    }

    public static WebDriver waitAndClick(WebDriver driver, WebElement ele)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
        return driver;
    }
}
