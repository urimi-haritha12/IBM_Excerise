package com.ibm.fst.nopcomm.exercise2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {
	
	WebDriver driver;
	
	
		public  LoginPage(WebDriver fdriver) {
			
			driver = fdriver;
			PageFactory.initElements(fdriver, this);
			
		}
		
		
		@FindBy(xpath="//input[@id='Email']")
		WebElement txtemail;
		
		@FindBy(xpath="//input[@id='Password']")
		WebElement txtPwd;
		
		@FindBy(xpath="//input[@type='checkbox' and @name='RememberMe']")
		WebElement checkRem;
		
		@FindBy(xpath="//button[text()='Log in']")
		WebElement btLog;
		
		@FindBy(linkText = "/logout")
		WebElement btlogout;
		
		
		
		
		
		public void logIn(String usname,String pswd,boolean remCheck) {
			
			
			txtemail.clear();
			txtemail.sendKeys(usname);
			
			
			txtPwd.clear();
			txtPwd.sendKeys(pswd);
			
			
			if(remCheck) {
				
				checkRem.click();
			}
			
			
			btLog.click();
			
			
		}
		
		public void verifyApplicationTitle(String pagetitle) {
			
		
			Assert.assertEquals(driver.getTitle(),pagetitle);
			
			
		}
		

		public void logOut() {
			
			btlogout.click();
			
		}

}
