package Pages;

import TestCases.TestHomePage;
import org.openqa.selenium.By;



public class AddToCartPage extends BasePage{

    HomePage homePage = new HomePage();

    public By item1_cart = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");
    public By item2_cart = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");

    public By item1_remove = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
    public By item2_remove = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    public By item3_remove = By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']");

    public By cart_badge_count = By.xpath("//span[@class='shopping_cart_badge']");

    public By continue_shopping = By.xpath("//button[@id='continue-shopping']");
    public By checkout  = By.xpath("//button[@id='checkout']");

    public void NavigateCartPage(String user, String pass){
        homePage.loadHomePage(user, pass);
        homePage.clickOnElement(homePage.product1);
        homePage.clickOnElement(homePage.product2);
        homePage.clickOnElement(homePage.cart_button);
    }

    public void removeItem(){
        clickOnElement(item1_remove);
        clickOnElement(item2_remove);
    }

    public void remove3Item(){
        clickOnElement(item1_remove);
        clickOnElement(item2_remove);
        clickOnElement(item3_remove);
    }

    public void add2Item(){
        clickOnElement(continue_shopping);
        homePage.clickOnElement(homePage.product1);
        homePage.clickOnElement(homePage.product2);
        homePage.clickOnElement(homePage.cart_button);
    }
    public void add3Item(){
        clickOnElement(continue_shopping);
        homePage.clickOnElement(homePage.product1);
        homePage.clickOnElement(homePage.product2);
        homePage.clickOnElement(homePage.product3);
        homePage.clickOnElement(homePage.cart_button);
    }
}
