package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderPage extends PageBase {

    public OrderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(1) > p > a")
    WebElement productNameFromOrder;

    public String getProductNameFromOrder() {
        return productNameFromOrder.getText();
    }
}
