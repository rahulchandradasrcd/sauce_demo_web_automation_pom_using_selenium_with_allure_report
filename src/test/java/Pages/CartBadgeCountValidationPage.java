package Pages;

import org.openqa.selenium.By;

public class CartBadgeCountValidationPage extends BasePage{

    LoginPage loginPage = new LoginPage();

    public By product1_add = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By product2_add = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    public By product3_add = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    public By product4_add = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    public By product5_add = By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");

    public By product1_remove = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    public By product2_remove = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
    public By product4_remove = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
    public By product5_remove = By.xpath("//button[@id='remove-sauce-labs-onesie']");

    public By cart_count = By.xpath("//span[@class='shopping_cart_badge']");

    public void NavigateHomeForCartBadgeCount(String user, String pass){
        loginPage.doLogin(user, pass);
    }

    public void addProducts(){
        clickOnElement(product1_add);
        clickOnElement(product2_add);
        clickOnElement(product3_add);
        clickOnElement(product4_add);
        clickOnElement(product5_add);
    }

    public void removeProducts(){
        clickOnElement(product1_remove);
        clickOnElement(product2_remove);
        clickOnElement(product5_remove);
        clickOnElement(product4_remove);
    }
}
