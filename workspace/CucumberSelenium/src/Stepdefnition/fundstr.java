package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ConfigReader;
import Utility.ConfigReaderft;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class fundstr {
	
	WebDriver driver;
	ConfigReaderft config1 = new ConfigReaderft();
	
	@Given("^User should be logged in Successfully And should be navigated to Funds transfer page$")
	public void User_should_be_logged_in_Successfully_And_should_be_navigated_to_Funds_transfer_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", config1.getChromepath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(config1.getapplicationurl1());
		driver.findElement(By.name(config1.getUsername())).clear();
		driver.findElement(By.name(config1.getUsername())).sendKeys("infy");
		driver.findElement(By.name(config1.getPassword())).sendKeys("infy@123");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_9")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("j_id_jsp_803499467_5:j_id_jsp_803499467_8")).click();
		Thread.sleep(2000);
		
	}

	@Given("^Target account should be present And there should be sufficient account balance$")
	public void Target_account_should_be_present_And_there_should_be_sufficient_account_balance() throws Throwable {
	   
	}

	@When("^user selects Target account And click on Funds Transfer$")
	public void user_selects_Target_account_And_click_on_Funds_Transfer() throws Throwable {
	    
	}

	@Then("^User account should be Debited And Target account should be Credited$")
	public void User_account_should_be_Debited_And_Target_account_should_be_Credited() throws Throwable {
	    
	}

	@Then("^Proper Successful message should be dispayed #Fund Transfer is Successful#$")
	public void Proper_Successful_message_should_be_dispayed_Fund_Transfer_is_Successful() throws Throwable {
	    
	}

	@When("^User enters Invalid account number that is not equal to (\\d+) digits$")
	public void User_enters_Invalid_account_number_that_is_not_equal_to_digits(int arg1) throws Throwable {
	    
	}

	@Then("^Proper error message should be displayed #Account Number is Invalid#$")
	public void Proper_error_message_should_be_displayed_Account_Number_is_Invalid() throws Throwable {
	    
	}

	@When("^User enters valid account number And Amount greater than Current account balance$")
	public void User_enters_valid_account_number_And_Amount_greater_than_Current_account_balance() throws Throwable {
	    
	}

	@Then("^Proper error message should be displayed #Insufficient account balance#$")
	public void Proper_error_message_should_be_displayed_Insufficient_account_balance() throws Throwable {
	    
	}

	@When("^User enters valid account number And Invalid amount$")
	public void User_enters_valid_account_number_And_Invalid_amount() throws Throwable {
	    
	}

	@Then("^Proper error message should be displayed #Invalid Amount - (\\d+).(\\d+), -(\\d+) #$")
	public void Proper_error_message_should_be_displayed_Invalid_Amount_(int arg1, int arg2, int arg3) throws Throwable {
	    
	}

	@When("^I click on the Back button$")
	public void I_click_on_the_Back_button() throws Throwable {
	    
	}

	@Then("^Back button should not work$")
	public void Back_button_should_not_work() throws Throwable {
	   
	}

	@When("^I click on the Logout button$")
	public void I_click_on_the_Logout_button() throws Throwable {
	    
	}

	@Then("^User should be logged out of the bank application successfully$")
	public void User_should_be_logged_out_of_the_bank_application_successfully() throws Throwable {
	    
	}
	
	@Given("^User navigates to Outside bank$")
    public void User_navigates_to_Outside_bank() throws Throwable {
		driver.findElement(By.name("j_id_jsp_714921657_5:j_id_jsp_714921657_11")).click();
		Thread.sleep(2000);
	}

	@Given("^Target account should be present And there should be sufficient account balance in From Account$")
	public void Target_account_should_be_present_And_there_should_be_sufficient_account_balance_in_From_Account() throws Throwable {
	    
	}

	@When("^user enters (\\d+), (\\d+) And BOB(\\d+) And click on Funds Transfer$")
	public void user_enters_And_BOB_And_click_on_Funds_Transfer(int arg1, int arg2, int arg3) throws Throwable {
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_12")).clear();
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_12")).sendKeys("123456");
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_14")).clear();
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_14")).sendKeys("100000");
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_16")).sendKeys("abcd");
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_18")).clear();
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_18")).sendKeys("10");
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_20")).sendKeys("BOB00345");
		driver.findElement(By.name("j_id_jsp_1077661064_5:j_id_jsp_1077661064_21")).submit();	
	    
	}

	@Then("^User (\\d+) should be Debited And (\\d+) should be Credited$")
	public void User_should_be_Debited_And_should_be_Credited(int arg1, int arg2) throws Throwable {
	    
	}

	@When("^user enters (\\d+), (\\d+) And SBI(\\d+) And click on Funds Transfer$")
	public void user_enters_And_SBI_And_click_on_Funds_Transfer(int arg1, int arg2, int arg3) throws Throwable {
	    
	}

	@When("^user enters (\\d+), (\\d+) And ICICI(\\d+) And click on Funds Transfer$")
	public void user_enters_And_ICICI_And_click_on_Funds_Transfer(int arg1, int arg2, int arg3) throws Throwable {
	    
	}

	

}
