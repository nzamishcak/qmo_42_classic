package utils.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.pages.BasePage;
import utils.pages.SettingsPage;

public class HamburgerMenuPopUp extends BasePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HamburgerMenuPopUp.class);

    public HamburgerMenuPopUp(WebDriver driver) {
        this.driver=driver;
        waitUntilElementIsVisible(driver, menu, 5);
    }

    // Locators for the page
    By menu = By.xpath("//span[@role='menu']");
    By settingsItem = By.xpath("//div[@id='hbsettings']");
    By moreItemSettings = By.xpath("//div[@aria-labelledby='hbsettings']//a[.//div[text()='More']]");

    // Methods to interact with page elements
    public WebElement getMenu(){
        logger.info("Return Home Page - Hamburger Menu");
        return driver.findElement(menu);
    }

    public WebElement getSettingsItem() {
        logger.info("Return Home Page - Hamburger Menu - Settings Item");
        return driver.findElement(settingsItem);
    }

    public void clickSettingsItem(){
        logger.info("Click on Home Page - Hamburger Menu - Settings Item element");
        getSettingsItem().click();
    }

    public WebElement getMoreSettingsItem() {
        logger.info("Return Home Page - Hamburger Menu - Settings - More Item");
        return driver.findElement(moreItemSettings);
    }

    public SettingsPage clickMoreSettingsItem(){
        logger.info("Click on Home Page - Hamburger Menu - Settings - More Item");
        waitUntilElementIsVisible(driver, moreItemSettings, 5);
        getMoreSettingsItem().click();
        return new SettingsPage(driver);
    }

}