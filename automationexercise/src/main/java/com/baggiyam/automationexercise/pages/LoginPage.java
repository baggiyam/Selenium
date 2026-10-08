package com.baggiyam.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
//Login Functions
	private By loginEmailInput = By.cssSelector("input[data-qa='login-email']");

	private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");

	private By loginButton = By.cssSelector("button[data-qa='login-button']");

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

	// SignupFunctions
	private By signupNameInput = By.cssSelector("input[data-qa='signup-name']");

	private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");

	private By signupButton = By.cssSelector("button[data-qa='signup-button']");
	
	public void enterSignupName(String name) {
	    driver.findElement(signupNameInput).sendKeys(name);
	}

	public void enterSignupEmail(String email) {
	    driver.findElement(signupEmailInput).sendKeys(email);
	}

	public void clickSignup() {
	    driver.findElement(signupButton).click();
	}
}