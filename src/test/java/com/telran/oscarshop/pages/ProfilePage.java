package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    public boolean isLogoutLinkPresent() {
        return isElementPresent(By.id("logout_link"));
    }

    public HomePage logout() {
        System.out.println("Let's out from profile!");
        click(logoutLink);
        return new HomePage(driver);
    }

    @FindBy(id = "id_q")
    WebElement searchFieldInput;

    @FindBy(xpath="//input[@type='submit']")
    WebElement searchBtn;

    public ProfilePage typeInSearchFieldInput(String productName) {
        type(searchFieldInput, productName);
        click(searchBtn);
        return this;
    }

    public String takeNameOfProduct() {
        pause(2000);
        String nameOfProduct = driver.findElement(By.xpath("//h3 //a[@href='/en-gb/catalogue/the-clean-coder_150/']")).getText();
        //String nameOfProduct = driver.findElement(By.xpath("//article[@class='product_pod'] //h3 //a[@href='/en-gb/catalogue/the-clean-coder_150/']")).getText();
        System.out.println(nameOfProduct);
        return nameOfProduct;
    }

    public String verifyEmptyField() {
        String text=driver.findElement(By.xpath("//div[@class='page-header action']//h1")).getText();
        System.out.println(text);
        return text;
    }
}
