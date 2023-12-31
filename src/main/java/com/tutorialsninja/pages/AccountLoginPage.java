package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getReturningCustomerText() {

        CustomListeners.test.log(Status.PASS,"Returning Customer Text ");
        Reporter.log("Returning Customer Text " + returningCustomerText.toString());
        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        CustomListeners.test.log(Status.PASS,"New Customer Text ");
        Reporter.log("New Customer Text " + newCustomerText.toString());
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {

        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
        Reporter.log("Enter EmailId " + emailAddressField.toString());
        sendTextToElement(emailAddressField, email);
    }

    public void enterPassword(String password) {

        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
        Reporter.log("Enter Password " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {

        CustomListeners.test.log(Status.PASS,"Click on login Button " );
        Reporter.log("Click on login Button " + loginBtn.toString());
        clickOnElement(loginBtn);
    }

}
