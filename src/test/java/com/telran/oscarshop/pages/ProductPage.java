package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends PageBase {

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "id_q")
    WebElement searchFieldInput;

    public ProductPage typeInSearchFieldInput(String productName) {
        type(searchFieldInput, productName);
        return this;
    }


    public String takeNameOfProduct() {
        pause(2000);
        WebElement nameOfProduct = driver.findElement(By.xpath("//h3 //a[@href='/en-gb/catalogue/the-clean-coder_150/']"));
        String nameOfProductText = nameOfProduct.getText();
        System.out.println("founded product is:  " + nameOfProductText);
        return nameOfProductText;
    }

    public String verifySearchField() {
        String text = driver.findElement(By.xpath("//div[@class='page-header action']//h1")).getText();
        return text;
    }

    public String verifyNullResults() {
        String text = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getText();
        return text;
    }

    public String verifyNumberOfResults() {
        String text = driver.findElement(By.xpath("//form[@class='form-horizontal'] // strong[1]")).getText();
        System.out.println(text);
        return text;
    }


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
    }


    @FindBy(css = ".btn.btn-primary.btn-block")
    WebElement addToBasketBtnFromList;

    @FindBy(xpath = "//div[@class='alertinner '] / p / strong[1]")
    WebElement newBasketTotal;

    public ProductPage clickAddToBasketButtonFromList() {
        click(addToBasketBtnFromList);
        return this;
    }

    public boolean isNewBasketTotalCorrect() {
        String pP = driver.findElement(By.cssSelector(".product_price .price_color")).getText();
        String nBasketTotal = newBasketTotal.getText();
        System.out.println("pp"+pP+"pp");
        System.out.println("total"+nBasketTotal+"total");
        return (pP == nBasketTotal);
    }


    @FindBy(xpath = "//span[@class='btn-group']")
    WebElement viewBasketBtn;

    public BasketPage clickOnViewBasketButton() {
        click(viewBasketBtn);
        return new BasketPage(driver);
    }

    @FindBy(css = "#language_selector .form-control")
    WebElement languageMenu;

    public ProductPage selectLanguage(String text) {
        Select select = new Select(languageMenu);
        select.selectByVisibleText(text);
        return this;
    }

    @FindBy(css = "#language_selector .btn-default")
    WebElement goBtn;

    public ProductPage clickGoButton() {
        click(goBtn);
        return this;
    }


    public String takeTextGoButton() {
        String text = driver.findElement(By.cssSelector("#language_selector .btn-default")).getText();
        return text;
    }


    @FindBy(css = ".page-header.action")
    WebElement pageTitle;

    public boolean isItProductPage() {
        return pageTitle.isDisplayed();
    }

    public String verifyTitleBooks() {
        String text = driver.findElement(By.cssSelector(".page-header.action")).getText();
        return text;
    }


    @FindBy(xpath = "//li[2]//ul//li[1]//a[@href='/en-gb/catalogue/category/books/fiction_3/']")
    WebElement fictionCatalogue;

    public ProductPage selectFictionCategory() {
        fictionCatalogue.click();
        return this;
    }

    @FindBy(xpath = "//li[2]//ul//li[2]//a[@href='/en-gb/catalogue/category/books/non-fiction_5/']")
    WebElement nonFictionCatalogue;

    public ProductPage selectNonFictionCategory() {
        nonFictionCatalogue.click();
        return this;
    }


    @FindBy(xpath = "//div[@class='page-header action'][contains(.,'Fiction')]")
    WebElement fictionTitle;

    public boolean isFictionCategoryDisplayed() {
        return fictionTitle.isDisplayed();
    }


    @FindBy(xpath = "//div[@class='page-header action'][contains(.,'Non-Fiction')]")
    WebElement nonFictionTitle;

    public boolean isNonFictionCategoryDisplayed() {
        return nonFictionTitle.isDisplayed();
    }


    public String getProductNameFromList(int number) {
        return driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") h3 > a")).getText();
    }


    public ProductPage clickOnProductNameFromList(int number) {
        driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") h3 > a")).click();
        return this;
    }


    @FindBy(css = "h1")
    WebElement productName;

    public String getProductName() {
        return productName.getText();
    }


    @FindBy(id = "add_to_basket_form")
    WebElement addToBasketBtn;

    public ProductPage clickOnAddToBasketButton() {
        click(addToBasketBtn);
        return this;
    }


    @FindBy(xpath = "//div[@class='col-sm-6 product_main'] //p[1]")
    WebElement price;

    public String getProductPrice() {
        String pPrice = price.getText();
        return pPrice;
    }

    public ProductPage clickOnAddToBasketFromList(int number) {
        //driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") h3 > a")).click();
        driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") form")).click();
        return this;
    }


    @FindBy(xpath = "//div[@id='messages'] //div[1]//div")
    WebElement message;

    public String getMessage() {
        return message.getText();
    }
}
