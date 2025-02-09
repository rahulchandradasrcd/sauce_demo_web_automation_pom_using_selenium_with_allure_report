package TestCases;

import Pages.LoginPage;
import Utility.DataSet;
import Utility.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends DriverSetup {

    LoginPage loginPage = new LoginPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        loginPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class,priority = 0)
    @Description("Login With ValidCredentials")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginWithValidCredentials(String user, String pass){
        loginPage.doLogin(user, pass);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.home_page_check));
    }

    @Test(dataProvider = "inValidCredentials", dataProviderClass = DataSet.class, priority = 1)
    @Description("Login With InValidCredentials")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginWithInValidCredentials(String user, String pass){
        loginPage.doLogin(user, pass);
        Assert.assertEquals(loginPage.getErrorMassage(loginPage.error_massage_check), loginPage.error_msg);
    }
}
