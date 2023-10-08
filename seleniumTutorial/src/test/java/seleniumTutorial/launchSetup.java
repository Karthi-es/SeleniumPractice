package seleniumTutorial;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class launchSetup {
	public void launchSettup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		// added these options to remove all websocket listener errors.
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				DesiredCapabilities cp = new DesiredCapabilities();
				cp.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(cp);
		
	}

}
