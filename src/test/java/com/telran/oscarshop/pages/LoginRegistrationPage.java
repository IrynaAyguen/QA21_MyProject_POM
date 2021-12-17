package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends PageBase {

    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement registrationEmail;

    @FindBy(id = "id_registration-password1")
    WebElement registrationPassword1;

    @FindBy(id = "id_registration-password2")
    WebElement registrationPassword2;

    @FindBy(css = "[name=registration_submit]")
    WebElement registrationBtn;

    public ProfilePage registrationAndLogin(String regEmail, String psw1, String psw2){
        type(registrationEmail, regEmail);
        type(registrationPassword1, psw1);
        type(registrationPassword2, psw2);
        click(registrationBtn);

        return new ProfilePage(driver);
    }

    public LoginRegistrationPage registrationNegative(String regEmail, String psw1, String psw2){
        type(registrationEmail, regEmail);
        type(registrationPassword1, psw1);
        type(registrationPassword2, psw2);
        click(registrationBtn);

        return this;
    }


    @FindBy(id = "id_login-username")
    WebElement loginEmail;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(css = "[name=login_submit]")
    WebElement loginBtn;

    public ProfilePage login(String logEmail, String psw) {
        type(loginEmail, logEmail);
        type(loginPassword, psw);
        click(loginBtn);

        return new ProfilePage(driver);
    }
}
