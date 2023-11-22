package testcases;

import Factories.Baseclass;
import Factories.dataProvider;
import Pages.homePage;
import Pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class logintest extends Baseclass {

    @Test
    void performLogin()
    {

        logger=reports.createTest("login", "loginto crm");
       loginPage lp= PageFactory.initElements(driver,loginPage.class);

        String a=dataProvider.readExcel("hrm",0,0);
        String b=dataProvider.readExcel("hrm",0,1);
        System.out.println(a);
        lp.enterUsername(a);
        lp.enterPassword(b);
        lp.submitLogin();
       homePage hp= PageFactory.initElements(driver,homePage.class);

               //new homePage(driver) ;
        Assert.assertEquals(hp.banner(),"Dashboard");



    }
}
