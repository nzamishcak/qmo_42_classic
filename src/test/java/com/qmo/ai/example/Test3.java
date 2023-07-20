package com.qmo.ai.example;

import com.qmo.ai.example.helpers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.components.HamburgerMenuPopUp;
import utils.pages.HomePage;
import utils.pages.SettingsPage;

import java.lang.reflect.Method;

public class Test3 {
    private static final Logger logger = LogManager.getLogger(Test1.class);
    private static final String URL = "https://www.bing.com/";
    private static HomePage homePage;
    private static HamburgerMenuPopUp hamburgerMenuPopUp;
    private static SettingsPage settingsPage;


    @BeforeClass
    public void setUp()
    {
        WebDriverFactory.setDriver();
        WebDriverFactory.getDriver().manage().window().maximize();
        logger.info("Browser setup by Thread {} and Driver reference is : {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
    }

    @Test
    void test3() {
        //Go to https://www.bing.com/
        WebDriverFactory.getDriver().get(URL);
        homePage = new HomePage(WebDriverFactory.getDriver());

        //Click on the hamburger menu in the top right corner.
        Assert.assertTrue(homePage.getHamburgerMenuButton().isDisplayed());
        logger.info("Hamburger Menu in top menu on Home Page is displayed");
        hamburgerMenuPopUp = homePage.clickHamburgerMenuButton();

        //Select “Settings” and then click on “More”.
        hamburgerMenuPopUp.clickSettingsItem();
        settingsPage = hamburgerMenuPopUp.clickMoreSettingsItem();

        //Verify that the settings page is opened.
        Assert.assertTrue(settingsPage.getPageHeader().isDisplayed());
        logger.info("Settings Page is opened");
    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Browser closed by Thread {} and Closing driver reference is: {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
        WebDriverFactory.closeBrowser();
    }
}
