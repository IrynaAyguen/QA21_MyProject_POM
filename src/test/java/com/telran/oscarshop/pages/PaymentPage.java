package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="view_preview")
    WebElement continueBtn2;

    public PreviewPage clickContinueBtn() {
        //pause(5000);
        click(continueBtn2);
       return new PreviewPage(driver) ;
    }
}
