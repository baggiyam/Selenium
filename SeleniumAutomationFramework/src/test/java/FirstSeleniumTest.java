import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstSeleniumTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		
		//Webelements Elements
		WebElement Username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement loginButton=driver.findElement(By.xpath("//input[@type=\"submit\"and @id=\"login-button\"]"));
		
	
		//Inavlid login 
		Username.sendKeys("standard_user10101");
		password.sendKeys("secret_saue");
		loginButton.click();
		WebElement Error=driver.findElement(By.xpath("//*[@data-test=\"error\"]"));
		String Text =Error.getText();
		System.out.println(Text);
		if(Text.equals("Epic sadface: Username and password do not match any user in this service"))
				{
			System.out.println("The error message is displaying as per requirement ");
		}
		else {
			System.out.println("Incorrect Eror message");
		}
		
//Valid Login 
		Username.clear();
		password.clear();
		Username.sendKeys("standard_user");
		
		password.clear();
		password.sendKeys("secret_sauce");
	loginButton.click();
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	
	
		String TargetURL="https://www.saucedemo.com/inventory.html";
		if (currentUrl.equals(TargetURL)) {
			System.out.println("Login Successful");
		}
			else {
				System.out.println("Login Failed");
			}
		}
	
		
	

	

}
