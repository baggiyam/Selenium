package com.baggiyam.automationexercise.tests;

import com.baggiyam.automationexercise.pages.HomePage;
import com.baggiyam.automationexercise.pages.LoginPage;

public class LoginTest extends BaseTest {

    public static void main(String[] args) {

        LoginTest test = new LoginTest();

        test.setUp();

        HomePage homePage = new HomePage(test.driver);

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(test.driver);

        loginPage.enterSignupName("Siva");
        loginPage.enterSignupEmail("1234@gmail.com");
               
    
        loginPage.clickSignup();

        test.tearDown();
    }
}