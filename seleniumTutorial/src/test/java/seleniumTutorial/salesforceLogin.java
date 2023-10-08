package seleniumTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforceLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		initiating the class for initial setups
		launchSetup launch = new launchSetup();
		launch.launchSettup();
		
		WebDriver driver = new ChromeDriver();
//		added this 2 waits to escape from socketexception, but still happening sometimes
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("username")).sendKeys("karthi@yopmail.com");
//		driver.findElement(By.cssSelector("#username")).sendKeys("jack@yopmail.com");
//		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("chakra@yopmail.com");
//		compound classes are not permitted. i.e., classes with spaces between them.
//		driver.findElement(By.className("input r4 wide mb16 mt8 password")).sendKeys("Pass@1234");
		driver.findElement(By.name("pw")).sendKeys("Pass@1234");
//		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		String error = driver.findElement(By.id("error")).getText();
		System.out.println("The error message captured is..\n"+error);
		
		driver.close();

	}

}
