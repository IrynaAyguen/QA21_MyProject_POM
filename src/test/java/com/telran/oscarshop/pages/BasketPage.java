package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clicktProceedToCheckoutButton() {
        click(proceedToCheckoutBtn);
    }
}
