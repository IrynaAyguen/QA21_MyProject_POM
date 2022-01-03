package com.telran.oscarshop.pages;

import com.telran.oscarshop.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DeleteProfilePage extends PageBase {

    public DeleteProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "h1")
    WebElement DeleteProfileTitle;

    public String takeTitleText() {
        return DeleteProfileTitle.getText();
    }


    @FindBy(id = "id_password")
    WebElement passwordField;

    public DeleteProfilePage typePasswordField() {
        type(passwordField, UserData.USER_PASSWORD1);
        return this;
    }


    @FindBy(css = ".btn-danger")
    WebElement deleteBtn;

    public HomePage clickOnDeleteButton() {
        click(deleteBtn);
        return new HomePage(driver);
    }


    public DeleteProfilePage typePasswordForDeleteField(String pass) {
        type(passwordField, pass);
        return this;
    }
}
