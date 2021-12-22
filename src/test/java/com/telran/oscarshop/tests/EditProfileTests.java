package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        new HomePage(driver).clickOnAccountLink();

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

}
