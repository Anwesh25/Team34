package com_TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_Luma_Pageobject.Luma_RegistrationPage;

public class TC_01_Luma_Registration extends Luma_BaseClass{
//	public Luma_RegistrationPage lr;
	@Test
	public void LumaRegistration() {
		Luma_RegistrationPage lr  =new Luma_RegistrationPage(driver);
		lr.createAnAccountLink();
		log.info("Luma Create An Account link as Clicked");
		lr.setFirstName(FName);
		log.info("First Name entered Successfully");
		lr.setLastName(LName);
		log.info("Last Name entered Successfully");
		lr.setEmailAddress(EmailAdd);
		log.info("Email Address entered Successfully");
		lr.setpassword(Password);
		log.info("Password entered Successfully");
		lr.setconfirmpassword(CPassword);
		log.info("Confirm Password entered Successfully");
		lr.clickcreateAnAccount();
		
/*		
		String act_title = driver.getTitle();
		String Exp_title = "My Account12";
		
		if(act_title.equals(Exp_title)) {
			Assert.assertTrue(true);
			System.out.println("Testcase has passed");
		}
		else {
			System.out.println("Testcase has failed");
			Assert.assertTrue(false);
		}
	}
*/
	
}
}
