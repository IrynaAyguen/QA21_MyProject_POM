package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends PageBase {

    public BasketPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "id_form-0-quantity")
    WebElement quantity;
    @FindBy(css = ".input-group-btn .btn.btn-default")
    WebElement updateBtn;

    public BasketPage typeZeroQuantity() {
        type(quantity, "0");
        return this;
    }


    public BasketPage clickUpdate() {
        click(updateBtn);
        return this;
    }


    @FindBy(css = ".btn-block")
    WebElement proceedToCheckoutBtn;

    public ShippingAddressPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutBtn);
        return new ShippingAddressPage(driver);
    }


    public String verifyTextAboutEmptyBasket() {
        String text = driver.findElement(By.id("content_inner")).getText();
        return text;
    }


    public String getTitleOfBasketPage() {
        String text = driver.findElement(By.cssSelector(".action h1")).getText();
        return text;
    }


    @FindBy(css = ".col-sm-1 .price_color")
    WebElement priceInBasket;

    public String getProductPriceInBasketPage() {
        String pPriceInBasket = priceInBasket.getText();
        return pPriceInBasket;
    }


    @FindBy(css = "h3 a")
    WebElement productNameinBasket;

    public String getProductNameInBasket() {
        return productNameinBasket.getText();
    }


    @FindBy(css = ".basket-items")
    List<WebElement> itemsList;

    public boolean isTwoItemsInBasket() {
        return (itemsList.size() == 2);
    }


    public boolean isTotalSumCorrect() {
        double sum = 0.0;
        for (int i = 1; i <= itemsList.size(); i++) {
            double totalOfItem = Double.parseDouble(driver.findElement(By.xpath("//form[@class='basket_summary']/div[" + i + "] /div/div[5]"))
                    .getText().substring(1));
            sum = sum + totalOfItem;
        }
        double totalOfBasket;
        totalOfBasket = Double.parseDouble(driver.findElement(By.cssSelector(".align-right .price_color"))
                .getText().substring(1));

        return (sum == totalOfBasket);
    }


    public String getTotalInBasket() {
        String totalOfBasket = driver.findElement(By.cssSelector(".align-right .price_color"))
                .getText();
        return totalOfBasket;
    }


    @FindBy(css = ".h1 a")
    WebElement logoLink;

    public HomePage clickOnLogo() {
        click(logoLink);
        pause(2000);
        return new HomePage(driver);
    }


    public BasketPage cleanBasket() {
        while (isElementPresent(By.cssSelector(".basket-items"))) {
            type(quantity, "0");
            click(updateBtn);
            pause(2000);
        }
        return this;
    }
}
