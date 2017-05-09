package Stepdefnition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EssencebankFT {
	WebDriver driver;
	@Given("^Open Google chrome browser and start Essence bank application$")
	public void Open_Google_chrome_browser_and_start_Essence_bank_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.67.89.43:84/Common/Login.aspx");
	}

	@Given("^user is logged in successfully$")
	public void user_is_logged_in_successfully() throws Throwable {
		driver.findElement(By.id("ctl00_body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("ctl00_body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("ctl00_body_btnLogin")).click();
		Thread.sleep(3000);
		System.out.println("Login Successful");
	}

	@When("^I click on Transfer Funds$")
	public void I_click_on_Transfer_Funds() throws Throwable {
		driver.findElement(By.linkText("Transfer Money")).click();
		Thread.sleep(3000);
	}

	@When("^Select from and to accounts and enter amount details and click on submit$")
	public void Select_from_and_to_accounts_and_enter_amount_details_and_click_on_submit() throws Throwable {
	   WebElement e1 = driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_ddlFromAccount"));
	   Select x = new Select(e1);
	   x.selectByValue("100000000001");
	   
	   WebElement e2 = driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_ddlToAccount"));
	   Select x1 = new Select(e2);
	   x1.selectByValue("9999");
	   driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtTransactionAmount")).sendKeys("100");
	   driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtTransactionRemarks")).sendKeys("100tr3");
	   driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_btnNext")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_txtTransactionPassword")).sendKeys("don@123");
	   driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_btnTransfer")).click();
	   Alert alert = driver.switchTo().alert();
	   alert.accept();
	   System.out.println("Funds Transfer Successfull");
	}

	@Then("^Funds transfer details should be displayed successfully$")
	public void Funds_transfer_details_should_be_displayed_successfully() throws Throwable {
		driver.findElement(By.linkText("View Transactions")).click();
		WebElement e3 = driver.findElement(By.name("ctl00$ctl00$body$cph_MyAccount$ddlAccountNo"));
		Select select1 = new Select(e3);
		select1.selectByVisibleText("100000000001");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_rblTransactions_0")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ctl00_body_cph_MyAccount_btnViewTrancastions")).click();
		Thread.sleep(3000);
		driver.quit();
	}



}
