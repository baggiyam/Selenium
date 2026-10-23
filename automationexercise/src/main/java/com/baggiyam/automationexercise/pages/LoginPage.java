package com.baggiyam.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

		
		private WebDriver driver;
		//Login Functions
			private By loginEmailInput = By.cssSelector("input[data-qa='login-email']");

			private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");

			private By loginButton = By.cssSelector("button[data-qa='login-button']");
			private By loggedInAs =
				    By.xpath("//a[contains(.,'Logged in as')]");
private By Loggout =By.xpath("//a[contains(.,'Logout')]");
			public LoginPage(WebDriver driver) {
				this.driver = driver;
			}

			public void enterloginEmail(String email) {
				driver.findElement(loginEmailInput).sendKeys(email);
			}

			public void enterloginPassword(String password) {
				driver.findElement(loginPasswordInput).sendKeys(password);
			}

			public void clickLogin() {
				driver.findElement(loginButton).click();
			}

			public String getLoggedInUser() {
			    String user = driver.findElement(loggedInAs).getText();
			    return user;
			}
			public void loggout() {
				driver.findElement(Loggout).click();
			}
}
	


