package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.helpers.DataProviders;
import com.telran.oscarshop.helpers.PropertiesLoader;
import com.telran.oscarshop.pages.DeleteProfilePage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests extends TestBase{

    public  static String email = PropertiesLoader.loadProperty("valid.email");
    public  static String password = PropertiesLoader.loadProperty("valid.password");

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getLoginRegisterPage();
    }


    @Test(enabled = false)
    public void registrationAndLoginPositiveTest(){
        new LoginRegistrationPage(driver).registrationAndLogin(email,password, password);
        Assert.assertTrue(new HomePage(driver).isLogoutLinkPresent());

        new HomePage(driver).clickOnAccountLink();
        new ProfilePage(driver).clickOnDeleteProfileButton();
        new DeleteProfilePage(driver).typePasswordForDeleteField(password);
        new DeleteProfilePage(driver).clickOnDeleteButton();
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "userNegativeRegistrationUsingFileCSV")
    public void registrationWithDataProviderNegativeTest(String eMail, String password1, String password2) {
        new LoginRegistrationPage(driver).registrationNegative(eMail, password1, password2);
        Assert.assertTrue(new LoginRegistrationPage(driver).isLoginOrRegisterLinkPresent());
    }



    /////////////////////////////////

    @Test
    public void verifyMessageByRegistrationOfExistingUserTest(){
        new LoginRegistrationPage(driver).registrationNegative(UserData.USER_EMAIL,UserData.USER_PASSWORD1, UserData.USER_PASSWORD);
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutExistingUser()
                .contains("already exists"));
    }

    @Test
    public void verifyMessageByRegistrationWithShortPasswordTest(){
        new LoginRegistrationPage(driver).registrationNegative("test8@test8.de","456", "456");
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutShortPassword()
                .contains("at least 9 characters"));
    }

    @Test
    public void verifyMessageByRegistrationWithNotMatchingPasswordsTest(){
        new LoginRegistrationPage(driver).registrationNegative("test8@test8.de","Test8123!", "Test8123!!!!!");
        Assert.assertTrue(new LoginRegistrationPage(driver).getMessageAboutNotMatchingPasswords()
                .contains("two password fields didn't match"));
    }




}
