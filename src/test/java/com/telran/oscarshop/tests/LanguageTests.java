package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LanguageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
    }


    @Test
    public void selectLanguageTest(){
        new ProfilePage(driver).selectLanguage("Deutsch");
        new ProfilePage(driver).clickGoButton();

        Assert.assertTrue(new ProfilePage(driver).takeTextGoButton().contains("Ausführen"));

        new ProfilePage(driver).selectLanguage("British English");
        new ProfilePage(driver).clickGoButton();

    }


}
