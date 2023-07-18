package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() {
        Reporter.log("get Shopping Cart Text  " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "get Shopping Cart Text " );
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("get ProductName Text  " + productName.toString());
        CustomListeners.test.log(Status.PASS, "get ProductName Text  " );
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        Reporter.log("get Delivery Date  " + deliveryDate.toString());
        CustomListeners.test.log(Status.PASS, "get Delivery Date   ");
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        Reporter.log("get Model " + model.toString());
        CustomListeners.test.log(Status.PASS, "get Model " );
        return getTextFromElement(model);
    }

    public String getTotal() {
        Reporter.log("Get Total " + total.toString());
        CustomListeners.test.log(Status.PASS, "Get Total " );
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        Reporter.log("Change Quantity " + qtyField.toString());
        CustomListeners.test.log(Status.PASS, "Change Quantity " +qty);
        sendTextToElement(qtyField, qty);
    }

    public void clickOnQtyUpdateButton() {
        Reporter.log("click On Qty Update Button " + qtyUpdateBtn.toString());
        CustomListeners.test.log(Status.PASS, "click On Qty Update Button " );
        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
        Reporter.log("get Success Modified Message " + successModifiedMessage.toString());
        CustomListeners.test.log(Status.PASS, "get Success Modified Message  " );
        return getTextFromElement(successModifiedMessage);
    }
}
