package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.helpers.DataProviders;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
        new HomePage(driver).getLoginRegisterPage();/////////////
    }


    @Test
    public void LoginPositiveTest() {
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        Assert.assertTrue(new HomePage(driver).isLogoutLinkPresent());
        new HomePage(driver).clickOnLogoutLink();
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "userNegativeLoginUsingFileCSV")
    public void loginWithDataProviderNegativeTest(String eMail, String password) {
        new LoginRegistrationPage(driver).loginNegative(eMail, password);
        Assert.assertTrue(new LoginRegistrationPage(driver).isLoginOrRegisterLinkPresent());
    }


    ///////////////////

    @Test
    public void verifyMessageByLoginWithIncorrectPasswordTest() {
        new LoginRegistrationPage(driver).loginNegative(UserData.USER_EMAIL, "123456789");
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutIncorrectData()
                .contains("Please enter a correct username and password"));
    }

    @Test
    public void verifyMessageByLoginWithIncorrectEmailTest() {
        new LoginRegistrationPage(driver).loginNegative("Test66@test66.de", UserData.USER_PASSWORD);
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutIncorrectData()
                .contains("Please enter a correct username and password"));
    }


    @Test
    public void verifyIsMessagePresentAboutLoginWithEmptyPasswordFieldTest() {
        new LoginRegistrationPage(driver).loginNegative(UserData.USER_EMAIL, "");
        Assert.assertTrue(new LoginRegistrationPage(driver).isMessagePresent());
    }


    @Test
    public void verifyIsMessagePresentAboutLoginWithEmptyEmailFieldTest() {
        new LoginRegistrationPage(driver).loginNegative("", UserData.USER_PASSWORD);
        Assert.assertTrue(new LoginRegistrationPage(driver).isMessagePresent());
    }

}
