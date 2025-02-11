package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Utility.DriverSetup.getDriver;

public class BasePage {

    public void loadWebPage(String url){
        getDriver().get(url);
    }

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).click();
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getPageUrl(){
        return getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public Boolean is_element_visible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public Boolean is_enabled(By locator){
        try {
            return getElement(locator).isEnabled();
        }catch (Exception e){
            return false;
        }
    }

    public String getErrorMassage(By locator){
        return getElement(locator).getText();
    }

    public void HandleDropdown(By locator, String text) {
        WebElement dropdown = getElement(locator);
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }

    public void addScreenshot() {
        Allure.addAttachment("After Test", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
