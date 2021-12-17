package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginRegisterTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
    }

    @Test
    public void registrationAndLoginPositiveTest(){

        new LoginRegistrationPage(driver).registrationAndLogin("test7@test7.de","Test7123!", "Test7123!");
        Assert.assertTrue(new ProfilePage(driver).isLogoutLinkPresent());
        System.out.println("***** registration is OK");
        new ProfilePage(driver).logout();
    }

    @Test
    public void LoginPositiveTest(){

        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        Assert.assertTrue(new ProfilePage(driver).isLogoutLinkPresent());
        System.out.println("***** login is OK");
        new ProfilePage(driver).logout();
    }
}
