package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmationPage extends PageBase {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".col-sm-offset-4 .btn-lg")
    WebElement continueShoppingBtn;

    public ProductPage clickContinueShoppingBtn() {
        click(continueShoppingBtn);
        return new ProductPage(driver);
    }
}
