package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
    }

    @Test
    public void searchProductPositiveTest(){
        new ProfilePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        Assert.assertTrue(new ProfilePage(driver).takeNameOfProduct().contains(ProductData.PRODUCT_NAME));

    }
    @Test
    public void verifyEmptySearchFieldTest(){
        new ProfilePage(driver).typeInSearchFieldInput("  ");
        Assert.assertTrue(new ProfilePage(driver).verifyEmptyField().contains("Produkte gefunden mit „“"));
        //Assert.assertTrue(new ProfilePage(driver).verifyEmptyField().contains("Products matching \"\""));

    }

}
