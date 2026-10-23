package com.baggiyam.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

	private WebDriver driver;
//Login Functions
	private By loginEmailInput = By.cssSelector("input[data-qa='login-email']");

	private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");

	private By loginButton = By.cssSelector("button[data-qa='login-button']");

	public SignupPage(WebDriver driver) {
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
	//Title
	 private By titleMr = By.id("id_gender1");
	 private By titleMrs = By.id("id_gender2");
	   // Account information
	    private By passwordInput = By.id("password");
	    private By dayDropdown = By.id("days");
	    private By monthDropdown = By.id("months");
	    private By yearDropdown = By.id("years");

	    // Preferences
	    private By newsletterCheckbox = By.id("newsletter");
	    private By specialOffersCheckbox = By.id("optin");

	    // Address information
	    private By firstNameInput = By.id("first_name");
	    private By lastNameInput = By.id("last_name");
	    private By companyInput = By.id("company");
	    private By addressInput = By.id("address1");
	    private By address2Input = By.id("address2");
	    private By countryDropdown = By.id("country");
	    private By stateInput = By.id("state");
	    private By cityInput = By.id("city");
	    private By zipcodeInput = By.id("zipcode");
	    private By mobileNumberInput = By.id("mobile_number");

	    // Create account
	    private By createAccountButton =
	            By.cssSelector("button[data-qa='create-account']");
  
	
	public void enterSignupName(String name) {
	    driver.findElement(signupNameInput).sendKeys(name);
	}

	public void enterSignupEmail(String email) {
	    driver.findElement(signupEmailInput).sendKeys(email);
	}

	public void clickSignup() {
	    driver.findElement(signupButton).click();
	}
	private String expectedUrl = "https://automationexercise.com/login";

	public String getExpectedUrl() {
	    return expectedUrl;
	}

    public void selectTitleMr() {
        driver.findElement(titleMr).click();
    }

    public void selectTitleMrs() {
        driver.findElement(titleMrs).click();
    }
 // Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Select date of birth
    public void selectDay(String day) {
        new Select(driver.findElement(dayDropdown))
                .selectByValue(day);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(monthDropdown))
                .selectByValue(month);
    }

    public void selectYear(String year) {
        new Select(driver.findElement(yearDropdown))
                .selectByValue(year);
    }

    // Select a checkbox only if it is not already selected
    public void selectNewsletter() {
        if (!driver.findElement(newsletterCheckbox).isSelected()) {
            driver.findElement(newsletterCheckbox).click();
        }
    }

    public void selectSpecialOffers() {
        if (!driver.findElement(specialOffersCheckbox).isSelected()) {
            driver.findElement(specialOffersCheckbox).click();
        }
    }

    // Enter address details
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        driver.findElement(companyInput).sendKeys(company);
    }

    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void enterAddress2(String address) {
        driver.findElement(address2Input).sendKeys(address);
    }

    public void selectCountry(String country) {
        new Select(driver.findElement(countryDropdown))
                .selectByVisibleText(country);
    }

    public void enterState(String state) {
        driver.findElement(stateInput).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        driver.findElement(zipcodeInput).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }
private String accountcreatedUrl="https://automationexercise.com/account_created";

public String getExpectedaccountcreatedUrl() {
    return accountcreatedUrl;
}	
	}
