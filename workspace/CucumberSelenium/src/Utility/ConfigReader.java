package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties pro;
	public ConfigReader(){
		try {
			File src = new File("ObjectRepo.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		} 
	}
	
	public String getChromepath(){
		return pro.getProperty("Chromedriver");		
	}
	
	public String getIEpath(){
		return pro.getProperty("IEdriver");		
	}
	
	public String getFirefoxpath(){
		return pro.getProperty("Firefoxdriver");		
	}
	
	public String getapplicationurl1(){
		return pro.getProperty("HTTPBankurl");		
	}
	
	public String getapplicationurl2(){
		return pro.getProperty("HTTPSBankurl");			
	}

	public String getUsername(){
		return pro.getProperty("Username");
	}
	
	public String getUsernamexpath(){
		return pro.getProperty("Usernamexpath");
	}
	
	public String enteruname(){
		return pro.getProperty("uname");
	}
	
	public String enterucuname(){
		return pro.getProperty("ucuname");
	}
	
	public String getPassword(){
		return pro.getProperty("Password");
	}
	
	public String getPasswordxpath(){
		return pro.getProperty("Passwordxpath");
	}
	
	public String enterpwd(){
		return pro.getProperty("pwd");
	}
	
	public String SubmitXpath(){
		return pro.getProperty("SubmitXpath");
	}
	
	public String ResetName(){
		return pro.getProperty("ResetName");
	}
	
	public String ResetXpath(){
		return pro.getProperty("ResetXpath");
	}
	
	public String SubmitName(){
		return pro.getProperty("SubmitName");
	}
	
	public String Welcomemsg(){
		return pro.getProperty("Welcomemsg");
	}
	
	public String Welcomemsgxpath(){
		return pro.getProperty("Welcomemsgxpath");
	}
	
	public String Hello(){
		return pro.getProperty("Hello");
	}
	
	public String Helloxpath(){
		return pro.getProperty("Helloxpath");
	}
	
	public String Uname(){
		return pro.getProperty("Uname");
	}
	
	public String Unamexpath(){
		return pro.getProperty("Unamexpath");
	}
	
	public String Errormsg(){
		return pro.getProperty("Errormsg");
	}
	
	public String uname1(){
		return pro.getProperty("uname1");
	}
	
	public String pwd1(){
		return pro.getProperty("pwd1");
	}
	
	public String uname2(){
		return pro.getProperty("uname2");
	}
	
	public String pwd2(){
		return pro.getProperty("pwd2");
	}
	
	public String Accountstatement(){
		return pro.getProperty("Accountst");
	}
	
	public String Accountstatementxpath(){
		return pro.getProperty("Accountstxpath");
	}
	
	public String Fundtransfer(){
		return pro.getProperty("Fundtr");
	}
	
	public String Fundtransferxpath(){
		return pro.getProperty("Fundtrxpath");
	}
	
	public String Logout(){
		return pro.getProperty("logout");
	}
	
	public String Logoutxpath(){
		return pro.getProperty("logoutxpath");
	}
	
	public String Home(){
		return pro.getProperty("Home");
	}
	
	public String Homexpath(){
		return pro.getProperty("Homexpath");
	}
	
	public String Contact(){
		return pro.getProperty("Contact");
	}
	
	public String Contactxpath(){
		return pro.getProperty("Contactxpath");
	}
	
	public String Services(){
		return pro.getProperty("Services");
	}
	
	public String Servicesxpath(){
		return pro.getProperty("Servicesxpath");
	}
	
}
