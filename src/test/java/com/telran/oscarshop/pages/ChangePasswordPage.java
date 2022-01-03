package com.telran.oscarshop.pages;

import com.telran.oscarshop.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase {

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "h1")
    WebElement changePasswordTitle;

    public String takeTitleText() {
        String text = changePasswordTitle.getText();
        return text;
    }


    @FindBy(id = "id_old_password")
    WebElement oldPasswordField;

    public ChangePasswordPage typeOldPasswordField() {
        type(oldPasswordField, UserData.USER_PASSWORD);
        return this;
    }


    @FindBy(id = "id_new_password1")
    WebElement newPassword1Field;

    public ChangePasswordPage typeNewPasswordField() {
        type(newPassword1Field, UserData.USER_PASSWORD + "new");
        return this;
    }


    @FindBy(id = "id_new_password2")
    WebElement newPassword2Field;

    public ChangePasswordPage typeNewPasswordConfirmationField() {
        type(newPassword2Field, UserData.USER_PASSWORD + "new");
        return this;
    }


    @FindBy(css = ".btn-lg.btn-primary")
    WebElement saveBtn;

    public ProfilePage clickOnSaveButton() {
        click(saveBtn);
        return new ProfilePage(driver);
    }


    public ChangePasswordPage typeOldPasswordFieldForReturn() {
        type(oldPasswordField, UserData.USER_PASSWORD + "new");
        return this;
    }

    public ChangePasswordPage typeNewPasswordFieldForReturn() {
        type(newPassword1Field, UserData.USER_PASSWORD);
        return this;
    }

    public ChangePasswordPage typeNewPasswordConfirmationFieldForReturn() {
        type(newPassword2Field, UserData.USER_PASSWORD);
        return this;
    }
}
