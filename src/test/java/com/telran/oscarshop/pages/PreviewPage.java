package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewPage extends PageBase{

    public PreviewPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="place-order")
    WebElement placeOrderBtn;

    public ConfirmationPage clickPlaceOrderBtn() {
        click(placeOrderBtn);
        return new ConfirmationPage(driver);
    }
}
