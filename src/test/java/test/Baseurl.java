package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Baseurl {

	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
}
