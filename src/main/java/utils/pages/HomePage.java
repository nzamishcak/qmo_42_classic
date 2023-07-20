package utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    // Locators for the page
    By pageTitle = By.xpath("//title[text()='Bing']");
    By searchField = By.xpath("//textarea[@type='search']");
    By searchIcon = By.xpath("//*[@id='search_icon']//*[name()='svg']");


    // Methods to interact with page elements
    public WebElement getPageTitle(){
        logger.info("Return Home Page Title");
        return driver.findElement(pageTitle);
    }

    public WebElement getSearchField(){
        logger.info("Return Home Page - Search Field");
        return driver.findElement(searchField);
    }

    public WebElement getSearchIcon(){
        logger.info("Return Home Page - Search Icon");
        return driver.findElement(searchIcon);
    }

    public void enterTextInSearchField(String text){
        WebElement searchField = getSearchField();
        searchField.clear();
        searchField.click();
        searchField.sendKeys(text);
        logger.info("Enter in Home Page - Search Icon text: {}", text);
    }

    public SearchResultPage clickSearchIcon(){
        logger.info("Click Home Page - Search Icon");
        getSearchIcon().click();
        return new SearchResultPage(driver);
    }



}
