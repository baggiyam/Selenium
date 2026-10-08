package com.baggiyam.automationexercise.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {

        // Start Chrome browser
        driver = new ChromeDriver();

        // Open Automation Exercise
        driver.get("https://automationexercise.com/");

        // Handle cookie/privacy preferences
        handleCookiePreferences();
    }

    private void handleCookiePreferences() {

        // Click "Manage options"
        WebElement manageOptions = driver.findElement(
                By.xpath("//button[.//p[normalize-space()='Manage options']]")
        );

        manageOptions.click();

        // Find the privacy preferences dialog
        WebElement preferenceDialog = driver.findElement(
                By.xpath("//div[@class='fc-dialog fc-data-preferences-dialog']")
        );

        // Find all preference sliders inside the dialog
        List<WebElement> sliders = preferenceDialog.findElements(
                By.className("fc-slider-el")
        );

        // Turn OFF every preference that is currently ON
        for (WebElement slider : sliders) {

            WebElement checkbox = slider.findElement(
                    By.xpath("..//input")
            );

            String state = checkbox.getAttribute("aria-pressed");

            if ("true".equals(state)) {

                // Scroll the visible slider into view
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        slider
                );

                // Click the visible slider
                slider.click();
            }
        }

        // Find the "Confirm choices" buttons
        List<WebElement> confirmButtons = preferenceDialog.findElements(
                By.xpath(".//button[@aria-label='Confirm choices']")
        );

        // Click the visible and enabled button
        for (WebElement button : confirmButtons) {

            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
                break;
            }
        }
    }

    public void tearDown() {

        // Close the browser
        driver.quit();
    }
}