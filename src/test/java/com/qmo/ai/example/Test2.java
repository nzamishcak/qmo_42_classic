package com.qmo.ai.example;

import com.qmo.ai.example.helpers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Test2 {
    private static final Logger logger = LogManager.getLogger(Test1.class);

    @BeforeClass
    public void setUp()
    {
        WebDriverFactory.setDriver();
        logger.info("Browser setup by Thread {} and Driver reference is : {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
    }

    @Test
    void test2(Method m){
        WebDriverFactory.getDriver().get("https://www.bing.com/");
        logger.info("Method {} of Test2 Class, Thread {} and Driver reference is : {}", m.getName(), Thread.currentThread().getId(), WebDriverFactory.getDriver());
        Assert.assertTrue(true);

    }

    @AfterClass
    public void tearDown()
    {
        logger.info("Browser closed by Thread {} and Closing driver reference is: {}", Thread.currentThread().getId(), WebDriverFactory.getDriver());
        WebDriverFactory.closeBrowser();
    }
}
