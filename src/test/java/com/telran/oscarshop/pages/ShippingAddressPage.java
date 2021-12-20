package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage extends PageBase {

    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="id_title")
    WebElement titleMenu;

    public ShippingAddressPage selectTitle(String text) {
        Select select = new Select(titleMenu);
        select.selectByVisibleText(text);
        return this;
    }

    @FindBy(id="id_first_name")
    WebElement addressFName;
    @FindBy(id="id_last_name")
    WebElement addressLName;
    @FindBy(id="id_line1")
    WebElement addressFLine;
    @FindBy(id="id_line4")
    WebElement addressCityLine;
    @FindBy(id="id_postcode")
    WebElement addressPostZipCode;

    public ShippingAddressPage typeNameAndAddress(String addressFirstname, String addressLastname, String addressFirstline,
                                                  String addressCity, String addressPostcode) {
        type(addressFName, addressFirstname);
        type(addressLName, addressLastname);
        type(addressFLine, addressFirstline);
        type(addressCityLine, addressCity);
        type(addressPostZipCode, addressPostcode);

        return this;
    }


    @FindBy(id="id_country")
    WebElement countryMenu;

    public ShippingAddressPage selectCountry(String text) {
        Select select = new Select(countryMenu);
        select.selectByVisibleText(text);
        return this;

    }


    @FindBy(css=".btn-primary")
    WebElement continueBtn;

    public PaymentPage clickContinueBtn() {
        click(continueBtn);
        return new PaymentPage(driver);
    }
}
