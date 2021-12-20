package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BasketPage extends PageBase {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;
    @FindBy(css = ".input-group-btn .btn.btn-default")
    WebElement updateBtn;

    public BasketPage typeQuantity() {
        type(quantity, "0");
        return this;
    }

    public BasketPage clickUpdate() {
        click(updateBtn);
        return this;
    }

    @FindBy(css=".btn-block")
    WebElement proceedToCheckoutBtn;

    public ShippingAddressPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutBtn);
        return new ShippingAddressPage(driver);
    }

    public String verifyTextAboutEmptyBasket() {
        String text = driver.findElement(By.id("content_inner")).getText();
        return text;
    }
}
