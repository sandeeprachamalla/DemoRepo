package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.ConfigReader;
import Utility.ConfigReaderft;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class fundstr {
	
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	float current_bal;
	
	@Given("^User should be logged in successfully And should be navigated to Funds transfer page$")
	public void User_should_be_logged_in_Successfully_And_should_be_navigated_to_Funds_transfer_page() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver", config.getChromepath());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(config.getapplicationurl1());
			driver.findElement(By.name(config.getUsername())).clear();
			driver.findElement(By.name(config.getUsername())).sendKeys(config.enteruname());
			driver.findElement(By.name(config.getPassword())).sendKeys(config.enterpwd());
			driver.findElement(By.xpath(config.SubmitXpath())).click();
			Thread.sleep(2000);
			driver.findElement(By.id(config.Home())).click();
			Thread.sleep(3000);
			String current_balance=driver.findElement(By.id(config.getbalance())).getText();
			current_bal =  Float.parseFloat(current_balance);;
			System.out.println("Current Balance is "+current_bal);		  
			driver.findElement(By.name(config.Fundtransfer())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Given("^Target account should be present And there should be sufficient account balance$")
	public void Target_account_should_be_present_And_there_should_be_sufficient_account_balance() throws Throwable {
		try {
			driver.findElement(By.id(config.getwithinbank())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("^user selects Target account And click on Funds Transfer$")
	public void user_selects_Target_account_And_click_on_Funds_Transfer() throws Throwable {
		try {
			Thread.sleep(3000);
            WebElement target_drop=driver.findElement(By.id(config.withintoacc()));
            Select account=new Select(target_drop);
            account.selectByIndex(0);
            driver.findElement(By.id(config.accholder())).sendKeys("somya jain");
            driver.findElement(By.id(config.transferamt())).clear();
            float f2 = Float.valueOf("10.0");
            driver.findElement(By.id(config.transferamt())).sendKeys(Float.toString(f2));
            driver.findElement(By.id(config.transactionremark())).sendKeys("Bus fare");
            driver.findElement(By.id(config.ftransfer())).click();
		    } catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^User account should be Debited And Target account should be Credited$")
	public void User_account_should_be_Debited_And_Target_account_should_be_Credited() throws Throwable {
	    
	}

	@Then("^Proper Successful message should be dispayed #Fund Transfer within bank is Successful#$")
	public void Proper_Successful_message_should_be_dispayed_Fund_Transfer_within_bank_is_Successful() throws Throwable {
		   try {
			String msg=driver.findElement(By.id(config.FundMessage())).getText();
			   System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("^Proper Successful message should be dispayed #Fund Transfer outside bank is Successful#$")
	public void Proper_Successful_message_should_be_dispayed_Fund_Transfer_outside_bank_is_Successful() throws Throwable {
		try {
			Thread.sleep(5000);
			WebElement msg1 = driver.findElement(By.id(config.Outtransfermsg()));
			System.out.println(msg1.getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("^User enters same From account and To account number$")
	public void User_enters_same_From_account_and_To_account_number() throws Throwable {
		try {
			Thread.sleep(3000);
			driver.findElement(By.id(config.getwithinbank())).click();
		   WebElement target_drop=driver.findElement(By.id(config.withintoacc()));
		   Thread.sleep(3000);
		   Select account=new Select(target_drop);
		   account.selectByIndex(1);
		   driver.findElement(By.id(config.accholder())).sendKeys("somya jain");
		   driver.findElement(By.id(config.transferamt())).clear();
		   //float f2 = Float.valueOf("10.0");
		   driver.findElement(By.id(config.transferamt())).sendKeys("20");
		   driver.findElement(By.id(config.transactionremark())).sendKeys("E-bill");
		   driver.findElement(By.id(config.ftransfer())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@When("^User enters Invalid account number that is not equal to (\\d+) digits and clicks on Transfer Funds button$")
	public void User_enters_Invalid_account_number_that_is_not_equal_to_digits_and_clicks_on_Transfer_Funds_button(int arg1) throws Throwable {
		try {
			driver.findElement(By.name(config.OutToAccount())).clear();
			driver.findElement(By.name(config.OutToAccount())).sendKeys("1234");
			driver.findElement(By.name(config.OutACholdername())).clear();
			driver.findElement(By.name(config.OutACholdername())).sendKeys("abcd");
			driver.findElement(By.name(config.Outtransferamt())).clear();
			driver.findElement(By.name(config.Outtransferamt())).sendKeys("1");
			driver.findElement(By.name(config.Outremarks())).clear();
			driver.findElement(By.name(config.Outremarks())).sendKeys("transfer1");
			driver.findElement(By.name(config.OutIFSC())).clear();
			driver.findElement(By.name(config.OutIFSC())).sendKeys("BOB12345678");
			driver.findElement(By.name(config.Outtransferfundbutton())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("^Proper error message should be displayed #From Account and To Account can not be same#$")
	public void proper_error_message_should_be_displayed_From_Account_and_To_Account_can_not_be_same() throws Throwable {
		try {
			String insufficient_blc=driver.findElement(By.id(config.FundMessage())).getText();
			System.out.println(insufficient_blc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
	
	@Then("^Proper error message should be displayed #Insufficient account balance for within bank#$")
	public void Proper_error_message_should_be_displayed_Insufficient_account_balance_for_within_bank() throws Throwable {
		try {
			String insufficient_blc=driver.findElement(By.id(config.FundMessage())).getText();
			System.out.println(insufficient_blc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^Proper error message should be displayed #Account Number is Invalid for outside bank#$")
	public void Proper_error_message_should_be_displayed_Account_Number_is_Invalid_for_outside_bank() throws Throwable {
		try {
			Thread.sleep(5000);
			WebElement msg1 = driver.findElement(By.id(config.Outtransfermsg()));
			System.out.println(msg1.getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("^Proper error message should be displayed #Insufficient account balance for outside bank#$")
	public void Proper_error_message_should_be_displayed_Insufficient_account_balance_for_outside_bank() throws Throwable {
		try {
			Proper_error_message_should_be_displayed_Account_Number_is_Invalid_for_outside_bank();	 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("^User enters valid account number And Amount greater than Current account balance for within bank$")
	public void User_enters_valid_account_number_And_Amount_greater_than_Current_account_balance_for_within_bank() throws Throwable {
		try {
			Thread.sleep(3000);
				driver.findElement(By.id(config.getwithinbank())).click();
			   WebElement target_drop=driver.findElement(By.id(config.withintoacc()));
			   Select account=new Select(target_drop);
			   account.selectByIndex(0);
			   driver.findElement(By.id(config.accholder())).sendKeys("somya jain");
			   driver.findElement(By.id(config.transferamt())).clear();
			   float add=10f;
			   float f2 = Float.valueOf(current_bal+add);
			   System.out.println("Value after addtion is " +f2);
			if (f2>current_bal){
				driver.findElement(By.id(config.transferamt())).sendKeys(Float.toString(f2));
				Thread.sleep(3000);
			}
			else{
				System.out.println("Entered amount is less than the Current Balance");
			}
				driver.findElement(By.id(config.transactionremark())).sendKeys("Bus fare");
				driver.findElement(By.id(config.ftransfer())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 			
	}

	@When("^User enters valid account number And Amount greater than Current account balance for outside bank$")
	public void User_enters_valid_account_number_And_Amount_greater_than_Current_account_balance_for_outside_bank() throws Throwable {
		try {
			driver.findElement(By.name(config.OutToAccount())).clear();
			driver.findElement(By.name(config.OutToAccount())).sendKeys("12345678");
			driver.findElement(By.name(config.OutACholdername())).clear();
			driver.findElement(By.name(config.OutACholdername())).sendKeys("abcd");
			driver.findElement(By.name(config.Outtransferamt())).clear();
			float add1=10f;
			   float f3 = Float.valueOf(current_bal+add1);
			   System.out.println("Value after addtion is "+f3);
			if (f3>current_bal){
				driver.findElement(By.id(config.Outtransferamt())).sendKeys(Float.toString(f3));
			}
			else{
				System.out.println("Entered amount is less than the Current Balance");
			}
			//driver.findElement(By.name(config.Outtransferamt())).sendKeys("10000");
			driver.findElement(By.name(config.Outremarks())).clear();
			driver.findElement(By.name(config.Outremarks())).sendKeys("excesstransfer");
			driver.findElement(By.name(config.OutIFSC())).clear();
			driver.findElement(By.name(config.OutIFSC())).sendKeys("BOB12345678");
			driver.findElement(By.name(config.Outtransferfundbutton())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("^User enters valid account number And Invalid amount in within bank$")
	public void User_enters_valid_account_number_And_Invalid_amount_in_within_bank() throws Throwable {
		try {
			Thread.sleep(3000);
			Target_account_should_be_present_And_there_should_be_sufficient_account_balance();
			   WebElement target_drop=driver.findElement(By.id(config.withintoacc()));
			   Select account=new Select(target_drop);
			   account.selectByIndex(0);
			   driver.findElement(By.id(config.accholder())).sendKeys("somya jain");
			   driver.findElement(By.id(config.transferamt())).clear();
			   driver.findElement(By.id(config.transferamt())).sendKeys("-15");
			   driver.findElement(By.id(config.transactionremark())).sendKeys("Bus fare");
			   driver.findElement(By.id(config.ftransfer())).click();
			   Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		   			
	}

	@When("^User enters valid account number And Invalid amount in outside bank$")
	public void User_enters_valid_account_number_And_Invalid_amount_in_outside_bank() throws Throwable {
		try {
			driver.findElement(By.name(config.OutToAccount())).clear();
			driver.findElement(By.name(config.OutToAccount())).sendKeys("12345678");
			driver.findElement(By.name(config.OutACholdername())).clear();
			driver.findElement(By.name(config.OutACholdername())).sendKeys("abcd");
			driver.findElement(By.name(config.Outtransferamt())).clear();
			driver.findElement(By.name(config.Outtransferamt())).sendKeys("0");
			driver.findElement(By.name(config.Outremarks())).clear();
			driver.findElement(By.name(config.Outremarks())).sendKeys("invalid amount transfer");
			driver.findElement(By.name(config.OutIFSC())).clear();
			driver.findElement(By.name(config.OutIFSC())).sendKeys("BOB12345678");
			driver.findElement(By.name(config.Outtransferfundbutton())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("^Proper error message should be displayed #Invalid Amount for within bank - (\\d+).(\\d+), -(\\d+) #$")
	public void Proper_error_message_should_be_displayed_Invalid_Amount_for_within_bank(int arg1, int arg2, int arg3) throws Throwable {
		try {
			String invalid_amt=driver.findElement(By.id(config.FundMessage())).getText();
			System.out.println(invalid_amt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	@Then("^Proper error message should be displayed #Invalid Amount for outside bank - (\\d+).(\\d+), -(\\d+) #$")
	public void Proper_error_message_should_be_displayed_Invalid_Amount_for_outside_bank(int arg1, int arg2, int arg3) throws Throwable {
		try {
			Proper_error_message_should_be_displayed_Account_Number_is_Invalid_for_outside_bank();	 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("^I click on the back button$")
	public void I_click_on_the_back_button() throws Throwable {
		try {
			String page_before=driver.getTitle();
			 driver.navigate().back();
			 String page_after=driver.getTitle();
			 if (page_before.equals(page_after)) {
				System.out.println("Test Successful");
			} else {
				System.out.println("Test UnSuccessful");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^Back button should not work$")
	public void Back_button_should_not_work() throws Throwable {
	   
	}

	@When("^I click on the logout button$")
	public void I_click_on_the_logout_button() throws Throwable {
		try {
			driver.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^User should be logged out of the bank application successfully$")
	public void User_should_be_logged_out_of_the_bank_application_successfully() throws Throwable {
		 try {
				String login_title=driver.getTitle();
				if (login_title.equals("Infosys Devops Bank:Login")) {
					System.out.println("User logged out Successfully");
				} else {
					System.out.println("User logout is UnSuccessfull");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	@Given("^User navigates to Outside bank$")
    public void User_navigates_to_Outside_bank() throws Throwable {
		try {
			driver.findElement(By.name(config.Outsidebank())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Given("^Target account should be present And there should be sufficient account balance in From Account$")
	public void Target_account_should_be_present_And_there_should_be_sufficient_account_balance_in_From_Account() throws Throwable {
	    try {
			Thread.sleep(2000);
			driver.findElement(By.id(config.Outhome())).click();
			Thread.sleep(2000);
			//String AccountBalance = driver.findElement(By.id(config.getbalance())).getText();
			//System.out.println(AccountBalance);
			driver.findElement(By.name(config.Fundtransfer())).click();
			Thread.sleep(2000);
			driver.findElement(By.name(config.Outsidebank())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	@When("^user enters (\\d+), (\\d+) And BOB(\\d+) And click on Funds Transfer$")
	public void user_enters_And_BOB_And_click_on_Funds_Transfer(int arg1, int arg2, int arg3) throws Throwable {
		try {
			driver.findElement(By.name(config.OutToAccount())).clear();
			driver.findElement(By.name(config.OutToAccount())).sendKeys("22446688");
			driver.findElement(By.name(config.OutACholdername())).clear();
			driver.findElement(By.name(config.OutACholdername())).sendKeys("abcd");
			driver.findElement(By.name(config.Outtransferamt())).clear();
			driver.findElement(By.name(config.Outtransferamt())).sendKeys("1");
			driver.findElement(By.name(config.Outremarks())).clear();
			driver.findElement(By.name(config.Outremarks())).sendKeys("transfer1");
			driver.findElement(By.name(config.OutIFSC())).clear();
			driver.findElement(By.name(config.OutIFSC())).sendKeys("BOB12345678");
			driver.findElement(By.name(config.Outtransferfundbutton())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^User (\\d+) should be Debited And (\\d+) should be Credited$")
	public void User_should_be_Debited_And_should_be_Credited(int arg1, int arg2) throws Throwable {
	    
	}

	@When("^user enters (\\d+), (\\d+) And SBI(\\d+) And click on Funds Transfer$")
	public void user_enters_And_SBI_And_click_on_Funds_Transfer(int arg1, int arg2, int arg3) throws Throwable {
		try {
			driver.findElement(By.name(config.OutToAccount())).clear();
			driver.findElement(By.name(config.OutToAccount())).sendKeys("12345678");
			driver.findElement(By.name(config.OutACholdername())).clear();
			driver.findElement(By.name(config.OutACholdername())).sendKeys("xyz");
			driver.findElement(By.name(config.Outtransferamt())).clear();
			driver.findElement(By.name(config.Outtransferamt())).sendKeys("2");
			driver.findElement(By.name(config.Outremarks())).clear();
			driver.findElement(By.name(config.Outremarks())).sendKeys("transfer2");
			driver.findElement(By.name(config.OutIFSC())).clear();
			driver.findElement(By.name(config.OutIFSC())).sendKeys("SBI12345678");
			driver.findElement(By.name(config.Outtransferfundbutton())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("^user enters (\\d+), (\\d+) And ICICI(\\d+) And click on Funds Transfer$")
	public void user_enters_And_ICICI_And_click_on_Funds_Transfer(int arg1, int arg2, int arg3) throws Throwable {
		try {
			driver.findElement(By.name(config.OutToAccount())).clear();
			driver.findElement(By.name(config.OutToAccount())).sendKeys("11223344");
			driver.findElement(By.name(config.OutACholdername())).clear();
			driver.findElement(By.name(config.OutACholdername())).sendKeys("pqrs");
			driver.findElement(By.name(config.Outtransferamt())).clear();
			driver.findElement(By.name(config.Outtransferamt())).sendKeys("3");
			driver.findElement(By.name(config.Outremarks())).clear();
			driver.findElement(By.name(config.Outremarks())).sendKeys("transfer3");
			driver.findElement(By.name(config.OutIFSC())).clear();
			driver.findElement(By.name(config.OutIFSC())).sendKeys("ICIC1234567");
			driver.findElement(By.name(config.Outtransferfundbutton())).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("^close Browser Window$")
	public void close_Browser_Window() throws Throwable {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
