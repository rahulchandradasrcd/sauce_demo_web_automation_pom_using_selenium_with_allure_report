package TestCases;

import Pages.SortingProductPage;
import Utility.DataSet;
import Utility.DriverSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestSortingProductPage extends DriverSetup {

    SortingProductPage sortingProductPage = new SortingProductPage();

    @AfterMethod
    public void ddScreenShotAfterTest(){
        sortingProductPage.addScreenshot();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataSet.class)
    public void verifyProductDisplayedInCorrectOrder(String user, String pass) throws InterruptedException {
        sortingProductPage.NavigateHomeForSorting(user, pass);
        sortingProductPage.selectFromDropDown1();
        Thread.sleep(2000);
        sortingProductPage.selectFromDropDown2();
        Thread.sleep(2000);
        sortingProductPage.selectFromDropDown3();
        Thread.sleep(2000);
        sortingProductPage.selectFromDropDown4();
        Thread.sleep(2000);
    }
}
