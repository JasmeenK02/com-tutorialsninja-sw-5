package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DesktopTest extends BaseTest {

    HomePage homePage ;
    DesktopPage desktopPage ;
    ProductPage productPage ;

    ShoppingCartPage cartPage ;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();

        cartPage = new ShoppingCartPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        // Select sort by Name Z - A
        desktopPage.selectSortByOption("Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getProductsNameList();
        softAssert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
        softAssert.assertAll();
    }


    @Test(groups = {"sanity","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        desktopPage.selectSortByOption("Name (A - Z)");
        desktopPage.selectProductByName("HP LP3065");
        softAssert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        softAssert.assertEquals(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();
        softAssert.assertEquals(cartPage.getShoppingCartText(),"Shopping Cart");
        softAssert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");
        softAssert.assertEquals(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");
        softAssert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");
        softAssert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
        softAssert.assertAll();
    }
}
