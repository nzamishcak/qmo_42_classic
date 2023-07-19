package com.qmo.ai.example;

import com.qmo.ai.example.helpers.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

public class Test1 {
    private static final Logger logger = LogManager.getLogger(Test1.class);

    @BeforeClass
    public void setUp()
    {
        WebDriverFactory.setDriver();
        logger.info("Browser setup by Thread {} and Driver reference is : {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
    }

    @Test
    void test1(Method m){
        WebDriverFactory.getDriver().get("https://www.bing.com/");
        logger.info("Method {} of Test1 Class, Thread {} and Driver reference is : {}", m.getName(), Thread.currentThread().getId(), WebDriverFactory.getDriver());
        Assert.assertTrue(true);

    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Browser closed by Thread {} and Closing driver reference is: {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
        WebDriverFactory.closeBrowser();
    }
}
