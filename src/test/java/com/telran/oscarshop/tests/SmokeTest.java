package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ShippingAddress;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Double.parseDouble;

public class SmokeTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
    }

    @Test
    public void userCanOrderProductPositiveTest() {

        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).clickOnViewBasket();
        new BasketPage(driver).cleanBasket();
        new BasketPage(driver).clickOnLogo();

        new HomePage(driver).selectBooksCategory();
        String ProductNameFromList = new ProductPage(driver).getProductNameFromList(1);
        new ProductPage(driver).clickOnAddToBasketFromList(1);
        String message = new ProductPage(driver).getMessage();

        Assert.assertTrue(message.contains(ProductNameFromList));

        new ProductPage(driver).clickOnAddToBasketFromList(2);
        new ProductPage(driver).clickOnViewBasketButton();

        Assert.assertTrue(new BasketPage(driver).isTwoItemsInBasket());

        Assert.assertTrue(new BasketPage(driver).isTotalSumCorrect());

        String totalInBasket = new BasketPage(driver).getTotalInBasket();
        new BasketPage(driver).clickProceedToCheckoutButton();
        new ShippingAddressPage(driver).selectTitle("Mrs");
        new ShippingAddressPage(driver).typeNameAndAddress(ShippingAddress.ADDRESS_FIRSTNAME, ShippingAddress.ADDRESS_LASTNAME,
                ShippingAddress.ADDRESS_FIRSTLINE, ShippingAddress.ADDRESS_CITY, ShippingAddress.ADDRESS_POSTCODE);
        new ShippingAddressPage(driver).selectCountry("Germany");
        new ShippingAddressPage(driver).clickContinueBtn();
        new PaymentPage(driver).clickContinueBtn();
        new PreviewPage(driver).clickPlaceOrderBtn();
        new ConfirmationPage(driver).clickContinueShoppingBtn();
        new ProductPage(driver).clickOnViewBasketButton();

        Assert.assertTrue(new BasketPage(driver).verifyTextAboutEmptyBasket().contains("Your basket is empty"));

        new HomePage(driver).clickOnAccountLink();
        new ProfilePage(driver).clickOnOrderHistoryLink();

        String totalInOrderHistory = new OrderHistoryPage(driver).getTotalInOrderHistory();
        Assert.assertEquals(totalInBasket,totalInOrderHistory);
    }
}



