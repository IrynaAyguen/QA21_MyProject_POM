package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void guestCanSelectProductCategoryFromMenuTest(){
        new HomePage(driver).selectBooksCategory();
        Assert.assertTrue(new ProductPage(driver).isItProductPage());
        Assert.assertTrue(new ProductPage(driver).verifyTitleBooks().contains("Books"));
    }


    @Test
    public void guestCanSelectLanguageTest(){
        new HomePage(driver).selectLanguage("Deutsch");
        new HomePage(driver).clickGoButton();

        Assert.assertTrue(new HomePage(driver).takeTextOfGoButton().contains("Ausführen"));

        new HomePage(driver).selectLanguage("British English");
        new HomePage(driver).clickGoButton();
    }


    @Test
    public void guestCanClickLoginOrRegisterLinkTest(){
        new HomePage(driver).getLoginRegisterPage();
        Assert.assertTrue(new LoginRegistrationPage(driver).isItLoginRegisterPage());
    }


    @Test
    public void guestCanSearchProductWithWortTest(){
        new HomePage(driver).typeInSearchFieldInput("Computer");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).verifySearchField().contains("Products matching \"Computer\""));
    }

    @Test
    public void userCanGoToProfileTest(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).clickOnAccountLink();

        Assert.assertTrue(new ProfilePage(driver).verifyTitleOfPage().contains("Profile"));

        Assert.assertEquals(new ProfilePage(driver).getEmailOfUserFromProfilePge(),UserData.USER_EMAIL);
    }

    @Test
    public void userCanLogoutTest(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).clickOnLogoutLink();
        Assert.assertTrue(new HomePage(driver).isLoginOrRegisterLinkPresent());

    }
}
