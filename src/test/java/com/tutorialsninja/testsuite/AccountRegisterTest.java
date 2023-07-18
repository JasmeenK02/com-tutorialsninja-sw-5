package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class AccountRegisterTest extends BaseTest {

    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;
    SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        accountPage = new MyAccountPage();
        accountRegisterPage = new AccountRegisterPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Register");
        softAssert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Register");
        accountRegisterPage.enterFirstName("Jasmeen" );
        accountRegisterPage.enterLastName("Kaur" );
        accountRegisterPage.enterEmail("jasmeen144@gmail.com");
        accountRegisterPage.enterTelephone("1234567891");
        accountRegisterPage.enterPassword("jask1234");
        accountRegisterPage.enterConfirmPassword("jask1234");
        accountRegisterPage.selectSubscription("Yes");
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        accountRegisterPage.clickOnContinueButton();
        softAssert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");
        accountPage.clickOnContinueButton();
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Logout");
        softAssert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        accountPage.clickOnContinueButton();
        softAssert.assertAll();
    }



}
