package com.baggiyam.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By signupLoginLink = By.xpath("//a[normalize-space()='Signup / Login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }
}