package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAddressPage extends PageBase{

    public EditAddressPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id="id_postcode")
    WebElement postCodeField;

    public EditAddressPage changePostCode(String postCode) {
        type(postCodeField,postCode);
        return this;
    }


    @FindBy(css=".btn-lg.btn-primary")
    WebElement saveBtn;

    public AddressBookPage clickSaveButton() {
        click(saveBtn);
        return new AddressBookPage(driver);
    }
}
