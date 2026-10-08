package com.baggiyam.automationexercise.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baggiyam.automationexercise.pages.HomePage;

public class HomePageTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");

        HomePage homePage = new HomePage(driver);

        // Click "Manage options"
        WebElement manageOptions = driver.findElement(
            By.xpath("//button[.//p[normalize-space()='Manage options']]")
        );

        manageOptions.click();

        System.out.println("Preferences dialog opened");

        // Find the preferences dialog
        WebElement preferenceDialog = driver.findElement(
            By.xpath("//div[@class='fc-dialog fc-data-preferences-dialog']")
        );

        // Find sliders inside the preferences dialog
        List<WebElement> sliders = preferenceDialog.findElements(
            By.className("fc-slider-el")
        );

        System.out.println("Sliders found: " + sliders.size());

        // Check every slider
        for (WebElement slider : sliders) {

            // Find the actual checkbox associated with the slider
            WebElement checkbox = slider.findElement(
                By.xpath("..//input")
            );

            // Get the current ON/OFF state
            String state = checkbox.getAttribute("aria-pressed");

            System.out.println(
                "Before: "
                + checkbox.getAttribute("aria-label")
                + " -> "
                + state
            );

            // If the slider is ON, turn it OFF
            if ("true".equals(state)) {

                // Scroll the slider into view
                ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        slider
                    );

                // Click the visible slider
                slider.click();

                System.out.println(
                    "Turned OFF: "
                    + checkbox.getAttribute("aria-label")
                );
            }
        }

        // Find Confirm Choices button(s)
        List<WebElement> confirmButtons = preferenceDialog.findElements(
            By.xpath(".//button[@aria-label='Confirm choices']")
        );

        System.out.println(
            "Confirm buttons found: " + confirmButtons.size()
        );

        // Click the visible and enabled Confirm Choices button
        for (WebElement button : confirmButtons) {

            if (button.isDisplayed() && button.isEnabled()) {

                button.click();

                System.out.println("Cookie preferences confirmed.");

                break;
            }
        }

        // Now click Signup / Login
        homePage.clickSignupLogin();

        // Close browser
        //driver.quit();
    }
}