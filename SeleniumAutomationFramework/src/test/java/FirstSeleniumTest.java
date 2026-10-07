import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstSeleniumTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");

		// Webelements Elements

		WebElement Username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@type=\"submit\"and @id=\"login-button\"]"));

		// Invalid login

		Username.sendKeys("standard_user10101");
		password.sendKeys("secret_saue");
		loginButton.click();

		WebElement Error = driver.findElement(By.xpath("//*[@data-test=\"error\"]"));
		String Text = Error.getText();
		System.out.println(Text);

		if (Text.equals("Epic sadface: Username and password do not match any user in this service")) {
			System.out.println("The error message is displaying as per requirement ");
		} else {
			System.out.println("Incorrect Eror message");
		}

		// Valid Login

		Username.clear();
		password.clear();
		Username.sendKeys("standard_user");

		password.clear();
		password.sendKeys("secret_sauce");
		loginButton.click();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String TargetURL = "https://www.saucedemo.com/inventory.html";

		if (currentUrl.equals(TargetURL)) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Failed");
		}

		// Find elements

		List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

		System.out.println("Number of products: " + prices.size());

		for (WebElement price : prices) {
			System.out.println(price.getText());
		}

		for (int i = 0; i < productNames.size(); i++) {
			System.out.println(productNames.get(i).getText() + " → " + prices.get(i).getText());
		}

		
		// Validating the Cartcount in PLP Page
		
		List<WebElement> cartBadges = driver.findElements(
				By.xpath("//span[@data-test=\"shopping-cart-badge\"]"));
		int initialCount = 0;
		if (cartBadges.size() > 0) {
			System.out.println("Cart badge exists");
			System.out.println("Current cart count: " + cartBadges.get(0).getText());
		} else {
			System.out.println("Cart badge does not exist - cart is empty");
		}

		

		if (cartBadges.size() > 0) {
			initialCount = Integer.parseInt(cartBadges.get(0).getText());
		}
		
			System.out.println("Initial cart count: " + initialCount);
		
		
		// Finding specific product and adding to cart
				WebElement product1=driver.findElement(By.xpath("//div[@class=\"inventory_item_description\"][.//div[text()=\"Sauce Labs Backpack\"]]//button[@id=\"add-to-cart-sauce-labs-backpack\"]"));
				product1.getText();
				product1.click();
				WebElement button=driver.findElement(By.xpath("//div[@class=\"inventory_item_description\"][.//div[text()=\"Sauce Labs Backpack\"]]//button[@class=\"btn btn_secondary btn_small btn_inventory \"]"));
				button.getText();

				List<WebElement> cartBadges1 = driver.findElements(
						By.xpath("//span[@data-test=\"shopping-cart-badge\"]"));
			int  Updatedcartcount=Integer.parseInt(cartBadges1.get(0).getText());
			System.out.println(Updatedcartcount);
			if(Updatedcartcount==initialCount+1) {
				System.out.println("The Cart value is getting updated properly");
			}
			initialCount=Updatedcartcount;
		//Adding One more product to the cart 
		WebElement product2=driver.findElement(By.xpath("//div[@class=\"inventory_item_description\"][.//div[text()=\"Sauce Labs Bike Light\"]] //button[@class=\"btn btn_primary btn_small btn_inventory \"]"));
		product2.getText();
		product2.click();
		WebElement button1=driver.findElement(By.xpath("//div[@class=\"inventory_item_description\"][.//div[text()=\"Sauce Labs Bike Light\"]] //button[@id=\"remove-sauce-labs-bike-light\"]"));
		button1.getText();

		List<WebElement> cartBadges2 = driver.findElements(
				By.xpath("//span[@data-test=\"shopping-cart-badge\"]"));
		int  Updatedcartcount1=Integer.parseInt(cartBadges2.get(0).getText());
		System.out.println(Updatedcartcount1);
		if(Updatedcartcount1==initialCount+1) {
			System.out.println("The Cart value is getting updated properly");
		}
		initialCount=Updatedcartcount1;
		//Removing product and checking COunt 
		button.click();

		List<WebElement> cartBadges3 = driver.findElements(
				By.xpath("//span[@data-test=\"shopping-cart-badge\"]"));
		int  Updatedcartcount2=Integer.parseInt(cartBadges3.get(0).getText());
		System.out.println(Updatedcartcount2);
		if(Updatedcartcount2==initialCount+1) {
			System.out.println("The Cart value is getting updated properly");
		}
		initialCount=Updatedcartcount2;
	}

}