package com.qmo.ai.example;

import com.qmo.ai.example.helpers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.pages.HomePage;
import utils.pages.SearchResultPage;

import java.lang.reflect.Method;

public class Test1 {
    private static final Logger logger = LogManager.getLogger(Test1.class);
    private static final String URL = "https://www.bing.com/";
    private static final String SEARCH_PHRASE = "weather in Lviv";
    private static final String ATTRIBUTE_VALUE = "value";
    private static HomePage homePage;
    private static SearchResultPage searchResultPage;

    @BeforeClass
    public void setUp()
    {
        WebDriverFactory.setDriver();
        logger.info("Browser setup by Thread {} and Driver reference is : {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
    }

    @Test
    void test1() {

        //Go to https://www.bing.com/
        WebDriverFactory.getDriver().get(URL);
        homePage = new HomePage(WebDriverFactory.getDriver());

        //Type “weather in Lviv” into the search bar and click on the search icon.
        Assert.assertTrue(homePage.getSearchField().isDisplayed());
        homePage.enterTextInSearchField(SEARCH_PHRASE);
        searchResultPage = homePage.clickSearchIcon();

        //The search results should contain information about the weather in Lviv.
        String pageTitle = searchResultPage.getPageTitle().getAttribute("text");
        Assert.assertTrue(pageTitle.contains(SEARCH_PHRASE));
        Assert.assertEquals(searchResultPage.getSearchField().getAttribute(ATTRIBUTE_VALUE), SEARCH_PHRASE);

    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Browser closed by Thread {} and Closing driver reference is: {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
        WebDriverFactory.closeBrowser();
    }
}
