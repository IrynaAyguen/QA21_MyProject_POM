package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="login_link")
    WebElement LoginRegisterLink;

    public LoginRegistrationPage getLoginRegisterPage() {
        click(LoginRegisterLink);
        return new LoginRegistrationPage(driver);
    }


}
