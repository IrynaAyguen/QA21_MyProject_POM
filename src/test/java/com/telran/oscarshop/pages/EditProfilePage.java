package com.telran.oscarshop.pages;

import com.telran.oscarshop.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class EditProfilePage extends PageBase {

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "h1")
    WebElement editProfileTitle;

    public String takeTitleText() {
        return editProfileTitle.getText();
    }


    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    public EditProfilePage typeFirstNameField() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        type(firstNameField, "TestFirstName" + i);
        return this;
    }


    @FindBy(id = "id_last_name")
    WebElement lastNameField;

    public EditProfilePage typeLastNameField() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        type(lastNameField, "TestLastName" + i);
        return this;
    }


    @FindBy(id = "id_email")
    WebElement emailField;

    public EditProfilePage typeEmailField() {
        int i = (int) ((System.currentTimeMillis()) / 1000) % 3600;
        type(emailField, i+UserData.USER_EMAIL);
        return this;
    }


    @FindBy(css=".btn-lg.btn-primary")
    WebElement saveBtn;

    public ProfilePage clickOnSaveButton() {
        click(saveBtn);
        return new ProfilePage(driver);
    }

    public EditProfilePage typeEmailFieldForReturn() {
        type(emailField, UserData.USER_EMAIL);
        return this;
    }

}
