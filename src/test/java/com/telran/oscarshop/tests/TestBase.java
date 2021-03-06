package com.telran.oscarshop.tests;

import com.telran.oscarshop.helpers.MyListener;
import com.telran.oscarshop.helpers.PropertiesLoader;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static EventFiringWebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static String baseURL = PropertiesLoader.loadProperty("url");  //  from PropertiesLoader

    @BeforeSuite
    public void setUp() {

        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseURL);                  //  from PropertiesLoader
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickGoButton();

        driver.register(new MyListener());
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: test method " + result.getMethod().getMethodName());

            new PageBase(driver).takeScreenshot();
        }
        logger.info("==========================");
    }

}
