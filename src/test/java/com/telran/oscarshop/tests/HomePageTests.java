package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
    }

    @Test
    public void guestCanClickLoginOrRegisterLinkTest() {
        new HomePage(driver).getLoginRegisterPage();
        Assert.assertTrue(new LoginRegistrationPage(driver).isItLoginRegisterPage());
    }


    @Test
    public void guestCanSelectAllProductsCategoryFromMenuTest() {
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectAllProductsCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
        Assert.assertTrue(new ProductPage(driver).verifyTitleBooks().contains("All products"));
    }

    @Test
    public void guestCanSelectClothingCategoryFromMenuTest() {
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectClothingCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
        Assert.assertTrue(new ProductPage(driver).verifyTitleBooks().contains("Clothing"));
    }


    @Test
    public void guestCanSelectBooksCategoryFromMenuTest() {
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectBooksCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
        Assert.assertTrue(new ProductPage(driver).verifyTitleBooks().contains("Books"));
    }


    @Test
    public void guestCanSelectOffersCategoryFromMenuTest() {
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectOffersCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
        Assert.assertTrue(new ProductPage(driver).verifyTitleBooks().contains("Offers"));
    }


    @Test
    public void checkClickabilityOfLogoTest() {
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectBooksCategory();
        new HomePage(driver).clickOnLogo();
        Assert.assertTrue(new HomePage(driver).getSubtitleOfHomePage().contains("Welcome!"));
    }


    @Test
    public void guestCanSelectLanguageTest() {
        new HomePage(driver).selectLanguage("Deutsch");
        new HomePage(driver).clickGoButton();
        Assert.assertTrue(new HomePage(driver).takeTextSumme().contains("Summe"));
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickGoButton();
    }


    @Test
    public void guestCanSearchProductByWortTest() {
        new HomePage(driver).typeInSearchFieldInput("Computer");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifySearchField().contains("Products matching \"Computer\""));
    }


    @Test
    public void searchOfProductWithNamePositiveTest() {
        new HomePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).takeNameOfProduct().contains(ProductData.PRODUCT_NAME));
    }


    @Test
    public void verifyEmptySearchFieldTest() {
        new HomePage(driver).typeInSearchFieldInput("  ");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifySearchField().contains("Products matching \"\""));
    }


    @Test
    public void searchOfProductNegativeTest() {
        new HomePage(driver).typeInSearchFieldInput("11111");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifyNullResults().contains("Found 0 results."));
    }


    @Test
    public void guestCanViewBasketTest() {
        new HomePage(driver).typeInSearchFieldInput(ProductData.PRODUCT_NAME);
        new HomePage(driver).clickOnSearchButton();
        new ProductPage(driver).clickAddToBasketButtonFromList();
        new ProductPage(driver).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(driver).getTitleOfBasketPage().contains("Basket"));
    }


    @Test
    public void userCanGoToProfileTest() {
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        new HomePage(driver).clickOnAccountLink();
        Assert.assertTrue(new ProfilePage(driver).verifyTitleOfPage().contains("Profile"));
        Assert.assertEquals(new ProfilePage(driver).getEmailOfUserFromProfilePage(), UserData.USER_EMAIL);
    }


    @Test
    public void userCanLogoutTest() {
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        new HomePage(driver).clickOnLogoutLink();
        Assert.assertTrue(new HomePage(driver).isLoginOrRegisterLinkPresent());
    }


}
