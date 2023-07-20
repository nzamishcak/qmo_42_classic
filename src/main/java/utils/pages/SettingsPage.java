package utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SettingsPage.class);

    public SettingsPage(WebDriver driver) {
        this.driver=driver;
        waitUntilElementIsVisible(driver, pageHeader, 5);
    }

    // Locators for the page
    By pageHeader = By.xpath("//h2[text()='Settings']");

    // Methods to interact with page elements
    public WebElement getPageHeader(){
        logger.info("Return Settings Page Header");
        return driver.findElement(pageHeader);
    }
}
