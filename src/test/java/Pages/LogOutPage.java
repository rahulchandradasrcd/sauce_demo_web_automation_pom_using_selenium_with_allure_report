package Pages;

import org.openqa.selenium.By;

public class LogOutPage extends BasePage{

    HomePage homePage = new HomePage();

    public By menu_button = By.xpath("//button[@id='react-burger-menu-btn']");
    public By log_out_btn = By.xpath("//a[@id='logout_sidebar_link']");
    public String login_page_url = "https://www.saucedemo.com/";
    public By login_btn = By.xpath("//input[@id='login-button']");

    public void NavigateHomeForLogOut(String user, String pass){
        homePage.loadHomePage(user, pass);
    }

    public void LogOutProcess(){
        clickOnElement(menu_button);
        clickOnElement(log_out_btn);
    }
}
