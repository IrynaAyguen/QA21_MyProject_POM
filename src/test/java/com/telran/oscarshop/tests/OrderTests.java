package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new ProfilePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        new ProfilePage(driver).clickAddToBasketButton();

    }

    @Test
    public void OderPositiveTest() {
        new ProfilePage(driver).clickViewBasketButton();
        new BasketPage(driver).clicktProceedToCheckoutButton();
    }
}
