package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String url = "https://www.saucedemo.com/";

    public By user_input_box = By.xpath("//input[@id='user-name']");
    public By password_input_box = By.xpath("//input[@id='password']");
    public By login_button = By.xpath("//input[@id='login-button']");

    public By home_page_check = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public By error_massage_check = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");
    public String error_msg = "Epic sadface: Username and password do not match any user in this service";

    public void loadLoginPage(){
        loadWebPage(url);
    }

    public void doLogin(String user, String pass){
        loadLoginPage();
        writeOnElement(user_input_box, user);
        writeOnElement(password_input_box, pass);
        clickOnElement(login_button);
    }

}
