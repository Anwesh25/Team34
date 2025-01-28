package com_TestCases;

import org.testng.annotations.Test;

import com_Luma_Pageobject.Luma_Login;

public class Tc_03_mahesh extends Luma_BaseClass {
	@Test(dataProvider="LumaLoginData")
	public void loginTest(String email, String password) throws InterruptedException {
		Luma_Login ll = new Luma_Login(driver);
		
		ll.setEmail(email);
		ll.setpassword(password);
		Thread.sleep(3000);
		ll.clicksinginbtn();
}}
