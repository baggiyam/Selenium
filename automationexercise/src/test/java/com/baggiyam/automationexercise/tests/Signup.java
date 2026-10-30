
package com.baggiyam.automationexercise.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baggiyam.automationexercise.pages.HomePage;
import com.baggiyam.automationexercise.pages.SignupPage;

public class Signup extends BaseTest {

    public static void main(String[] args) {

        Signup test = new Signup();
        test.setUp();

        HomePage homePage = new HomePage(test.driver);
        homePage.clickSignupLogin();

        SignupPage signupPage = new SignupPage(test.driver);

        // Step 3: Verify the expected login page URL
        String expectedUrl = signupPage.getExpectedUrl();
        String actualUrl = test.driver.getCurrentUrl();

        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("PASS: Correct page opened");
        } else {
            System.out.println("FAIL: Incorrect page opened");
        }

        // Step 5: Verify New User Signup! is visible
        if (signupPage.isNewUserSignupVisible()) {
            System.out.println("PASS: New User Signup! is visible");
        } else {
            System.out.println("FAIL: New User Signup! is not visible");
        }

        // Step 6: Enter name and a unique email address
        String email = "siva" + System.currentTimeMillis()
                + "@example.com";

        signupPage.enterSignupName("Siva");
        signupPage.enterSignupEmail(email);

        System.out.println("Signup Email: " + email);

        // Step 7: Click Signup
        signupPage.clickSignup();

        // Step 8: Verify ENTER ACCOUNT INFORMATION is visible
        WebDriverWait wait = new WebDriverWait(
                test.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("signup"));

        if (signupPage.isAccountInformationVisible()) {
            System.out.println(
                    "PASS: ENTER ACCOUNT INFORMATION is visible");
        } else {
            System.out.println(
                    "FAIL: ENTER ACCOUNT INFORMATION is not visible");
        }

        // Step 9: Fill account information
        signupPage.selectTitleMr();
        signupPage.enterPassword("Test@12345");
        signupPage.selectDay("10");
        signupPage.selectMonth("5");
        signupPage.selectYear("1990");

        // Step 10: Select newsletter checkbox
        signupPage.selectNewsletter();

        // Step 11: Select special offers checkbox
        signupPage.selectSpecialOffers();

        // Step 12: Fill address and personal details
        signupPage.enterFirstName("Siva");
        signupPage.enterLastName("Kumar");
        signupPage.enterCompany("TestCompany");
        signupPage.enterAddress("10 Test Street");
        signupPage.enterAddress2("Apartment 2");
        signupPage.selectCountry("India");
        signupPage.enterState("Tamil Nadu");
        signupPage.enterCity("Chennai");
        signupPage.enterZipcode("600001");
        signupPage.enterMobileNumber("9876543210");

        // Step 13: Submit registration details
        signupPage.clickCreateAccount();

        // Step 14: Wait for account-created page
        wait.until(
                ExpectedConditions.urlContains("account_created"));

        System.out.println("PASS: Account-created page opened");

        // Verify account-created URL
        String expectedAccountCreatedUrl =
                signupPage.getExpectedaccountcreatedUrl();

        String actualAccountCreatedUrl =
                test.driver.getCurrentUrl();

        System.out.println(
                "Expected URL: " + expectedAccountCreatedUrl);
        System.out.println(
                "Actual URL: " + actualAccountCreatedUrl);

        if (expectedAccountCreatedUrl.equals(actualAccountCreatedUrl)) {
            System.out.println("PASS: Correct account-created URL");
        } else {
            System.out.println("FAIL: Incorrect account-created URL");
        }

        // Step 14: Verify the three confirmation messages in order
        if (signupPage.isAccountCreatedMessageDisplayedInOrder()) {
            System.out.println(
                    "PASS: Account-created messages appear in order");
        } else {
            System.out.println(
                    "FAIL: Account-created messages are missing or out of order");
        }

        // Step 15: Click Continue
        signupPage.clickContinue();

        // Step 16: Verify logged-in username
        if (signupPage.isLoggedInAsDisplayed()) {
            System.out.println(
                    "PASS: Logged-in username is displayed");
            System.out.println(
                    "Logged-in user: " + signupPage.getLoggedInUser());
        } else {
            System.out.println(
                    "FAIL: Logged-in username is not displayed");
        }

        // Step 17: Click Delete Account
        signupPage.clickDeleteAccount();

        // Step 18: Verify account-deleted confirmation
        if (signupPage.isAccountDeletedDisplayed()) {
            System.out.println(
                    "PASS: ACCOUNT DELETED! is displayed");

            // Step 18: Continue after account deletion
            signupPage.clickContinue();
        } else {
            System.out.println(
                    "FAIL: Account-deleted confirmation is missing");
        }

        // Close browser after the test
        //test.tearDown();
    }
}
