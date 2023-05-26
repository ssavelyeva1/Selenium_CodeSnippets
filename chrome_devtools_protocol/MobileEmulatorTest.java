import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver",
				"E:\\learning\\Selenium WebDriver course\\Webdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		// sending commands to CDP (Chrome Devtools Protocol)
		// CDP will invoke and get access to devtools
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		
		//Network.getRequestPostData(null)
	}

}
