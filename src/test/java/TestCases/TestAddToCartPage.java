package TestCases;

import Pages.AddToCartPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAddToCartPage extends DriverSetup {

    AddToCartPage addToCartPage = new AddToCartPage();

    @AfterMethod
    public void AddScreenShotAfterTest(){
        addToCartPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class,priority = 0)
    public void TestProductVisibleOnCartBadge(String user, String pass){
        addToCartPage.NavigateCartPage(user, pass);
        Assert.assertTrue(addToCartPage.is_element_visible(addToCartPage.item1_cart));
        Assert.assertTrue(addToCartPage.is_element_visible(addToCartPage.item2_cart));
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void removeAndAddProductFromCartBadge(String user, String pass){
        addToCartPage.NavigateCartPage(user, pass);
        addToCartPage.removeItem();
        Assert.assertFalse(addToCartPage.is_element_visible(addToCartPage.cart_badge_count));
        addToCartPage.add2Item();
        Assert.assertEquals(addToCartPage.getElement(addToCartPage.cart_badge_count).getText(), "2");
        addToCartPage.removeItem();
        Assert.assertFalse(addToCartPage.is_element_visible(addToCartPage.cart_badge_count));
        addToCartPage.add3Item();
        Assert.assertEquals(addToCartPage.getElement(addToCartPage.cart_badge_count).getText(), "3");
        addToCartPage.remove3Item();
        Assert.assertFalse(addToCartPage.is_element_visible(addToCartPage.cart_badge_count));
    }
}
