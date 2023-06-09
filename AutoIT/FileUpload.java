import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		String downloadPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver",
				"E:\\learning\\Selenium WebDriver course\\Webdriver\\chromedriver_win32\\chromedriver.exe");
		// setting the default download directory
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='file_browse']")).click();
		Thread.sleep(3000);

		// calling autoit exe script to upload the file
		Runtime.getRuntime().exec("C:\\Users\\AliaksandraSavelyeva\\Documents\\check\\fileupload.exe");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#submit_btn")));
		driver.findElement(By.cssSelector("#submit_btn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='btn btn-primary btn-sm']")));
		driver.findElement(By.cssSelector("a[class='btn btn-primary btn-sm']")).click();

		File f = new File(downloadPath + "/converted.zip");
		if (f.exists()) {
			System.out.println("File was successfully downloaded");
			f.delete();
		}

	}

}
