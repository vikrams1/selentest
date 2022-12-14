package selenium;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GitHubLogin {
	

	// Open Browser - @BS
	// Open the URL - @BT
	// Click on Singin - @BC
	// Login - @Test
	// Logout - @AC
	// Quit - @AS

	public WebDriver driver;
	

	@BeforeSuite
	public void openBrowser() {

		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//driver = new ChromeDriver();
		
		
		//ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	}

	@BeforeTest
	public void openAut() {
		// Open URL
		//driver.get("https://github.com/");

	}

	@BeforeClass
	public void clickLoginButton() {
		// Click on Login Button to navigate to the login page
		//driver.findElement(By.xpath("//a[@href='/login']")).click();
	}

	@Test
	public void logIn() {
		

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
  
    	driver.get("https://github.com/");
    	
        
   		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
		String actual = driver.getTitle();
		String expected = "GitHub: Let’s build from here · GitHub";

		// Enter UserName
		//driver.findElement(By.xpath("//input[@id='login_field' and @name = 'login']"))
		//		.sendKeys("abhiseleniumdemo@gmail.com");

		// Enter password
		//driver.findElement(By.xpath("//input[@id='password' and @name = 'password']")).sendKeys("!Teach123");

		// Click on Signin
		//driver.findElement(By.xpath("//input[@data-signin-label='Sign in']")).click();
		
		
		assertTrue(actual.equals(expected), "Test case Failed");
		
		driver.quit();
		

	}

	@AfterClass
	public void logOut() throws Exception {
		// Click on Logout button menu to see the logout button
		//driver.findElement(By.xpath("//summary[@aria-label='View profile and more']")).click();

		Thread.sleep(3000);
		
		// Click on logOut
		//driver.findElement(By.xpath("//*[contains(text(), 'Sign out')]")).click();
	}

	@AfterSuite
	public void quitBrowser() {
		// Quit the browser
		//driver.quit();
	}

}
