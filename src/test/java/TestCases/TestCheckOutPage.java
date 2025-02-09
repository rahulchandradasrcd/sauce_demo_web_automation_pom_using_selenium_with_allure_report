package TestCases;

import Pages.CheckOutPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCheckOutPage extends DriverSetup {

    CheckOutPage checkOutPage = new CheckOutPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        checkOutPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void AutomateCheckOutAndVerify(String user, String pass){
        checkOutPage.FillCheckOutAddress(user, pass);
        Assert.assertTrue(checkOutPage.is_element_visible(checkOutPage.item1_check));
        Assert.assertTrue(checkOutPage.is_element_visible(checkOutPage.item2_check));
        Assert.assertEquals(checkOutPage.getElement(checkOutPage.payment_info).getText(),"SauceCard #31337");
        Assert.assertEquals(checkOutPage.getElement(checkOutPage.total_cost).getText(), "Total: $43.18");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void FinishOrderAndVerifyConfirmMassage(String user, String pass){
        checkOutPage.CompleteOrder(user, pass);
        Assert.assertEquals(checkOutPage.getElement(checkOutPage.verify_confirm_massage).getText(), "Thank you for your order!");
        Assert.assertEquals(checkOutPage.getElement(checkOutPage.verify_confirm_massage2).getText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
