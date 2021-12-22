package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToBasketTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        new HomePage(driver).clickOnSearchButton();
    }

    @Test
    public void addProductToBasketPositiveTest() {
        new ProductPage(driver).clickAddToBasketButton();
        Assert.assertTrue(new ProductPage(driver).isNewBasketTotalCorrect());

        new ProductPage(driver).clickViewBasketButton();
        new BasketPage(driver).typeQuantity();
        new BasketPage(driver).clickUpdate();
    }
}
