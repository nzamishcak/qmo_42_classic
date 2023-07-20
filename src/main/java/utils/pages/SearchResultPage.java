package utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver) {
        this.driver=driver;
        waitUntilElementIsVisible(driver, pageTitle, 5);
    }

    // Locators for the page
    By pageTitle = By.xpath("//title[contains(text(), ' - Search')]");
    By searchField = By.xpath("//div[@role='search']//input[@type='search']");


    // Methods to interact with page elements
    public WebElement getPageTitle(){
        logger.info("Return Search Result Page Title");
        return driver.findElement(pageTitle);
    }

    public WebElement getSearchField(){
        logger.info("Return Search Result Page - Search Field");
        return driver.findElement(searchField);
    }


}
