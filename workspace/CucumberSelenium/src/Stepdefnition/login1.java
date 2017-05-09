package Stepdefnition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login1 {
	
	WebDriver driver;
    String HTTPBankurl="http://10.219.73.115:8034/Pid_G_v8.0/faces/login.jsp";
    String HTTPSBankurl="https://10.219.73.115:8034/Pid_G_v8.0/faces/login.jsp";
    String url="http://10.219.73.115:8034/Pid_G_v8.0/faces/login.jsp";
	String incorrect_pwd;
	String err_msg;
	@Given("^Bank URL is setup$")
	public void Bank_URL_is_setup() throws Throwable {
		
	}

	@Given("^open Chrome browser and launch the Bank url with HTTP prefix$")
	public void open_Chrome_browser_and_launch_the_Bank_url_with_HTTP_prefix() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@When("^I click on Enter button$")
	public void I_click_on_Enter_button() throws Throwable {
	    
	}

	@Then("^Bank URL should be accessible and user should be directed to User Login page successfully$")
	public void Bank_URL_should_be_accessible_and_user_should_be_directed_to_User_Login_page_successfully() throws Throwable {
		driver.get(HTTPBankurl);
		System.out.println("Redirected to User Login page");
	}

	@Given("^open Chrome browser and launch the Bank url with HTTPS prefix$")
	public void open_Chrome_browser_and_launch_the_Bank_url_with_HTTPS_prefix() throws Throwable {
		open_Chrome_browser_and_launch_the_Bank_url_with_HTTP_prefix();
		
	}

	@Then("^Bank URL should not be accessible$")
	public void Bank_URL_should_not_be_accessible() throws Throwable {
		driver.get(HTTPSBankurl);
		System.out.println("Failed to open User Login page");
	}

	@Given("^Registered user is configured in system$")
	public void Registered_user_is_configured_in_system() throws Throwable {
	    
	}

	@Given("^open Chrome and launch the Bank url$")
	public void open_Chrome_and_launch_the_Bank_url() throws Throwable {
		open_Chrome_browser_and_launch_the_Bank_url_with_HTTP_prefix();
		Bank_URL_should_be_accessible_and_user_should_be_directed_to_User_Login_page_successfully();
		
	}

	@When("^I enter the valid user credentials in User Login page$")
	public void I_enter_the_valid_user_credentials_in_User_Login_page() throws Throwable {
		//driver.findElement(By.name("j_id_jsp_1344918962_3:j_id_jsp_1344918962_6")).sendKeys("sachin");
		//driver.findElement(By.name("j_id_jsp_1344918962_3:j_id_jsp_1344918962_8")).sendKeys("abcd@123");
		JavascriptExecutor myexec = ((JavascriptExecutor)driver);
		myexec.executeScript("document.getElementsByName('j_id_jsp_1919620467_3:j_id_jsp_1919620467_6')[0].value='infy'");
		myexec.executeScript("document.getElementsByName('j_id_jsp_1919620467_3:j_id_jsp_1919620467_8')[0].value='infy@123'");
	}
	
	@When("^I click on Submit button$")
	public void I_click_on_Submit_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id='j_id_jsp_1919620467_3']/center/div/input[1]")).click();
		//Thread.sleep(3000);
	}
	
	@When("^I click on Submit button for incorrect pwd$")
	public void I_click_on_Submit_button_for_incorrect_pwd() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_9")).click();
		Thread.sleep(3000);
	}

	@Then("^User should be logged in successfully$")
	public void User_should_be_logged_in_successfully() throws Throwable {
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Infosys Devops Bank:Home")){
			System.out.println("U are on Bank Home Page");
			
		}
		else{
			System.out.println("Bank Home Page not displayed");
		}
	}

	@Then("^User homepage should have Username entry in the screen$")
	public void User_homepage_should_have_Username_entry_in_the_screen() throws Throwable {
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.id("_932443"));
		System.out.println(e1.getText());
	    	if(e1.getText().equals("Welcome to Retail eBanking !")){
	    	 System.out.println("User Logged in Successfully");
	    }
	    	else{
	    		System.out.println("User Login Failed");
	    	}
	    	
	    Thread.sleep(5000);
	    
	    WebElement e2 = driver.findElement(By.id("j_id_jsp_803499467_5:_1234"));
	    WebElement e3 = driver.findElement(By.id("j_id_jsp_803499467_5:_1235"));
	    String e4 = e2.getText()+" "+ e3.getText();
	    System.out.println(e4);
	    
		 try{
		    	if(e4.equals("Hello infy")){
		    	 System.out.println("User name is displayed Successfully");
		    }
		    	else if(e4.equals("Hello INFY")){
		    		System.out.println("User name is displayed in Upper Case");
		    	}
		    	else{
		    		System.out.println("User name not displayed");
		    	}
		    	
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		 
	}

	@Given("^open Firefox and launch the Bank url$")
	public void open_Firefox_and_launch_the_Bank_url() throws Throwable {
		
	}

	@Given("^open IE and launch the Bank url$")
	public void open_IE_and_launch_the_Bank_url() throws Throwable {
		System.setProperty("webdriver.ie.driver","D:\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		Bank_URL_should_be_accessible_and_user_should_be_directed_to_User_Login_page_successfully();
	}

	@Given("^open Chrome browser and launch the Bank url$")
	public void open_Chrome_browser_and_launch_the_Bank_url() throws Throwable {
		open_Chrome_and_launch_the_Bank_url();
	}

	@When("^I enter UPPERCASE username and valid password in User Login page$")
	public void I_enter_UPPERCASE_username_and_valid_password_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("INFY");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("infy@123");
	}

	@When("^I enter LOWERCASE username and valid password in User Login page$")
	public void I_enter_LOWERCASE_username_and_valid_password_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("infy");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("infy@123");
	}

	@When("^I enter valid username and password is left blank in User Login page$")
	public void I_enter_valid_username_and_password_is_left_blank_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("infy");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("");
	}

	@Then("^User should not be logged in successfully$")
	public void User_should_not_be_logged_in_successfully() throws Throwable {
		
		
	}

	@Then("^Error message should be displayed #\"([^\"]*)\"$")
	public void Error_message_should_be_displayed_(String arg1) throws Throwable {
		String Errormsg = driver.findElement(By.className("errormsg")).getText();
		System.out.println(Errormsg);
	}

	@When("^I enter the password and Username is left blank in User Login page$")
	public void I_enter_the_password_and_Username_is_left_blank_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("devops@1233");
	}

	@When("^I enter the valid username and invalid password in User Login page$")
	public void I_enter_the_valid_username_and_invalid_password_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("infy");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("abcd@1234");
	}

	@Then("^User login should fail$")
	public void User_login_should_fail() throws Throwable {
	    
	}

	@Given("^User is not registered in the system$")
	public void User_is_not_registered_in_the_system() throws Throwable {
	    
	}

	@When("^I enter username and password in User Login page$")
	public void I_enter_username_and_password_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("aabbccdd");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("abcd@1234");
	}

	@Then("^Error message should be displayed #\"([^\"]*)\"#\"([^\"]*)\"$")
	public void Error_message_should_be_displayed_(String arg1, String arg2) throws Throwable {
		String Errormsg = driver.findElement(By.className("errormsg")).getText();
		System.out.println(Errormsg);
	}

	@Then("^Error message for invalid password should be displayed #\"([^\"]*)\"$")
	public void Error_message_for_invalid_password_should_be_displayed_(String arg1) throws Throwable {
		String incorrect_pwd=driver.findElement(By.className("errormsg")).getText();
		System.out.println(incorrect_pwd);
	}
	
