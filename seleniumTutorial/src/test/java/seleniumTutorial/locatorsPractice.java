package seleniumTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class locatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
// added these options to remove all websocket listener errors.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		WebDriver driver = new ChromeDriver();
//		added this 2 waits to escape from socketexception, but still happening sometimes
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("karthi@yopmail.com");
		driver.findElement(By.name("pass")).sendKeys("Pass@1234");
		driver.findElement(By.linkText("Forgotten password?")).click();
//		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		System.out.println("Landed in "+driver.getTitle());
		driver.close();
	}

}
