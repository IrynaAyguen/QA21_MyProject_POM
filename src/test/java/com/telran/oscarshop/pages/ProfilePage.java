package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    public String verifyTitleOfPage() {
        String text = driver.findElement(By.cssSelector("h1")).getText();
        return text;
    }


    public String getEmailOfUserFromProfilePge() {
        String eMail = driver.findElement(By.xpath("//tbody /tr[2]/td")).getText();
        return eMail;
    }


    @FindBy(xpath = "//a[@href='/en-gb/accounts/change-password/']")
    WebElement changePasswordBtn;

    public ChangePasswordPage clickOnChangePasswordButton() {
        click(changePasswordBtn);
        return new ChangePasswordPage(driver);
    }


    @FindBy(xpath = "//a[@href='/en-gb/accounts/profile/edit/']")
    WebElement editProfileBtn;

    public EditProfilePage clickOnEditProfileButton() {
        click(editProfileBtn);
        return new EditProfilePage(driver);
    }


    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public DeleteProfilePage clickOnDeleteProfileButton() {
        click(deleteProfileBtn);
        return new DeleteProfilePage(driver);
    }


    @FindBy(css=".wicon")
    WebElement messagePassUpdated;

    public String takeMessageText() {
        return messagePassUpdated.getText();
    }
}
