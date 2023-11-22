package Factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserFactory {
    public static WebDriver startBrowser(String browser, String url)
    {
        WebDriver driver= null;
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
            driver= new ChromeDriver( new ChromeOptions().addArguments("--remote-allow-origins=*"));

        }
        else  if(browser.equalsIgnoreCase("IE"))
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
        driver= new ChromeDriver( new ChromeOptions().addArguments("--remote-allow-origins=*"));

    }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
        return driver;
    }

    public static void closeBrowser(WebDriver driver)
    {
        driver.close();
    }
}
