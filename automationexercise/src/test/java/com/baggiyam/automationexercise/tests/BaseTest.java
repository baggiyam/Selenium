package com.baggiyam.automationexercise.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {

        // Start Chrome browser
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments(
    		    "--host-resolver-rules=MAP pagead2.googlesyndication.com 0.0.0.0"
    		);
    	 // Disable Chrome password and address-saving prompts
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);

        options.setExperimentalOption("prefs", prefs);
//https://pagead2.googlesyndication.com
    	options.addArguments("--disable-extensions");
    	options.addArguments("--disable-notifications");

    	driver = new ChromeDriver(options);

        // Open Automation Exercise
        driver.get("https://automationexercise.com/");

        // Handle cookie/privacy preferences
       // handleCookiePreferences();
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