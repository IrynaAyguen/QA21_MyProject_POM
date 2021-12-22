package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.ChangePasswordPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).clickOnAccountLink();
        new ProfilePage(driver).clickOnChangePasswordButton();
    }


    @Test
    public void userCanChangePasswordTest(){
        new ChangePasswordPage(driver).typeOldPasswordField();
        new ChangePasswordPage(driver).typeNewPasswordField();
        new ChangePasswordPage(driver).typeNewPasswordConfirmationField();
        new ChangePasswordPage(driver).clickOnSaveButton();

        Assert.assertTrue(new ProfilePage(driver).takeMessageText().contains("Password updated"));
        //Return old password
        new ProfilePage(driver).clickOnChangePasswordButton();
        new ChangePasswordPage(driver).typeOldPasswordFieldForReturn();
        new ChangePasswordPage(driver).typeNewPasswordFieldForReturn();
        new ChangePasswordPage(driver).typeNewPasswordConfirmationFieldForReturn();
        new ChangePasswordPage(driver).clickOnSaveButton();
    }

}
