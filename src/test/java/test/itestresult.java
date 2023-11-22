package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class itestresult {
    @Test
    public void test1()
    {
        Assert.assertEquals(true,true);
    }
    @Test
    public void test2()
    {
        Assert.assertEquals(true,false);
    }
    @Test(dependsOnMethods = "test2")
    public void test3()
    {
        System.out.println("hello");
    }

    @AfterMethod
    public void testresults(ITestResult result)
    {
        int status=result.getStatus();
       if(status==ITestResult.SUCCESS)
       {
           System.out.println("test pass");
       }
       else if(status==ITestResult.FAILURE)
       {
           System.out.println("test fail");
       }
       else if(status==ITestResult.SKIP)
       {
           System.out.println("test skip");
       }
    }
}
