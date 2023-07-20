package utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.components.ChatInfoBanner;
import utils.components.HamburgerMenuPopUp;

public class HomePage extends BasePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver=driver;
        waitUntilElementIsVisible(driver, bingLogo, 5);
    }

    // Locators for the page
    By bingLogo = By.xpath("//h1[@class='logo_cont']");
    By pageTitle = By.xpath("//title[text()='Bing']");
    By searchField = By.xpath("//textarea[@type='search']");
    By searchIcon = By.xpath("//*[@id='search_icon']");
    By chatMenuItem = By.xpath(".//a[.//div[@class='text' and text()='Chat']]");
    By hamburgerMenuButton = By.xpath("//a[@class='idp_ham hphbtop' and @role='button']");


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
        logger.info("Enter in Home Page - Search Field text: '{}'", text);
    }

    public SearchResultPage clickSearchIcon(){
        logger.info("Click Home Page - Search Icon");
        //getSearchIcon().click();
        getSearchIcon().submit();
        return new SearchResultPage(driver);
    }

    public WebElement getChatMenuItem(){
        logger.info("Return Home Page - Top menu - Chat Item");
        return driver.findElement(chatMenuItem);
    }

    public ChatInfoBanner clickChatMenuItem(){
        logger.info("Click Home Page - Top menu - Chat Item");
        getChatMenuItem().click();
        return new ChatInfoBanner(driver);
    }

    public WebElement getHamburgerMenuButton(){
        logger.info("Return Home Page - Top Hamburgaer Menu Button");
        waitUntilElementIsVisible(driver, hamburgerMenuButton, 5);
        return driver.findElement(hamburgerMenuButton);
    }

    public HamburgerMenuPopUp clickHamburgerMenuButton(){
        logger.info("Click on Home Page - Top Hamburgaer Menu Button");
        getHamburgerMenuButton().click();
        return new HamburgerMenuPopUp(driver);
    }

}
