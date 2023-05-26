import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\learning\\Selenium WebDriver course\\Webdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		Map<String, Object> coordinates = new HashMap<String, Object>();
		coordinates.put("latitude", 17);
		coordinates.put("longitude", 78);
		coordinates.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("http://google.com");

		By cookies_accept = By.id("L2AGLb");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();

		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		By cookies_accept1 = By.id("cookie-disclosure-accept");
		wait.until(ExpectedConditions.elementToBeClickable(cookies_accept1)).click();
		
		String title = driver.findElement(By.cssSelector(".default-ltr-cache-qsjwmk")).getText();
		System.out.println(title);

	}

}
