import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\learning\\Selenium WebDriver course\\Webdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='file_browse']")).click();
		Thread.sleep(3000);

		// calling autoit exe script
		Runtime.getRuntime().exec("C:\\Users\\AliaksandraSavelyeva\\Documents\\check\\fileupload.exe");

	}

}
