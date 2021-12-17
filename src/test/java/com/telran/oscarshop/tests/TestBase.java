package com.telran.oscarshop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

   WebDriver driver;

   @BeforeMethod
   public void setUp(){
      driver = new ChromeDriver();
      //driver = new EventFiringWebDriver(new ChromeDriver());
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


      driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
      //driver.get("http://selenium1py.pythonanywhere.com/en-gb/accounts/login/");

      //driver.register(new MyListener());
   }

   @AfterMethod(enabled = false)
   public void  tearDown(){
      driver.quit();
   }

//   @BeforeMethod
//   public void startTest(Method m, Object[] p) {
//      logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
//   }
//
//   @AfterMethod
//   public void stopTest(ITestResult result) {
//      if(result.isSuccess()){
//         logger.info("PASSED: test method " + result.getMethod().getMethodName());
//      }else{
//         logger.error("FAILED: test method " + result.getMethod().getMethodName());
//
//         new PageBase(driver).takeScreenshot();
//      }
//      logger.info("==========================");
//   }

}
