package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProfileTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        new HomePage(driver).clickOnAccountLink();
        new ProfilePage(driver).clickOnDeleteProfileButton();
    }


    @Test
    public void userCanDeleteProfileTest() {
        new DeleteProfilePage(driver).typePasswordField();
        new DeleteProfilePage(driver).clickOnDeleteButton();

        Assert.assertTrue(new HomePage(driver).isLoginOrRegisterLinkPresent());   //user is on HomePage as guest

        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD); //user can't login with deleted account
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutIncorrectData()
                .contains("Please enter a correct username and password"));

        //Return account
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).registrationAndLogin(UserData.USER_EMAIL,UserData.USER_PASSWORD1, UserData.USER_PASSWORD);
    }
}
