import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstSeleniumTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		//invalid login
		driver.findElement(By.xpath("//input[starts-with(@data-test, \"user\")]")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_saue");
		driver.findElement(By.id("login-button")).click();
		String Text =driver.findElement(By.xpath("//*[@data-test=\"error\"]")).getText();
		System.out.println(Text);
		
		if(Text.equals("Epic sadface: Username and password do not match any user in this service"))
				{
			System.out.println("The error message is displaying as per requirement ");
		}
		else {
			System.out.println("Incorrect Eror message");
		}
		driver.quit();
	}

	

}
