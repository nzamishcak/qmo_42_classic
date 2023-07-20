package utils.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.pages.BasePage;

public class ChatInfoBanner extends BasePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ChatInfoBanner.class);

    public ChatInfoBanner(WebDriver driver) {
        this.driver=driver;
        waitUntilElementIsVisible(driver, banner, 5);
    }

    // Locators for the page
    By banner = By.xpath("//div[@class='sydpaywall_banner']");

    // Methods to interact with page elements
    public WebElement getBanner(){
        logger.info("Return Chat Info Banner");
        return driver.findElement(banner);
    }
}