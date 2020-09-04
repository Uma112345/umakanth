package testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebBroswerTest {
	WebDriver driver;

	@Test
	public void Login() {
		driver.findElement(By.linkText("Log in")).click();
		//driver.findElement(By.id("Email")).sendKeys("milind123@gmail.com");
		//driver.findElement(By.id("Password")).sendKeys("password1$");
		driver.findElement(By.id("Email")).sendKeys("umakanth.n@in.ibm.com");
		driver.findElement(By.id("Password")).sendKeys("abcdef");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		String expectedText = "umakanth.n@in.ibm.com";
		String actualText = driver.findElement(By.linkText("umakanth.n@in.ibm.com")).getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test
	public void Logout() {
		driver.findElement(By.linkText("Log out")).click();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\UMAKANTHNARAYANDAS\\Desktop\\Selenium training\\Selenium webdriver training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
