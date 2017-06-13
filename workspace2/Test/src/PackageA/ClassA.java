package PackageA;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ClassA {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	    
	    driver.findElement(By.name("email")).sendKeys("Marina@gmail.com");
	    driver.findElement(By.name("pass")).sendKeys("Infy123");
	    driver.findElement(By.xpath("//input[@value='Log In']")).click();
	    Thread.sleep(4000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium2\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.facebook.com/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  if(driver.getTitle().equals("Log in to Facebook | Facebook")){
		  System.out.println("Login failed");
	  }
	  else{
		  System.out.println("Login is successfull");
	  }
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
