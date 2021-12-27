package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ShippingAddress;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderHistoryTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).selectBooksCategory();
        new ProductPage(driver).clickOnAddToBasketFromList(1);
        new ProductPage(driver).clickOnViewBasketButton();

    }


    @Test
    public void userCanViewOrderHistoryPositiveTest(){
        String productName= new BasketPage(driver).getProductNameInBasket();

        new BasketPage(driver).clickProceedToCheckoutButton();
        new ShippingAddressPage(driver).selectTitle("Mrs");
        new ShippingAddressPage(driver).typeNameAndAddress(ShippingAddress.ADDRESS_FIRSTNAME, ShippingAddress.ADDRESS_LASTNAME,
                ShippingAddress.ADDRESS_FIRSTLINE, ShippingAddress.ADDRESS_CITY, ShippingAddress.ADDRESS_POSTCODE);
        new ShippingAddressPage(driver).selectCountry("Germany");
        new ShippingAddressPage(driver).clickContinueBtn();
        new PaymentPage(driver).clickContinueBtn();
        new PreviewPage(driver).clickPlaceOrderBtn();
        new ConfirmationPage(driver).clickContinueShoppingBtn();
        new HomePage(driver).clickOnAccountLink();

        new ProfilePage(driver).clickOnOrderHistoryLink();
        new OrderHistoryPage(driver).clickOnOrderNummerLink();
        String productNameFromOrder =new OrderPage(driver).getProductNameFromOrder();

        Assert.assertEquals(productName,productNameFromOrder);

    }

}
