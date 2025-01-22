package com_Luma_Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Login {
	//3 parts
	//1 Constructor, 2 Element identification, 3 creating an action
	
	public WebDriver driver;
	public Luma_Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id ="email")
	WebElement txtemail;
	
	@FindBy(id="pass")
	WebElement txtpassword;
	
	@FindBy(id="send2")
	WebElement btnsingin;
	
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clicksinginbtn() {
		btnsingin.click();
	}
	
	public void ClearEmail() {
		txtemail.clear();
	}
	
	public void ClearPassword() {
		txtpassword.clear();
	}
	
	
	
	
	
	
	
}
