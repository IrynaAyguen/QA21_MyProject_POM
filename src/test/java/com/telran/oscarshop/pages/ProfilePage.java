package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.List;

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

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchBtn;

    public ProfilePage typeInSearchFieldInput(String productName) {
        type(searchFieldInput, productName);
        click(searchBtn);
        return this;
    }

    public String takeNameOfProduct() {
        pause(2000);
        WebElement nameOfProduct = driver.findElement(By.xpath("//h3 //a[@href='/en-gb/catalogue/the-clean-coder_150/']"));
        String nameOfProductText = nameOfProduct.getText();
        System.out.println("founded product is:  " + nameOfProductText);
        return nameOfProductText;

        //String nameOfProduct = driver.findElement(By.xpath("//h3 //a[@href='/en-gb/catalogue/the-clean-coder_150/']")).getText();
        //String nameOfProduct = driver.findElement(By.xpath("//article[@class='product_pod'] //h3 //a[@href='/en-gb/catalogue/the-clean-coder_150/']")).getText();
        //return nameOfProduct;

    }

    public String verifySearchField() {
        String text = driver.findElement(By.xpath("//div[@class='page-header action']//h1")).getText();
        //System.out.println(text);
        return text;
    }

    public String verifyNullResults() {
        String text = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getText();
        //System.out.println(text);
        return text;
    }

    public String verifyNumberOfResults() {
        String text = driver.findElement(By.xpath("//form[@class='form-horizontal'] // strong[1]")).getText();
        System.out.println(text);
        return text;
    }

    //@FindBy(css = "section div .row")
    @FindBy(css = ".col-xs-6.col-sm-4.col-md-3.col-lg-3")
    List<WebElement> productsList;

    public Boolean isNumberOfProductsOnPageEqualsListSizeOnPage() {
        int nList = productsList.size();
        int nPage;
        int number1 = Integer.parseInt(driver.findElement(By.xpath("//form[@class='form-horizontal'] // strong[1]")).getText());
        if (number1 > 20) {
            int number3 = Integer.parseInt(driver.findElement(By.xpath("//form[@class='form-horizontal'] // strong[3]")).getText());
            int number2 = Integer.parseInt(driver.findElement(By.xpath("//form[@class='form-horizontal'] // strong[2]")).getText());
            nPage = number3 - number2 + 1;
        } else {
            nPage = number1;
        }
        return (nPage == nList);
//        if (nPage == nList) {
//            return true;
//        } else {
//            return false;
//        }
    }


    @FindBy(css = ".btn.btn-primary.btn-block")
    WebElement addToBasketBtn;

    @FindBy(xpath = "//div[@class='alertinner '] / p / strong[1]")
    WebElement newBasketTotal;

    public ProfilePage clickAddToBasketButton() {
        click(addToBasketBtn);
        return this;
    }

    public boolean isNewBasketTotalCorrect() {
        String pP = driver.findElement(By.cssSelector(".product_price .price_color")).getText();

        double pPrice = Double.parseDouble(pP.substring(1));
        System.out.println("*************pP= " + pPrice);
        double nBasketTotal = Double.parseDouble((newBasketTotal.getText()).substring(1));

        return (pPrice == nBasketTotal);
    }


    @FindBy(xpath = "//span[@class='btn-group']")
    WebElement viewBasketBtn;

    public BasketPage clickViewBasketButton() {
        click(viewBasketBtn);
        return new BasketPage(driver);
    }

    @FindBy(css = "#language_selector .form-control")
    WebElement languageMenu;

    public ProfilePage selectLanguage(String text) {
        Select select = new Select(languageMenu);
        select.selectByVisibleText(text);
        return this;
    }

    @FindBy(css = "#language_selector .btn-default")
    WebElement goBtn;

    public ProfilePage clickGoButton() {
        click(goBtn);
        return this;
    }


    public String takeTextGoButton() {
        String text = driver.findElement(By.cssSelector("#language_selector .btn-default")).getText();
        return text;
    }
}
