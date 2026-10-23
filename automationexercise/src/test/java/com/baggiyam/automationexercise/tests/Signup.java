
package com.baggiyam.automationexercise.tests;

import com.baggiyam.automationexercise.pages.HomePage;

import com.baggiyam.automationexercise.pages.SignupPage;


public class Signup extends BaseTest {

    public static void main(String[] args) {

        Signup test = new Signup();

        test.setUp();

        HomePage homePage = new HomePage(test.driver);
        homePage.clickSignupLogin();
        SignupPage signupPage = new SignupPage(test.driver);
        String expectedUrl = signupPage.getExpectedUrl();
        String actualUrl = test.driver.getCurrentUrl();

        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("PASS: Correct page opened");
        } else {
            System.out.println("FAIL: Incorrect page opened");
        }

       

        String email = "siva" + System.currentTimeMillis()
                + "@example.com";

        signupPage.enterSignupName("Siva");
        signupPage.enterSignupEmail(email);
        System.out.println("Signup Email: " + email);
        
        signupPage.clickSignup();

        // Fill the account-information form
       

        signupPage.selectTitleMr();
        signupPage.enterPassword("Test@12345");
       
        signupPage.selectDay("10");
        signupPage.selectMonth("5");
        signupPage.selectYear("1990");

        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();

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

        // Submit registration details
        signupPage.clickCreateAccount();

        // Browser remains open for now
       //get the url
        String accountcreatedUrl = signupPage.getExpectedaccountcreatedUrl();
        String actualAccountCreatedUrl = test.driver.getCurrentUrl();

        System.out.println("Actual account-created URL: "
                + actualAccountCreatedUrl);

        System.out.println("Expected URL: " + accountcreatedUrl);
        System.out.println("Actual URL: " + actualAccountCreatedUrl);

        if (accountcreatedUrl.equals(actualAccountCreatedUrl)) {
            System.out.println("PASS: Correct page opened");
        } else {
            System.out.println("FAIL: Incorrect page opened");
        }
        	
        }
    }

