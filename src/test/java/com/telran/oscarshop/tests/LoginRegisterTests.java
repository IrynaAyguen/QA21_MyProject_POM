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

    @Test(enabled = false)
    public void registrationAndLoginPositiveTest(){
        new LoginRegistrationPage(driver).registrationAndLogin("test8@test8.de","Test8123!", "Test8123!");
        Assert.assertTrue(new ProfilePage(driver).isLogoutLinkPresent());
        System.out.println("***** registration is OK");
        new ProfilePage(driver).logout();
    }

    @Test
    public void registrationWithEmptyEmailFieldNegativeTest(){
        new LoginRegistrationPage(driver).registrationNegative("",UserData.USER_PASSWORD1, UserData.USER_PASSWORD);
        Assert.assertTrue(new LoginRegistrationPage(driver).isLoginOrRegisterLinkPresent());
    }

    @Test
    public void registrationOfExistingUserNegativeTest(){
        new LoginRegistrationPage(driver).registrationNegative(UserData.USER_EMAIL,UserData.USER_PASSWORD1, UserData.USER_PASSWORD);
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutExistingUser()
                .contains("already exists"));
    }

    @Test
    public void registrationWithShortPasswordNegativeTest(){
        new LoginRegistrationPage(driver).registrationNegative("test8@test8.de","456", "456");
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutShortPassword()
                .contains("at least 9 characters"));
    }

    @Test
    public void registrationWithNotMatchingPasswordsNegativeTest(){
        new LoginRegistrationPage(driver).registrationNegative("test8@test8.de","Test8123!", "Test8123!!!!!");
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutNotMatchingPasswords()
                .contains("two password fields didn't match"));
    }


    @Test
    public void LoginPositiveTest(){
        new LoginRegistrationPage(driver).login(UserData.USER_EMAIL,UserData.USER_PASSWORD);
        Assert.assertTrue(new ProfilePage(driver).isLogoutLinkPresent());
        System.out.println("***** login is OK");
        new ProfilePage(driver).logout();
    }

    @Test
    public void loginWithIncorrectEmailOrPasswordNegativeTest(){
        new LoginRegistrationPage(driver).loginNegative(UserData.USER_EMAIL,"123456789");
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutIncorrectData()
                .contains("Please enter a correct username and password"));
    }

    @Test
    public void loginWithEmptyPasswordFieldNegativeTest(){
        new LoginRegistrationPage(driver).loginNegative(UserData.USER_EMAIL,"");
        Assert.assertTrue(new LoginRegistrationPage(driver).isMessagePresent());
    }
}
