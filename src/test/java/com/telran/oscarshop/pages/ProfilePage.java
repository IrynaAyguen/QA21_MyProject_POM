package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    public String verifyTitleOfPage() {
        String text = driver.findElement(By.cssSelector("h1")).getText();
        return text;
    }


    public String getEmailOfUserFromProfilePage() {
        pause(2000);
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
        pause(2000);
        click(editProfileBtn);
        return new EditProfilePage(driver);
    }


    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public DeleteProfilePage clickOnDeleteProfileButton() {
        pause(2000);
        click(deleteProfileBtn);
        return new DeleteProfilePage(driver);
    }


    @FindBy(css = ".wicon")
    WebElement messagePassUpdated;

    public String takeMessageText() {
        return messagePassUpdated.getText();
    }


    @FindBy(xpath = "//a[@href='/en-gb/accounts/orders/']")
    WebElement orderHistoryLink;

    public OrderHistoryPage clickOnOrderHistoryLink() {
        pause(2000);
        click(orderHistoryLink);
        return new OrderHistoryPage(driver);
    }


    @FindBy(xpath = "//a[@href='/en-gb/accounts/addresses/']")
    WebElement addressBookLink;

    public AddressBookPage clickOnAddressBookLink() {
        pause(2000);
        click(addressBookLink);
        return new AddressBookPage(driver);
    }
}
