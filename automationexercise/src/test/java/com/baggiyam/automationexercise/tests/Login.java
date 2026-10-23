package com.baggiyam.automationexercise.tests;

import com.baggiyam.automationexercise.pages.HomePage;
import com.baggiyam.automationexercise.pages.LoginPage;


public class Login extends BaseTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Login test=new Login();
test.setUp();

HomePage homePage = new HomePage(test.driver);
homePage.clickSignupLogin();
LoginPage login = new LoginPage(test.driver);
login.enterloginEmail("siva1792776222380@example.com");
login.enterloginPassword("Test@12345");
login.clickLogin();
System.out.println(login.getLoggedInUser());
login.loggout();

	}

}
