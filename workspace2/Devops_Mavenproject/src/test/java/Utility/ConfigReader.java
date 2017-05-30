package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {
	Properties pro;
	public ConfigReader(){   // Created constructor to Initialize data
		
			try {
				File src= new File("ObjectRepo.properties");
				FileInputStream fis = new FileInputStream(src);
				pro=new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is=="+e.getMessage());
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
	
	public String Fundtrbutton(){
		return pro.getProperty("Fundtrbutton");
	}
	
	public String Fundtrbuttonxpath(){
		return pro.getProperty("Fundtrbuttonxpath");
	}
	
	public String Logout(){
		return pro.getProperty("logout");
	}
	
	public String Logoutxpath(){
		return pro.getProperty("logoutxpath");
	}
	
	public String Home(){
		return pro.getProperty("Homebutton");
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
	
	public String Offers(){
		return pro.getProperty("Offers");
	}
	
	public String Offersxpath(){
		return pro.getProperty("Offersxpath");
	}
	
	public String Accountdetails(){
		return pro.getProperty("Accountdetails");
	}
	
	public String Accountdetailsxpath(){
		return pro.getProperty("Accountdetailsxpath");
	}
	
	public String getwithinbank() {
		return pro.getProperty("withbnk");
	}
	
	public String Withinbankxpath() {
		return pro.getProperty("Withinbankxpath");
	}
	
	public String Outhome() {
		return pro.getProperty("Outhome");
	}
	
	public String Outhomexpath() {
		return pro.getProperty("Outhomexpath");
	}
	
	public String Outsidebank() {
		return pro.getProperty("Outsidebank");
	}
	
	public String Outsidebankxpath() {
		return pro.getProperty("Outsidebankxpath");
	}
	
	public String getbalance() {
		return pro.getProperty("currblc");
	}
	public String withintoacc() {
		return pro.getProperty("withbnktoacc");
	}
	public String accholder() {
		return pro.getProperty("acchlder");
	}
	public String transferamt() {
		return pro.getProperty("trnfamt");
	}
	public String transactionremark() {
		return pro.getProperty("rmk");
	}
	public String ftransfer() {
		return pro.getProperty("ft");
	}
	public String FundMessage() {
		return pro.getProperty("ftmsg");
	}
	
	public String OutToAccount() {
		return pro.getProperty("OutToAccount");
	}
	public String OutToAccountxpath() {
		return pro.getProperty("OutToAccountxpath");
	}
	
	public String OutACholdername() {
		return pro.getProperty("OutACholdername");
	}
	public String OutACholdernamexpath() {
		return pro.getProperty("OutACholdernamexpath");
	}
	
	public String Outtransferamt() {
		return pro.getProperty("Outtransferamt");
	}
	public String Outtransferamtxpath() {
		return pro.getProperty("Outtransferamtxpath");
	}
	
	public String Outremarks() {
		return pro.getProperty("Outremarks");
	}
	public String Outremarksxpath() {
		return pro.getProperty("Outremarksxpath");
	}
	
	public String OutIFSC() {
		return pro.getProperty("OutIFSC");
	}
	public String OutIFSCxpath() {
		return pro.getProperty("OutIFSCxpath");
	}
	
	public String Outtransferfundbutton() {
		return pro.getProperty("Outtransferfundbutton");
	}
	public String Outtransferfundbuttonxpath() {
		return pro.getProperty("Outtransferfundbuttonxpath");
	}
	
	public String Outtransfermsg() {
		return pro.getProperty("Outtransfermsg");
	}
	
	public String Trantypedrop() {
		return pro.getProperty("Trantypedrop");
	}
	
	public String Trantypedropxpath() {
		return pro.getProperty("Trantypedropxpath");
	}
	
	public String Applyfilter() {
		return pro.getProperty("Applyfilter");
	}
	
	public String Applyfilterxpath() {
		return pro.getProperty("Applyfilterxpath");
	}
	
	public String Startdate() {
		return pro.getProperty("Startdate");
	}
	
	public String Startdatexpath() {
		return pro.getProperty("Startdatexpath");
	}
	
	public String Enddate() {
		return pro.getProperty("Enddate");
	}
	
	public String Enddatexpath() {
		return pro.getProperty("Enddatexpath");
	}
	
	public String dtsearch() {
		return pro.getProperty("dtsearch");
	}
	public String getacctable() {
		return pro.getProperty("tablestat");
	}
	public String getNodata() {
		return pro.getProperty("nodata");
	}
	public String dtrst() {
		return pro.getProperty("rstdt");
	}
	
}
