package config;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSetup {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@Before
	public void beforeMethod() throws Throwable {

		driver = null;

		try {
    
			driver = OpenBrowser();
            driver.manage().window().maximize();
		} catch (NullPointerException e) {
			throw new FrameworkException("Exception occured as " + e.getMessage());

		}
	}

	@After
	public void afterMethod() throws InterruptedException {
		try {
			driver.quit();
		} catch (Exception e) {
			throw new FrameworkException("Exception occured as " + e.getMessage());
		}

	}

	public static WebDriver OpenBrowser() {
		WebDriver localDriver = null;

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "Drivers/" + "chromedriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		localDriver = new ChromeDriver(cap);

		return localDriver;
	}

	public static void closeBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();

		}

	}
}