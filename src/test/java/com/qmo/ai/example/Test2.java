package com.qmo.ai.example;

import com.qmo.ai.example.helpers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.components.ChatInfoBanner;
import utils.pages.HomePage;


import java.lang.reflect.Method;

public class Test2 {
    private static final Logger logger = LogManager.getLogger(Test1.class);
    private static final String URL = "https://www.bing.com/";
    private static HomePage homePage;
    private static ChatInfoBanner chatInfoBanner;

    @BeforeClass
    public void setUp()
    {
        WebDriverFactory.setDriver();
        WebDriverFactory.getDriver().manage().window().maximize();
        logger.info("Browser setup by Thread {} and Driver reference is : {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
    }

    @Test
    void test2(){

        //Go to https://www.bing.com/
        WebDriverFactory.getDriver().get(URL);
        homePage = new HomePage(WebDriverFactory.getDriver());

        //Click on the chat link from the top menu.
        Assert.assertTrue(homePage.getChatMenuItem().isDisplayed());
        logger.info("Chat item in top menu on Home Page is displayed");
        chatInfoBanner = homePage.clickChatMenuItem();

        //Verify that the pop-up information window is displayed.
        Assert.assertTrue(chatInfoBanner.getBanner().isDisplayed());
        logger.info("Information Chat Banner is displayed");
    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Browser closed by Thread {} and Closing driver reference is: {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
        WebDriverFactory.closeBrowser();
    }
}
