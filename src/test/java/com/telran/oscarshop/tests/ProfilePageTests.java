package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
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


    @Test
    public void userCanChangePasswordTest(){
        new ProfilePage(driver).clickOnChangePasswordButton();
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


    @Test
    public void userCanEditProfileTest(){
        String oldName = driver.findElement(By.xpath("//tbody /tr[1]/td")).getText();
        System.out.println("oldName: " + oldName);
        new ProfilePage(driver).clickOnEditProfileButton();
        new EditProfilePage(driver).typeFirstNameField();
        new EditProfilePage(driver).typeLastNameField();
        new EditProfilePage(driver).typeEmailField();
        new EditProfilePage(driver).clickOnSaveButton();
        String newName = driver.findElement(By.xpath("//tbody /tr[1]/td")).getText();
        System.out.println("newName: " + newName);
        String newEmail = driver.findElement(By.xpath("//tbody /tr[2]/td")).getText();
        System.out.println("newEmai: " + newEmail);
        Assert.assertTrue(new ProfilePage(driver).takeMessageText().contains("Profile updated"));
        Assert.assertNotEquals(oldName,newName);

        //Return old email

        new ProfilePage(driver).clickOnEditProfileButton();
        new EditProfilePage(driver).typeEmailFieldForReturn();
        new EditProfilePage(driver).clickOnSaveButton();
    }



    @Test
    public void userCanDeleteProfileTest() {
        new ProfilePage(driver).clickOnDeleteProfileButton();
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
