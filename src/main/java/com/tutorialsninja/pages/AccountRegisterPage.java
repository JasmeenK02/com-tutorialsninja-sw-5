package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement LastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

//    @CacheLookup
//    @FindBy(xpath = "//fieldset[3]//input")
//    WebElement subscribeRadios;

    By subscribeRadios = By.xpath("//fieldset[3]//input");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getRegisterAccountText() {

        CustomListeners.test.log(Status.PASS,"Get Register Account Text " );
        Reporter.log("Get Register Account Text " + registerAccountText.toString());
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {

        CustomListeners.test.log(Status.PASS,"Enter First name  " + fName);
        Reporter.log("Enter First name " + firstNameField.toString());
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {

        CustomListeners.test.log(Status.PASS,"Enter last name  " + lName);
        Reporter.log("Enter last name " + LastNameField.toString());
        sendTextToElement(LastNameField, lName);
    }

    public void enterEmail(String email) {

        CustomListeners.test.log(Status.PASS,"Enter Email  " + email);
        Reporter.log("Enter Email  " + emailField.toString());
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String telephone) {

        CustomListeners.test.log(Status.PASS,"Enter telephone  " + telephone);
        Reporter.log("Enter telephone  " + telephoneField.toString());
        sendTextToElement(telephoneField, telephone);
    }

    public void enterPassword(String password) {

        CustomListeners.test.log(Status.PASS,"Enter password  " + password);
        Reporter.log("Enter password  " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String cPassword) {

        CustomListeners.test.log(Status.PASS,"Enter Confirm password  " + cPassword);
        Reporter.log("Enter Confirm password  " + passwordField.toString());
        sendTextToElement(passwordConfirmField, cPassword);
    }

    public void selectSubscription(String option) {
        Reporter.log("select Subscription  " + subscribeRadios.toString());
        CustomListeners.test.log(Status.PASS,"select Subscription  " + option);
        List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {

        CustomListeners.test.log(Status.PASS,"click On Privacy Policy CheckBox " );
        Reporter.log("click On Privacy Policy CheckBox  " + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() {

        CustomListeners.test.log(Status.PASS,"click On Continue Button    " );
        Reporter.log("click On Continue Button  " + continueBtn.toString());
        clickOnElement(continueBtn);
    }
}
