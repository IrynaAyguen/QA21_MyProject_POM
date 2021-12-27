package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase{

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//tbody/ tr[2] /td[3]")
    WebElement totalInOrderHistory;

    public double getTotalInOrderHistory() {
        return Double.parseDouble(totalInOrderHistory.getText().replace("£",""));
    }


    @FindBy(css="tbody:nth-child(1) tr:nth-child(2) td:nth-child(1) > a")
    WebElement orderNummerLink;

    public OrderPage clickOnOrderNummerLink() {
        click(orderNummerLink);
        return new OrderPage(driver);
    }
}
