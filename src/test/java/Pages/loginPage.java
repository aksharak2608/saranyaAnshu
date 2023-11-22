package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.helper;

public class loginPage {
    WebDriver driver;
By username_by=By.xpath("//input[@name='username']");
By password_by= By.xpath("//input[@name='password']");
By submit_by=By.xpath("//button[text()=' Login ']");
public loginPage(WebDriver driver)
{
    this.driver=driver;
}
public void enterUsername(String username )
{
    helper.waitAndEnter(driver,username_by, username);
    System.out.println(username);
}
    public void enterPassword(String password )
    {
        helper.waitAndEnter(driver,password_by, password);
    }

    public void submitLogin( )
    {
        WebElement submitButton=driver.findElement(submit_by);
        helper.waitAndClick(driver,submitButton);
    }

}
