package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class AddressBookPage extends PageBase{

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="h1")
    WebElement titleOfAddressBookPage;

    public String getPageTitle() {
        return titleOfAddressBookPage.getText();
    }


    @FindBy(xpath = "//a[@href='/en-gb/accounts/addresses/396/']")
    WebElement editAddressBookBtn;

    public EditAddressPage clickEditButton() {
        click(editAddressBookBtn);
        return new EditAddressPage(driver);
    }

    @FindBy(css=".wicon")
    WebElement messageAboutUpdate;

    public String getMessageAboutUpdate() {
        return messageAboutUpdate.getText();
    }
}
