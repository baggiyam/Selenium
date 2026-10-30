
package com.baggiyam.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private WebDriver driver;

    // Constructor: receive the WebDriver from the test class
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // =========================================================
    // TEST CASE 1: REGISTER USER
    // =========================================================

    // Step 5: Verify "New User Signup!" is visible
    private By newUserSignupHeading =
            By.xpath("//h2[normalize-space()='New User Signup!']");

    // Step 6: Enter name and email address
    private By signupNameInput =
            By.cssSelector("input[data-qa='signup-name']");

    private By signupEmailInput =
            By.cssSelector("input[data-qa='signup-email']");

    // Step 7: Click Signup button
    private By signupButton =
            By.cssSelector("button[data-qa='signup-button']");

    // Step 8: Verify "ENTER ACCOUNT INFORMATION" is visible
    private By accountInformationHeading =
            By.xpath("//*[normalize-space()='ENTER ACCOUNT INFORMATION' or normalize-space()='Enter Account Information']");

    // Step 9: Select title
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");

    // Step 9: Enter password and date of birth
    private By passwordInput = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");

    // Step 10: Select "Sign up for our newsletter!"
    private By newsletterCheckbox = By.id("newsletter");

    // Step 11: Select "Receive special offers from our partners!"
    private By specialOffersCheckbox = By.id("optin");

    // Step 12: Enter address and personal details
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

    // Step 13: Click "Create Account"
    private By createAccountButton =
            By.cssSelector("button[data-qa='create-account']");

    // Step 14: Verify "ACCOUNT CREATED!" is visible
    private By accountCreatedHeading =
    	    By.xpath("//h2[contains(normalize-space(.), 'Account Created!')]");

    // Step 14: Verify the two account-created confirmation messages
    private By accountCreatedMessage1 =
            By.xpath("//*[normalize-space()='Congratulations! Your new account has been successfully created!']");

    private By accountCreatedMessage2 =
            By.xpath("//*[normalize-space()='You can now take advantage of member privileges to enhance your online shopping experience with us.']");

    // Step 15: Click "Continue"
    private By continueButton =
            By.xpath("//a[normalize-space()='Continue']");

    // Step 16: Verify "Logged in as username"
    private By loggedInAs =
            By.xpath("//a[contains(normalize-space(.),'Logged in as')]");

    // Step 17: Click "Delete Account"
    private By deleteAccountButton =
            By.xpath("//a[normalize-space()='Delete Account']");

    // Step 18: Verify "ACCOUNT DELETED!" is visible
    private By accountDeletedHeading =
            By.xpath("//h2[normalize-space()='Account Deleted!']");

   

    // =========================================================
    // LOGIN FUNCTIONS 
    // =========================================================

    // Login: enter email
    private By loginEmailInput =
            By.cssSelector("input[data-qa='login-email']");

    // Login: enter password
    private By loginPasswordInput =
            By.cssSelector("input[data-qa='login-password']");

    // Login: click Login button
    private By loginButton =
            By.cssSelector("button[data-qa='login-button']");

    public void enterloginEmail(String email) {
        driver.findElement(loginEmailInput).sendKeys(email);
    }

    public void enterloginPassword(String password) {
        driver.findElement(loginPasswordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // =========================================================
    // SIGNUP METHODS 
    // =========================================================

    public boolean isNewUserSignupVisible() {
        return driver.findElement(newUserSignupHeading).isDisplayed();
    }

    public void enterSignupName(String name) {
        driver.findElement(signupNameInput).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(signupEmailInput).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    // Expected URL after opening Signup / Login
    private String expectedUrl =
            "https://automationexercise.com/login";

    public String getExpectedUrl() {
        return expectedUrl;
    }

    // Step 8: Verify account information heading
    public boolean isAccountInformationVisible() {
        return driver.findElement(accountInformationHeading).isDisplayed();
    }

    // Step 9: Select title
    public void selectTitleMr() {
        driver.findElement(titleMr).click();
    }

    public void selectTitleMrs() {
        driver.findElement(titleMrs).click();
    }

    // Step 9: Enter password
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Step 9: Select date of birth
    public void selectDay(String day) {
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
    }

    public void selectYear(String year) {
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
    }

    // Step 10: Select newsletter checkbox if not already selected
    public void selectNewsletter() {
        if (!driver.findElement(newsletterCheckbox).isSelected()) {
            driver.findElement(newsletterCheckbox).click();
        }
    }

    // Step 11: Select special offers checkbox if not already selected
    public void selectSpecialOffers() {
        if (!driver.findElement(specialOffersCheckbox).isSelected()) {
            driver.findElement(specialOffersCheckbox).click();
        }
    }

    // Step 12: Enter address and personal details
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

    // Step 13: Submit registration
    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    // Expected URL after account creation
    private String accountcreatedUrl =
            "https://automationexercise.com/account_created";

    public String getExpectedaccountcreatedUrl() {
        return accountcreatedUrl;
    }

    // =========================================================
    // ACCOUNT CREATED PAGE METHODS
    // =========================================================

    // Step 14: Wait for account-created heading
    public boolean isAccountCreatedHeadingDisplayed() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedHeading
                )
        ).isDisplayed();
    }

    // Step 14: Validate all three messages appear in vertical order
    public boolean isAccountCreatedMessageDisplayedInOrder() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedHeading
                )
        );

        WebElement message1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedMessage1
                )
        );

        WebElement message2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedMessage2
                )
        );

        return heading.getLocation().getY()
                        < message1.getLocation().getY()
                && message1.getLocation().getY()
                        < message2.getLocation().getY();
    }

    // Step 15: Click Continue after account creation
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    // Step 16: Verify the logged-in username is displayed
    public boolean isLoggedInAsDisplayed() {
        return driver.findElement(loggedInAs).isDisplayed();
    }

    public String getLoggedInUser() {
        return driver.findElement(loggedInAs).getText();
    }

    // Step 17: Delete the account
    public void clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }

    // Step 18: Verify account-deleted confirmation
    public boolean isAccountDeletedDisplayed() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        accountDeletedHeading
                )
        ).isDisplayed();
    }

    
}
