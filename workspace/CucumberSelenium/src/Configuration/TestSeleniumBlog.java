package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ConfigReader;

public class TestSeleniumBlog {
	
	@Test
	public void testConfig() throws Exception{
		
		ConfigReader config = new ConfigReader();
		WebDriver driver =  new ChromeDriver();
		driver.get(config.getapplicationurl1());
		driver.get(config.getapplicationurl2());
		
		/*String HTTPurl = pro.getProperty("HTTPBankurl");
		String HTTPSurl = pro.getProperty("HTTPSBankurl");
		String Username = pro.getProperty("Username");
		String Password = pro.getProperty("Password");
		String SubmitName = pro.getProperty("SubmitName");
		String SubmitXpath = pro.getProperty("SubmitXpath");
		
		System.out.println("url1 is "+HTTPurl);
		System.out.println("url2 is "+HTTPSurl);
		System.out.println("username is "+Username);
		System.out.println("password is "+Password);
		System.out.println("submitname is "+SubmitName);
		System.out.println("submitxpath is "+SubmitXpath);*/
		}

}
