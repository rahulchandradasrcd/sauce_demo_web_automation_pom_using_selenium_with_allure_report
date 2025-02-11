# sauce_demo_web_automation_pom_using_selenium_with_allure_report
## Overview
This project automates the functionality of the SauceDemo.com website using Java, Selenium WebDriver, and TestNG for test execution. The automation suite includes key operations such as login, add to cart, completing checkout, sorting, logout, locked out, cart badges count. All test results are reported using Allure, generating detailed and interactive reports for test analysis also created the report on surefire-report.

The goal of this project is to ensure the smooth functionality of the website by automating critical flows and validating the website’s behavior under various scenarios based on Test Scenarios.

## Features
* **Automated Login Test** :Automated login Test with valid and invalid credentials. <br>
* **Add to Cart** : Automated add to cart functionalities with adding/removing product in cart. <br>
* **Checkout Operation** : Automates the entire checkout process with followed all steps like enter first name, last name zip code. <br>
* **Sorting Product Validation** : Sort by dropdown a to z, z to a, by name and price low to high , high to low. <br>
* **Automated Logout** :click on menu bar and click on logout button. <br>
* **Locked Out User** : login with locked person user pass and verify properly pop a error massage. <br>
* **Cart Badge Count** : Adding multiple product and removing verify to cart badges are counted correctly. <br>
* **Report Generate with Allure** : Generates rich, visually appealing HTML reports of the test executions.

## Website
[SauceDemo.com Automation Executed By Rahul](https://www.saucedemo.com/).

## Pre-requisites
* Java (it's better to use the leteast version)
* maven
* Testng
* Webdriver
* Allure command Line
* Surefire command line for run in terminal
* IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code
## Project Structure
````

**saucedemo-automation-pom/**  
|──**src/**  
│   ├── **main/**  
│   │   └── **java/**  
│   │       └── **com/**  
│   │           └── **saucedemo/**  
│   │             
│   └── **test/**  
│   |   └── **java/**  
│   |        └── **com/**  
│   |            └── **saucedemo/**  
│   │               ├── **pages/**                 **# Page Object Models (POM)**
|   |                    ├── **BasePage.java**     **# Base class with common setup** 
│   |                    ├── **LoginPage.java**
|   |                    ├── **HomePage.java**
|   |                    ├── **AddToCartPage.java**
|   |                    ├── **CheckOutPage.java**
|   |                    ├── **SortingProductPage.java**
│   |                    ├── **LogOutPage.java**
|   |                    ├── **LockedOutUserPage.java**
|   |                    └── **CartBadgeCountValidationPage.java**
│   │               ├── **utils/**                 **# Helper/Utility classes**
|   |                    ├── **DataSet.java**
│   |                    └── **DriverSetup.java**  
|   |               └── **tests/**                 **# TestNG test cases**  
│                        ├── **TestLoginPage.java**
|                        ├── **TestHomePage.java**
|                        ├── **TestAddToCartPage.java**
|                        ├── **TestCheckOutPage.java**
|                        ├── **TestSortingProductPage.java**
|                        ├── **TestLogOutPage.java**
|                        ├── **TestLockedOutUserPage.java**
│                        └── **TestCartBadgeCountValidationPage.java**   
├── **pom.xml**                                    **# Maven dependencies and build configuration**  
├── **allure-results/**                            **# Allure test execution results**
├── **Testng.xml/**                                **# Project Html Documentation to run all test**
└── **README.md**                                  **# Project documentation**  
````
## Installation
**1. Clone the Repository**
First, clone this repository to your local machine:
````

https://github.com/rahulchandradasrcd/sauce_demo_web_automation_pom_using_selenium_with_allure_report.git
````
**2. Set Up Java and Maven**
Ensure Java 8 or higher and Maven 3.x are installed on your machine.

Check your Java and Maven versions:
````

java -version
mvn -version
````
**3. WebDriver Setup**
Setup your webdriver properly.

**4. Add Dependecies in (pom.xml)**
- **selenium dependencies**
````

<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.25.0</version>
</dependency>
````
- **Testng dependencies**
````

<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.10.2</version>
      <scope>test</scope>
</dependency>
````
- **Allure dependencies**
````

<!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-testng -->
<dependency>
      <groupId>io.qameta.allure</groupId>
      <artifactId>allure-testng</artifactId>
      <version>2.29.0</version>
</dependency>
````
**5. Maven Plugin**
````

<plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.5.2</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
      </plugin>
</plugins>
````
## Example Test Code
### Driver Setup
````

public class DriverSetup {

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    @BeforeMethod
    public void OpenABrowser(){
        WebDriver driver = getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterMethod
    public void CloseBrowser(){
        getDriver().quit();
    }
}
````
### BasePage Setup
````

public class BasePage {

    public void loadWebPage(String url){
        getDriver().get(url);
    }

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).click();
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }
````
## Reporting
### Allure Reporting
Make Sure allure dependencies add on POM.xml file. Then Create TestNG.xml File and setup run method with Thread count. Run The Test.
After Complete run test go to terminal and execute this code:- 
````

allure generate ./allure-results/ --clean

allure open ./allure-report
````
