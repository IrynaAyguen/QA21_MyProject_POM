package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).clickOnAccountLink();
    }


    @Test
    public void userCanGoToChangePasswordPageTest(){
        new ProfilePage(driver).clickOnChangePasswordButton();
        Assert.assertTrue(new ChangePasswordPage(driver).takeTitleText().contains("Change Password"));
    }

    @Test
    public void userCanGoToEditProfilePageTest(){
        new ProfilePage(driver).clickOnEditProfileButton();
        Assert.assertTrue(new EditProfilePage(driver).takeTitleText().contains("Edit Profile"));
    }

    @Test
    public void userCanGoToDeleteProfilePageTest(){
        new ProfilePage(driver).clickOnDeleteProfileButton();
        Assert.assertTrue(new DeleteProfilePage(driver).takeTitleText().contains("Delete profile"));
    }
}
