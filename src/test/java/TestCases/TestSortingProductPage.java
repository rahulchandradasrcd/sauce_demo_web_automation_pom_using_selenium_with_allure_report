package TestCases;

import Pages.SortingProductPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestSortingProductPage extends DriverSetup {

    SortingProductPage sortingProductPage = new SortingProductPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        sortingProductPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 0)
    public void verifyProductDisplayedInCorrectOrderPriceLowToHigh(String user, String pass){
        sortingProductPage.NavigateHomeForSorting(user, pass);
        sortingProductPage.sortBy("lohi");
        Assert.assertTrue(sortingProductPage.isSortedByPriceLowToHigh());
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 1)
    public void verifyProductDisplayedInCorrectOrderPriceHighToLow(String user, String pass) {
        sortingProductPage.NavigateHomeForSorting(user, pass);
        sortingProductPage.sortBy("hilo");
        Assert.assertTrue(sortingProductPage.isSortedByPriceHighToLow());
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 2)
    public void verifyProductDisplayedInCorrectOrderNameAToZ(String user, String pass) {
        sortingProductPage.NavigateHomeForSorting(user, pass);
        sortingProductPage.sortBy("az");
        Assert.assertTrue(sortingProductPage.isSortedByNameAToZ());
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class, priority = 3)
    public void verifyProductDisplayedInCorrectOrderNameZToA(String user, String pass) {
        sortingProductPage.NavigateHomeForSorting(user, pass);
        sortingProductPage.sortBy("za");
        Assert.assertTrue(sortingProductPage.isSortedByNameZToA());
    }
}
