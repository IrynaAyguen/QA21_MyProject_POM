package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProductPage;
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
        new HomePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).takeNameOfProduct().contains(ProductData.PRODUCT_NAME));
    }

    @Test
    public void searchOfProductWithSearchWordPositiveTest(){
        new HomePage(driver).typeInSearchFieldInput("Computer");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifyNumberOfResults().contains("36"));  ///////36
    }

    @Test
    public void verifyEmptySearchFieldTest(){
        new HomePage(driver).typeInSearchFieldInput("  ");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifySearchField().contains("Products matching \"\""));
    }

    @Test
    public void verifyTitleOfFoundedProductsListTest(){
        new HomePage(driver).typeInSearchFieldInput("Computer");
        new HomePage(driver).clickOnSearchButton();

        Assert.assertTrue(new ProductPage(driver).verifySearchField().contains("Products matching \"Computer\""));
    }

    @Test
    public void searchOfProductNegativeTest(){
        new HomePage(driver).typeInSearchFieldInput("11111");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifyNullResults().contains("Found 0 results."));
    }

    @Test
    public void numberOfFoundedProductsOnPageTest(){
        new HomePage(driver).typeInSearchFieldInput("Computer");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).isNumberOfProductsOnPageEqualsListSizeOnPage());
    }

}
