package com.baggiyam.automationexercise.tests;
import com.baggiyam.automationexercise.pages.HomePage;
public class HomePageTest extends BaseTest {

	public static void main(String[] args) {
	
		HomePageTest test = new HomePageTest();
		test.setUp();
		HomePage homePage = new HomePage(test.driver);
		homePage.clickSignupLogin();
	}

}
