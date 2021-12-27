package com.telran.oscarshop.tests;

import com.telran.oscarshop.data.ProductData;
import com.telran.oscarshop.data.UserData;
import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginRegistrationPage;
import com.telran.oscarshop.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (new HomePage(driver).isLogoutLinkPresent()) {
            new HomePage(driver).clickOnLogoutLink();
        }
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).selectBooksCategory();
    }


    @Test
    public void guestCanSelectFictionCategoryTest() {
        new ProductPage(driver).selectFictionCategory();

        Assert.assertTrue(new ProductPage(driver).isFictionCategoryDisplayed());
    }

    @Test
    public void guestCanSelectNonFictionCategoryTest() {
        new ProductPage(driver).selectNonFictionCategory();

        Assert.assertTrue(new ProductPage(driver).isNonFictionCategoryDisplayed());
    }

    @Test
    public void compareProductNameFromListWithProductNameTest() {
        String ProductNameFromList = new ProductPage(driver).getProductNameFromList(1);
        new ProductPage(driver).clickOnProductNameFromList(1);
        String productName = new ProductPage(driver).getProductName();

        Assert.assertEquals(ProductNameFromList,productName);
    }

    @Test
    public void guestCanAddFirstProductInListToBasketTest() {
        new ProductPage(driver).clickOnProductNameFromList(1);
        new ProductPage(driver).clickOnAddToBasketButton();
        String productPrice = new ProductPage(driver).getProductPrice();
        String productName = new ProductPage(driver).getProductName();
        new ProductPage(driver).clickOnViewBasketButton();
        String productPriceInBasket = new BasketPage(driver).getProductPriceInBasketPage();
        String productNameInBasket = new BasketPage(driver).getProductNameInBasket();

        Assert.assertEquals(productPrice,productPriceInBasket);
        Assert.assertEquals(productName,productNameInBasket);

        new BasketPage(driver).typeZeroQuantity().clickUpdate();

    }


    @Test
    public void numberOfFoundedProductsOnPageTest(){
        new HomePage(driver).typeInSearchFieldInput("City");
        new HomePage(driver).clickOnSearchButton();
        Assert.assertTrue(new ProductPage(driver).isNumberOfProductsOnPageEqualsListSizeOnPage());
    }

}
