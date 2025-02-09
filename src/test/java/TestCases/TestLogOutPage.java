package TestCases;

import Pages.LogOutPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestLogOutPage extends DriverSetup {

    LogOutPage logOutPage = new LogOutPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        logOutPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class)
    public void LogOutAndVerify(String user, String pass){
        logOutPage.NavigateHomeForLogOut(user, pass);
        logOutPage.LogOutProcess();
        Assert.assertEquals(logOutPage.getPageUrl(),logOutPage.login_page_url);
        Assert.assertTrue(logOutPage.is_enabled(logOutPage.login_btn));
    }
}
