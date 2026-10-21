package com.baggiyam.automationexercise.tests;

import com.baggiyam.automationexercise.pages.HomePage;
import com.baggiyam.automationexercise.pages.LoginPage;

public class Signup extends BaseTest {

    public static void main(String[] args) {

    	Signup test = new Signup();

        test.setUp();

        HomePage homePage = new HomePage(test.driver);

        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(test.driver);

        loginPage.enterSignupName("Siva");
        loginPage.enterSignupEmail("8542@gmail.com");
               
    
        loginPage.clickSignup();
        
        
      
        
        
    }
}