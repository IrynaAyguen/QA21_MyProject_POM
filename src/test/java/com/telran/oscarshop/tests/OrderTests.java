package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.ShippingAddress;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        new HomePage(driver).clickOnSearchButton();
        new ProductPage(driver).clickAddToBasketButton();
    }

    @Test
    public void OderPositiveTest() {
        new ProductPage(driver).clickViewBasketButton();
        new BasketPage(driver).clickProceedToCheckoutButton();
        new ShippingAddressPage(driver).selectTitle("Mrs");
        new ShippingAddressPage(driver).typeNameAndAddress(ShippingAddress.ADDRESS_FIRSTNAME, ShippingAddress.ADDRESS_LASTNAME,
                ShippingAddress.ADDRESS_FIRSTLINE, ShippingAddress.ADDRESS_CITY, ShippingAddress.ADDRESS_POSTCODE);
        new ShippingAddressPage(driver).selectCountry("Germany");
        new ShippingAddressPage(driver).clickContinueBtn();
        new PaymentPage(driver).clickContinueBtn();
        new PreviewPage(driver).clickPlaceOrderBtn();
        new ConfirmationPage(driver).clickContinueShoppingBtn();

        new ProductPage(driver).clickViewBasketButton();
        Assert.assertTrue(new BasketPage(driver).verifyTextAboutEmptyBasket().contains("Your basket is empty"));
    }
}



