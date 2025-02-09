package Pages;

import org.openqa.selenium.By;

public class LockedOutUserPage extends BasePage{

    LoginPage loginPage = new LoginPage();

    public By error_massage_check1 = By.cssSelector(".error-message-container");
    public String error_msg = "Epic sadface: Sorry, this user has been locked out.";

    public void LockedOutUserInLogin(String user, String pass){
        loginPage.doLogin(user, pass);
    }
}
