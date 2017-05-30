package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Essencebanklogin {
	WebDriver driver;
	@Given("^Open Google chrome and start bank application$")
	public void Open_Google_chrome_and_start_bank_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.67.89.43:84/Common/Login.aspx");
	}

	@When("^I enter credentials$")
	public void I_enter_credentials() throws Throwable {
		driver.findElement(By.id("ctl00_body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("ctl00_body_txtPassword")).sendKeys("don@123");
	}

	@Then("^Login should be successfull$")
	public void Login_should_be_successfull() throws Throwable {
		driver.findElement(By.id("ctl00_body_btnLogin")).click();
		Thread.sleep(5000);
		System.out.println("Login Successful");
	}

	@Then("^Then Logout should be Successfull$")
	public void Then_Logout_should_be_Successfull() throws Throwable {
		String e1 = driver.findElement(By.id("ctl00_ctl00_divWelcome")).getText();
		System.out.println(e1);
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(5000);
		System.out.println("Logout Successful");
		driver.close();
	}

	@When("^I enter invalid username and valid pwd$")
	public void I_enter_invalid_username_and_valid_pwd() throws Throwable {
		driver.findElement(By.id("ctl00_body_txtUserID")).sendKeys("abcdef");
		driver.findElement(By.id("ctl00_body_txtPassword")).sendKeys("don@123");
	}

	@Then("^Login should fail and Invalid username should be displayed$")
	public void Login_should_fail_and_Invalid_username_should_be_displayed() throws Throwable {
		driver.findElement(By.id("ctl00_body_btnLogin")).click();
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Login failed due to invalid username");
	}


}
