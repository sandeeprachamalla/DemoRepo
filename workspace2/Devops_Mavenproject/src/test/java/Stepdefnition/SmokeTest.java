package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	WebDriver driver;
	@Given("^Open Google chrome and start application$")
	public void Open_Google_chrome_and_start_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	   
	}

	@When("^I enter valid username and valid password$")
	public void I_enter_invalid_username_and_invalid_password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("8008127581");
		driver.findElement(By.id("pass")).sendKeys("bujji@123");
	    
	}

	@Then("^Login should be successful$")
	public void Login_should_be_unsuccessful() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(5000);
		driver.close();
		System.out.println("Login Successful");
	}

	@When("^I enter invalid username and valid password$")
	public void I_enter_invalid_username_and_valid_password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("xyz");
		driver.findElement(By.id("pass")).sendKeys("bujji@123");
	}

	@Then("^Invalid username should be displayed$")
	public void Invalid_username_should_be_displayed() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(5000);
		driver.close();
		System.out.println("Login failed due to invalid username");
	}

	@When("^I enter valid username and invalid password$")
	public void I_enter_valid_username_and_invalid_password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("8008127581");
		driver.findElement(By.id("pass")).sendKeys("12345");
	}

	@Then("^Invalid password should be displayed$")
	public void Invalid_password_should_be_displayed() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(5000);
		driver.close();
		System.out.println("Login failed due to invalid password");
	}


}
