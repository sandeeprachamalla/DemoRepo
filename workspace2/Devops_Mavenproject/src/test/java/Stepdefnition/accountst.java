package Stepdefnition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.ConfigReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class accountst {

	WebDriver driver;
	ConfigReader config = new ConfigReader();

@Given("^User should be logged in Successfully and should be navigated to Account Statement page$")
public void User_should_be_logged_in_Successfully_and_should_be_navigated_to_Account_Statement_page() throws Throwable {
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
		driver.findElement(By.name(config.Accountstatement())).click();
		Thread.sleep(2000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date, End Date and clicks on Search button$")
public void User_selects_Start_Date_End_Date_and_clicks_on_Search_button() throws Throwable {
	try {
		driver.findElement(By.id(config.Startdate())).sendKeys("05/26/2017");
		driver.findElement(By.id(config.Enddate())).sendKeys("05/28/2017");
		driver.findElement(By.id(config.dtsearch())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^User should be able to see all the transaction details with in the selected date range$")
public void User_should_be_able_to_see_all_the_transaction_details_with_in_the_selected_date_range() throws Throwable {
	try {
		WebElement table = driver.findElement(By.id(config.getacctable()));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		if (rows.size()>0) {
			System.out.println("Table is generated for Date filter");
		} else {
			System.out.println("No Records exist for the Selected date range");
		}
	} catch (Exception e) {
		String errmsgfilter = driver.findElement(By.id(config.getNodata())).getText();
		System.out.println(errmsgfilter);
		//System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date, End Date and clicks on Reset button$")
public void User_selects_Start_Date_End_Date_and_clicks_on_Reset_button() throws Throwable {
	try {
		driver.findElement(By.id(config.Startdate())).sendKeys("05/27/2017");
		driver.findElement(By.id(config.Enddate())).sendKeys("05/28/2017");
		Thread.sleep(3000);
		driver.findElement(By.id(config.dtrst())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^Start date and End date fields should be cleared$")
public void Start_date_and_End_date_fields_should_be_cleared() throws Throwable {
	try {
		String strdate=driver.findElement(By.id(config.Startdate())).getText();
		String endate=driver.findElement(By.id(config.Enddate())).getText();
		if (strdate.isEmpty()&& endate.isEmpty()) {
				System.out.println("Start date and End date fields are cleared.");
			
		} else {
				System.out.println("Start date and End date fields are not cleared.");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date greater than today, End Date and clicks on Search button$")
public void User_selects_Start_Date_greater_than_today_End_Date_and_clicks_on_Search_button() throws Throwable {
	try {
		driver.findElement(By.id(config.Startdate())).sendKeys("06/03/2017");
		driver.findElement(By.id(config.Enddate())).sendKeys("06/10/2017");
		driver.findElement(By.id(config.dtsearch())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^Proper error message should be dispalyed #Start date cannot be greater than Today#$")
public void Proper_error_message_should_be_dispalyed_Start_date_cannot_be_greater_than_Today() throws Throwable {
	try {
		String errmsgfilter = driver.findElement(By.id(config.getNodata())).getText();
		System.out.println(errmsgfilter);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date greater than today, End Date less than or equal to Today and clicks on Search button$")
public void User_selects_Start_Date_greater_than_today_End_Date_less_than_or_equal_to_Today_and_clicks_on_Search_button() throws Throwable {
	try {
		driver.findElement(By.id(config.Startdate())).sendKeys("06/04/2017");
		driver.findElement(By.id(config.Enddate())).sendKeys("05/30/2017");
		driver.findElement(By.id(config.dtsearch())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^Proper error message should be dispalyed #Start date cannot be greater than Today and End date cannot be less than Start date#$")
public void Proper_error_message_should_be_dispalyed_Start_date_cannot_be_greater_than_Today_and_End_date_cannot_be_less_than_Start_date() throws Throwable {
	Proper_error_message_should_be_dispalyed_Start_date_cannot_be_greater_than_Today();
}

@When("^User selects All and clicks on Apply Filter button$")
public void User_selects_All_and_clicks_on_Apply_Filter_button() throws Throwable {
    try {
		WebElement Trtypedrop = driver.findElement(By.id(config.Trantypedrop()));
		Select Trtype1=new Select(Trtypedrop);
		Trtype1.selectByVisibleText("All");
		driver.findElement(By.id(config.Applyfilter())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^User should be able to see all the transaction details of the selected Transaction Type$")
public void User_should_be_able_to_see_all_the_transaction_details_of_the_selected_Transaction_Type() throws Throwable {
	try {
		WebElement table = driver.findElement(By.id(config.getacctable()));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		if (rows.size()>0) {
			System.out.println("Table is generated for the Selected Transaction type filter");
		} else {
			System.out.println("No Records exist for the Selected Transaction type");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Credit and clicks on Apply Filter button$")
public void User_selects_Credit_and_clicks_on_Apply_Filter_button() throws Throwable {
	try {
		WebElement Trtypedrop = driver.findElement(By.id(config.Trantypedrop()));
		Select Trtype2=new Select(Trtypedrop);
		Trtype2.selectByVisibleText("Credit");
		driver.findElement(By.id(config.Applyfilter())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Debit and clicks on Apply Filter button$")
public void User_selects_Debit_and_clicks_on_Apply_Filter_button() throws Throwable {
	try {
		WebElement Trtypedrop = driver.findElement(By.id(config.Trantypedrop()));
		Select Trtype3=new Select(Trtypedrop);
		Trtype3.selectByVisibleText("Debit");
		driver.findElement(By.id(config.Applyfilter())).click();
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date, End Date and All and clicks on Apply Filter button$")
public void User_selects_Start_Date_End_Date_and_All_and_clicks_on_Apply_Filter_button() throws Throwable {
	try {
		driver.findElement(By.name(config.Startdate())).clear();
		driver.findElement(By.name(config.Startdate())).sendKeys("05/20/2017");
		driver.findElement(By.name(config.Enddate())).clear();
		driver.findElement(By.name(config.Enddate())).sendKeys("05/26/2017");
		User_selects_All_and_clicks_on_Apply_Filter_button();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^User should be able to see all the transaction details with in the selected date range and selected Transaction Type$")
public void User_should_be_able_to_see_all_the_transaction_details_with_in_the_selected_date_range_and_selected_Transaction_Type() throws Throwable {
	try {
		WebElement table = driver.findElement(By.id(config.getacctable()));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		if (rows.size()>0) {
			System.out.println("Table is generated for the Selected Date range and Transaction type filters");
		} else {
			System.out.println("No Records exist for the Selected Date range and Transaction type");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date, End Date and Credit and clicks on Apply Filter button$")
public void User_selects_Start_Date_End_Date_and_Credit_and_clicks_on_Apply_Filter_button() throws Throwable {
	try {
		driver.findElement(By.name(config.Startdate())).clear();
		driver.findElement(By.name(config.Startdate())).sendKeys("05/20/2017");
		driver.findElement(By.name(config.Enddate())).clear();
		driver.findElement(By.name(config.Enddate())).sendKeys("05/26/2017");
		User_selects_Credit_and_clicks_on_Apply_Filter_button();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@When("^User selects Start Date, End Date and Debit and clicks on Apply Filter button$")
public void User_selects_Start_Date_End_Date_and_Debit_and_clicks_on_Apply_Filter_button() throws Throwable {
	try {
		driver.findElement(By.name(config.Startdate())).clear();
		driver.findElement(By.name(config.Startdate())).sendKeys("05/20/2017");
		driver.findElement(By.name(config.Enddate())).clear();
		driver.findElement(By.name(config.Enddate())).sendKeys("05/26/2017");
		User_selects_Debit_and_clicks_on_Apply_Filter_button();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@Then("^close Browser window$")
public void close_Browser_window() throws Throwable {
	try {
		driver.quit();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

}
