package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    //    @CacheLookup
//    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
//    WebElement topMenu;
    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    By myAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");


    public void selectMenu(String menu) throws InterruptedException {

        List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenu);
        }

        Thread.sleep(1000);
        CustomListeners.test.log(Status.PASS, "select Menu " + menu);
        Reporter.log("select Menu  " + topMenu.toString());

    }

    public void mouseHoverOnDesktopsLinkAndClick() {

        CustomListeners.test.log(Status.PASS, "MouseHover On DesktopsLink And Click ");
        Reporter.log("MouseHover On DesktopsLink And Click  " + desktopLink.toString());
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("MouseHover On Laptop  And Click  " + laptopsAndNotebooksLink.toString());
        CustomListeners.test.log(Status.PASS, "MouseHover On Laptop And Click ");
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public void mouseHoverOnComponentLinkAndClick() throws InterruptedException {
        Reporter.log("MouseHover On Component  And Click  " + componentsLinks.toString());
        CustomListeners.test.log(Status.PASS, "MouseHover On Component And Click ");
        Thread.sleep(1000);
        mouseHoverToElementAndClick(componentsLinks);
    }

    public void selectCurrency(String currency) throws InterruptedException {
        Reporter.log("Select Currency  " + currencyTab.toString());
        CustomListeners.test.log(Status.PASS, "Select Currency " + currency);
        clickOnElement(currencyTab);
        Thread.sleep(1000);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyQAccountTab() throws InterruptedException {
        Reporter.log("click On My QAccount Tab  " + myAccountTab.toString());
        CustomListeners.test.log(Status.PASS, "click On My QAccount Tab ");
        Thread.sleep(1000);
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {

        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }

    }
}
