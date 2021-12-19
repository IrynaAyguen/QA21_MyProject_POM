package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
    }

    @Test
    public void searchOfProductWithNamePositiveTest(){
        new ProfilePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        Assert.assertTrue(new ProfilePage(driver).takeNameOfProduct().contains(ProductData.PRODUCT_NAME));
    }

    @Test
    public void searchOfProductWithSearchWordPositiveTest(){
        new ProfilePage(driver).typeInSearchFieldInput("Computer");
        Assert.assertTrue(new ProfilePage(driver).verifyNumberOfResults().contains("36"));  ///////36
    }

    @Test
    public void verifyEmptySearchFieldTest(){
        new ProfilePage(driver).typeInSearchFieldInput("  ");
        Assert.assertTrue(new ProfilePage(driver).verifySearchField().contains("Products matching \"\""));
    }

    @Test
    public void verifyTitleOfFoundedProductsListTest(){
        new ProfilePage(driver).typeInSearchFieldInput("11111");
        Assert.assertTrue(new ProfilePage(driver).verifySearchField().contains("Products matching \"11111\""));
    }

    @Test
    public void searchOfProductNegativeTest(){
        new ProfilePage(driver).typeInSearchFieldInput("11111");
        Assert.assertTrue(new ProfilePage(driver).verifyNullResults().contains("Found 0 results."));
    }

    @Test
    public void numberOfFoundedProductsOnPageTest(){
        new ProfilePage(driver).typeInSearchFieldInput("Computer");
        Assert.assertTrue(new ProfilePage(driver).isNumberOfProductsOnPageEqualsListSizeOnPage());
    }

}
