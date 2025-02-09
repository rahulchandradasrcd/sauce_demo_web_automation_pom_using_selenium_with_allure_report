package Pages;

import TestCases.TestLoginPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String title = "Swag Labs";
    public String url = "https://www.saucedemo.com/inventory.html";

    public By product1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By product2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    public By product3 = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    public By cart_button = By.xpath("//a[@class='shopping_cart_link']");

    LoginPage loginPage = new LoginPage();

    public void loadHomePage(String user, String pass){
        loginPage.doLogin(user, pass);
    }
}
