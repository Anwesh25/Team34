package com_Luma_Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_RegistrationPage {
	//divided into 3 parts
	//1) Constructor, 2) Identify the elements, 3) Create an action
	
	public WebDriver driver;  
	public Luma_RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//2) Identify the elements
	
	// WebElement a = driver.findelement(By.id="wertyuj");
	@FindBy (xpath = "(//a[text()='Create an Account'])[1]")
	WebElement linkCreateAnAccount;
	
	@FindBy (id= "firstname")
	WebElement txtFirstName;
	
	@FindBy (id="lastname")
	WebElement txtLastName;
	
	@FindBy (id="email_address")
	WebElement txtemailAddress;
	
	@FindBy (id="password")
	WebElement txtpassword;
	
	@FindBy (id="password-confirmation")
	WebElement txtCPassword;
	
	@FindBy (xpath = "//button[@title='Create an Account']")
	WebElement btnCreateAnAccount;
	
//	3 Create an action
	
	public void createAnAccountLink() {
		linkCreateAnAccount.click();
	}
	
	public void setFirstName(String Fname) {
		txtFirstName.sendKeys(Fname);
	}
	
	public void setLastName(String LName) {
		txtLastName.sendKeys(LName);
	}
	
	public void setEmailAddress(String Email) {
		txtemailAddress.sendKeys(Email);
	}
	
	public void setpassword(String Password) {
		txtpassword.sendKeys(Password);
	}
	
	public void setconfirmpassword(String CPassword) {
		txtCPassword.sendKeys(CPassword);
	}
	
	public void clickcreateAnAccount() {
		btnCreateAnAccount.click();
	}
	
	
}
