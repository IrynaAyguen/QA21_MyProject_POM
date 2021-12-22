package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="login_link")
    WebElement LoginRegisterLink;

    public LoginRegistrationPage getLoginRegisterPage() {
        click(LoginRegisterLink);
        return new LoginRegistrationPage(driver);
    }


    @FindBy(css=".dropdown-submenu")
    WebElement submenuBook;

    public ProductPage selectBooksCategory() {
        click(submenuBook);
        return new ProductPage(driver);
    }


    @FindBy(css = "#language_selector .form-control")
    WebElement languageMenu;

    public HomePage selectLanguage(String text) {
        Select select = new Select(languageMenu);
        select.selectByVisibleText(text);
        return this;
    }


    @FindBy(css = "#language_selector .btn-default")
    WebElement goBtn;

    public HomePage clickGoButton() {
        click(goBtn);
        return this;
    }


    public String takeTextOfGoButton() {
         String text = driver.findElement(By.cssSelector("#language_selector .btn-default")).getText();
         return text;
    }


    @FindBy(id = "id_q")
    WebElement searchFieldInput;

    public HomePage typeInSearchFieldInput(String productName) {
        type(searchFieldInput, productName);
        return this;
    }


    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchBtn;

    public ProductPage clickOnSearchButton() {
        click(searchBtn);
        return new ProductPage(driver);
    }

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    public boolean isLogoutLinkPresent() {
        return isElementPresent(By.id("logout_link"));
    }


    public HomePage clickOnLogoutLink() {
        System.out.println("Let's out from profile!");
        click(logoutLink);
        return new HomePage(driver);
    }


    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right'] /li[1]")
    WebElement accountLink;

    public ProfilePage clickOnAccountLink() {
        click(accountLink);
        return new ProfilePage(driver);
    }


    public boolean isLoginOrRegisterLinkPresent() {
        return isElementPresent(By.id("login_link"));
    }
}