//
//	
	
	@When("^I enter valid akash and invalid (\\d+)@(\\d+) in User Login page$")
	public void I_enter_valid_akash_and_invalid_in_User_Login_page(int arg1, int arg2) throws Throwable {	
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("lavanya");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("pass@12");
	}
	
	@Then("^User Account should be locked$")
	public void User_Account_should_be_locked() throws Throwable {
	}
	
	@Then("^a message should be displayed saying that Account is locked #\"([^\"]*)\"$")
	public void a_message_should_be_displayed_saying_that_Account_is_locked_(String arg1) throws Throwable {
		String err_msg=driver.findElement(By.cssSelector("#j_id_jsp_1919620467_3 > span")).getText();
		System.out.println(err_msg);					
		if (err_msg.equals("You have reached maximum incorrect login attempts. Your account has been locked. Please contact nearest Branch")) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}
	}
	
	@When("^I enter valid akash and invalid vrr@(\\d+) in User Login page$")
	public void I_enter_valid_akash_and_invalid_vrr_in_User_Login_page(int arg1) throws Throwable {
		
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("lavanya");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("pass@1");
		Thread.sleep(3000);
	}

	@When("^I enter valid akash and invalid ina@(\\d+) in User Login page$")
	public void I_enter_valid_akash_and_invalid_ina_in_User_Login_page(int arg1) throws Throwable {
		
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("lavanya");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("ina@123");
		Thread.sleep(2000);
	}


	@When("^I enter valid akash and invalid abcda in User Login page$")
	public void I_enter_valid_akash_and_invalid_abcda_in_User_Login_page() throws Throwable {

		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("lavanya");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("abcda");
		Thread.sleep(2000);
	}
	
	@When("^I enter valid username and valid password in User Login page$")
	public void I_enter_valid_username_and_valid_password_in_User_Login_page() throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("aniket");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("aniket");
		Thread.sleep(3000);

	}
	
	@Then("^User Account should be locked and not able to log in$")
	public void User_Account_should_be_locked_and_not_able_to_log_in() throws Throwable { 
	}
	
	@When("^I enter (\\d+) characters in username field in User Login page$")
	public void I_enter_characters_in_username_field_in_User_Login_page(int arg1) throws Throwable {
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("mynameisakash");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("abcd");
	}
	
	@Then("^User Id should not allow more than ten characters$")
	public void User_Id_should_not_allow_more_than_ten_characters() throws Throwable {
		String ten_char=driver.findElement(By.cssSelector("#j_id_jsp_1919620467_3 > ul > li")).getText();
		System.out.println(ten_char);
		if (ten_char.equals("username should be less than or equal to 10 character.")) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}
	}
	
	@Then("^User should be able to see Account Details Option in User homepage and click it$")
	public void User_should_be_able_to_see_Account_Details_Option_in_User_homepage_and_click_it() throws Throwable {
		String acc_statement=driver.findElement(By.name("j_id_jsp_803499467_5:j_id_jsp_803499467_7")).getText();
		System.out.println(acc_statement); //GETTING BLANK TEXT/
		driver.findElement(By.name("j_id_jsp_803499467_5:j_id_jsp_803499467_7")).click();
		String acc_title=driver.getTitle();
		System.out.println(acc_title);
		if (acc_title.equals("Infosys Devops Bank: Account Statement")) {
			System.out.println("Account statement page is displayed");
		} else {
			System.out.println("Account statement page is not displayed");
		}
	}
	
	@Then("^User should be able to see Funds Transfer Option in User homepage and click it$")
	public void User_should_be_able_to_see_Funds_Transfer_Option_in_User_homepage_and_click_it() throws Throwable {
		Thread.sleep(3000);
		String fund_t=driver.findElement(By.name("j_id_jsp_803499467_5:j_id_jsp_803499467_8")).getText();
		System.out.println(fund_t); //GETTING BLANK TEXT/
		driver.findElement(By.name("j_id_jsp_803499467_5:j_id_jsp_803499467_8")).click();
		String f_t=driver.getTitle();
		Thread.sleep(3000);
		System.out.println(f_t);
		if (f_t.equals("Infosys Devops Bank:Fund Transfer")) {
			System.out.println("Test Succeessful");
		} else {
			System.out.println("Test UnSucceessful");
		}
	}
	
	@Given("^User is logged in successfully$")
	public void User_is_logged_in_successfully() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(HTTPBankurl);
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_6")).sendKeys("aniket");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_8")).sendKeys("aniket");
		driver.findElement(By.name("j_id_jsp_1919620467_3:j_id_jsp_1919620467_9")).click();
	//   
	}
	
	@When("^I click on Back button$")
	public void I_click_on_Back_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.navigate().back();			//NOT WORKING right now//
	    System.out.println("Work is in Progress");
	}
	
	@When("^I click on Logout button$")
	public void I_click_on_Logout_button() throws Throwable {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Then("^User should be logged out successfully$")
	public void User_should_be_logged_out_successfully() throws Throwable {
		String login_title=driver.getTitle();
		System.out.println(login_title);
		if (login_title.equals("Infosys Devops Bank:Login")) {
			System.out.println("User logged out Successfully");
			
		} else {
			System.out.println("User Logged out is UnSuccessfully");
		}
	}
	
	@Then("^Close Browser Window$")
	public void Close_Browser_Window() throws Throwable {
	   driver.quit();
	}

}
