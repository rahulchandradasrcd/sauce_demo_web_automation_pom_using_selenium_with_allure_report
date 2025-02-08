package Pages;

import org.openqa.selenium.By;

public class CheckOutPage extends BasePage{

    AddToCartPage addToCartPage = new AddToCartPage();

    public By first_name = By.xpath("//input[@id='first-name']");
    public By last_name = By.xpath("//input[@id='last-name']");
    public By zip_code = By.xpath("//input[@id='postal-code']");
    public By continue_button = By.xpath("//input[@id='continue']");

    public By item1_check = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public By item2_check = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");
    public By payment_info = By.xpath("//div[normalize-space()='SauceCard #31337']");
    public By total_cost = By.xpath("//div[@class='summary_total_label']");

    public By finish_order = By.xpath("//button[@id='finish']");
    public By verify_confirm_massage = By.xpath("//h2[normalize-space()='Thank you for your order!']");
    public By verify_confirm_massage2 = By.xpath("//div[@class='complete-text']");

    public void NavigateCheckOutPage(String user, String pass){
        addToCartPage.NavigateCartPage(user, pass);
        addToCartPage.clickOnElement(addToCartPage.checkout);
    }

    public void FillCheckOutAddress(String user, String pass){
        NavigateCheckOutPage(user, pass);
        writeOnElement(first_name,"John ");
        writeOnElement(last_name, "Doe");
        writeOnElement(zip_code, "12345");
        clickOnElement(continue_button);
    }

    public void CompleteOrder(String user, String pass){
        FillCheckOutAddress(user, pass);
        clickOnElement(finish_order);
    }
}
