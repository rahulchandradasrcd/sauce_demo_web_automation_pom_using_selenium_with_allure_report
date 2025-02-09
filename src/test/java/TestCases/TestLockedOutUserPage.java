package TestCases;

import Pages.LockedOutUserPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestLockedOutUserPage extends DriverSetup {

    LockedOutUserPage lockedOutUserPage = new LockedOutUserPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        lockedOutUserPage.addScreenshot();
    }

    @Test(dataProvider = "lockedOutUserCredentials", dataProviderClass = DataSet.class)
    public void VerifyLockedOutUserInLogin(String user, String pass){
        lockedOutUserPage.LockedOutUserInLogin(user, pass);
        Assert.assertEquals(lockedOutUserPage.getErrorMassage(lockedOutUserPage.error_massage_check1),lockedOutUserPage.error_msg);
    }
}
