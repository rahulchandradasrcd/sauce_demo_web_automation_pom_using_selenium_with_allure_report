package TestCases;

import Pages.HomePage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends DriverSetup {
    HomePage homepage = new HomePage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        homepage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class,priority = 0)
    public void TestPageTitle(String user, String pass){
        homepage.loadHomePage(user, pass);
        Assert.assertEquals(homepage.getPageTitle(),homepage.title);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void TestPageUrl(String user, String pass){
        homepage.loadHomePage(user, pass);
        Assert.assertEquals(homepage.getPageUrl(), homepage.url);
    }
}
