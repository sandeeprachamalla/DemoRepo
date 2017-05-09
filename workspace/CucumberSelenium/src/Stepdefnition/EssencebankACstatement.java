package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EssencebankACstatement {
	WebDriver driver;
	@Given("^Open Google chrome and start Essence bank application$")
	public void Open_Google_chrome_and_start_Essence_bank_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.67.89.43:84/Common/Login.aspx");
	}

	@Given("^user logged in successfully$")
	public void user_logged_in_successfully() throws Throwable {
		driver.findElement(By.id("ctl00_body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("ctl00_body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("ctl00_body_btnLogin")).click();
		Thread.sleep(3000);
		System.out.println("Login Successful");
	}

	@When("^I click on Account Statement$")
	public void I_click_on_Account_Statement() throws Throwable {
	    driver.findElement(By.linkText("View Transactions")).click();
	}

	@Then("^Account Statement details should be displayed successfully$")
	public void Account_Statement_details_should_be_displayed_successfully() throws Throwable {
		WebElement e2 = driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlAccountNo"));
		Select select1 = new Select(e2);
		select1.selectByVisibleText("100000000001");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_rblTransactions_1")).click();
		Thread.sleep(3000);
		WebElement e3 = driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlTransactionType"));
		Select select2 = new Select(e3);
		select2.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtFromDate")).sendKeys("4/1/2017");
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtToDate")).sendKeys("4/12/2017");
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_lblToDate")).click();
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_btnViewTrancastions")).click();
		Thread.sleep(3000);
		System.out.println("Account Statement Dispplayed Successfully");
		driver.close();
	}



}
