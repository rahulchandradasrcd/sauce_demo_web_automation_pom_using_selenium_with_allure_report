package Pages;

import org.openqa.selenium.By;

public class SortingProductPage extends BasePage{

    HomePage homePage = new HomePage();

    public By drop_down = By.xpath("//select[@class='product_sort_container']");

    public void NavigateHomeForSorting(String user, String pass){
        homePage.loadHomePage(user, pass);
    }

    public void selectFromDropDown1(){
        HandleDropdown(drop_down, "lohi");
    }

    public void selectFromDropDown2(){
        HandleDropdown(drop_down, "hilo");
    }

    public void selectFromDropDown3(){
        HandleDropdown(drop_down, "az");
    }

    public void selectFromDropDown4(){
        HandleDropdown(drop_down, "za");
    }
}
