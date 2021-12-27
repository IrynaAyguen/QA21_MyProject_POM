package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.ShippingAddress;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBookTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
        new HomePage(driver).getLoginRegisterPage();/////////////
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).selectBooksCategory();
        new ProductPage(driver).clickOnAddToBasketFromList(1);
        new ProductPage(driver).clickOnViewBasketButton();
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
    }


    @Test
    public void userCanEditAddressPositiveTest(){
        new ProfilePage(driver).clickOnAddressBookLink();

        Assert.assertTrue(new AddressBookPage(driver).getPageTitle().contains("Address Book"));

        new AddressBookPage(driver).clickEditButton();
        new EditAddressPage(driver).changePostCode("36359");
        new EditAddressPage(driver).clickSaveButton();

        Assert.assertTrue(new AddressBookPage(driver).getMessageAboutUpdate().contains("36359"));

        //return old postCode
        new AddressBookPage(driver).clickEditButton();
        new EditAddressPage(driver).changePostCode(ShippingAddress.ADDRESS_POSTCODE);
        new EditAddressPage(driver).clickSaveButton();

    }


}
