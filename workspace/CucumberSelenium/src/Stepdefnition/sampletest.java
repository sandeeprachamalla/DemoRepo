package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class sampletest {
	WebDriver driver;
	@Given("^Open IE browser and start Flipkart application$")
	public void Open_IE_browser_and_start_Flipkart_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
	}

	@When("^I enter valid username and password$")
	public void I_enter_valid_username_and_password() throws Throwable {
		driver.findElement(By.id("Email")).sendKeys("sandeeprachamallu@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.cssSelector("input#Passwd")).sendKeys("Sivareddy@123");
		driver.findElement(By.id("signIn")).click();
	}

	@Then("^Login should be successfully done$")
	public void Login_should_be_successfully_done() throws Throwable {
		
		Thread.sleep(5000);
		driver.close();
		System.out.println("Login Successful");
	}


}
