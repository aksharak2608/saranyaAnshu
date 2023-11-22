package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.helper;

import java.time.Duration;

public class homePage {
WebDriver driver;
    public String homeUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    By pageName=By.xpath("//h6[text()='Dashboard']");
    public homePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String banner()
    {
        String banner_name=helper.waitAndGetText(driver,pageName);


        return banner_name;

    }
}
