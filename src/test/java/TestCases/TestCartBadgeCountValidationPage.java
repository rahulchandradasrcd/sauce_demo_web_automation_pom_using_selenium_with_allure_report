package TestCases;

import Pages.CartBadgeCountValidationPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCartBadgeCountValidationPage extends DriverSetup {

    CartBadgeCountValidationPage cartBadgeCountValidationPage = new CartBadgeCountValidationPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        cartBadgeCountValidationPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class)
    public void ValidateCartCountBadge(String user, String pass){
        cartBadgeCountValidationPage.NavigateHomeForCartBadgeCount(user, pass);
        cartBadgeCountValidationPage.addProducts();
        Assert.assertEquals(cartBadgeCountValidationPage.getElement(cartBadgeCountValidationPage.cart_count).getText(), "5");
        cartBadgeCountValidationPage.removeProducts();
        Assert.assertEquals(cartBadgeCountValidationPage.getElement(cartBadgeCountValidationPage.cart_count).getText(), "1");
    }
}
